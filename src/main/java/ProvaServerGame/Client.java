package ProvaServerGame;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Client extends Observable<String> implements Runnable {	//classe apposita, che modifica il classico obsrver/obserable
																			
	private Socket socket;
	
	private Scanner in;
	
	private PrintStream out;
	
	private ServerGioco server;
	
	private String name;
	
	private boolean active = true;
	
	public Client(Socket socket, ServerGioco server) {
		this.socket = socket;
		this.server = server;					
	}
	
	private synchronized boolean isActive(){
		return active;
	}
	
	@Override
	public void run() {
		try{
			in = new Scanner(socket.getInputStream());
			out = new PrintStream(socket.getOutputStream());
			out.println("Inserire nome Giocatore");								
			out.flush();
			String read = in.nextLine();					//prende il nome del giocatore
			name = read;
			server.waitingGame(this, name);					//parte il randevous
			try{
				Lobby.Players(this, name);
			} catch (NoSuchElementException e){
				System.err.println("Attendere creazione della Lobby");
			}
			while(isActive()){
				read = in.nextLine();				
				notify(read);								//il testo va alla view associata, che osserva la connessione
			}			
		} catch (IOException | NoSuchElementException e) {
			System.err.println("Errore!");
		}finally{
			close();
		}		
	}

	
	public void asyncSend(final String message){			//asincrono, thread apposito per i messaggi
		new Thread(new Runnable() {			
			@Override
			public void run() {
				out.println(message);								
				out.flush();				
			}
		}).start();
	}
	
	public synchronized void closeConnection() {		
		out.println("Connessione terminata");								
		out.flush();
		try {
			socket.close();
		} catch (IOException e) {
		}
		active = false;
	}
	
	private void close() {
		closeConnection();		
		System.out.println("Deregistro il client!");
		server.deregisterConnection(this);
	}

}