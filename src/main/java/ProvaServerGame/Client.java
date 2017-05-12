package ProvaServerGame;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client extends Observable<String> implements Runnable {	//classe apposita, che modifica il classico obsrver/obserable
																				
	private static Socket socket;
	
	private Scanner in;
	
	private DataOutputStream out;
	
	private ServerGioco server;
	
	private String name;
	
	private boolean active = true, available = false;
	
	private ExecutorService executor;
	
	public Client(Socket socket, ServerGioco server, ExecutorService executor) {
		this.socket = socket;
		this.server = server;
		this.executor = executor;
		
	}
	
public static void main (String[] args) throws InterruptedException{
		
		System.out.println("Connessione in corso al server...");
		try {
			Socket socket = new Socket( InetAddress.getLocalHost() , ServerGioco.PORT );
		} catch (UnknownHostException e) {
			System.err.println("Errore nella connessione");
		} catch (IOException e) {
			System.err.println("Errore nella connessione");
		};
		
	}
	
	@Override
	public void run() {
		
		System.out.println("Inserire nome Giocatore");								
		try{
			BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
			out = new DataOutputStream(socket.getOutputStream());
			out.flush();
			String read = tastiera.readLine();//prende il nome del giocatore
			name = read;
			server.waitingGame(this, name);					//parte il randevous
			System.out.println("In attesa di una partita");								
			while(active){
				System.out.println("Messaggi");								
				read = in.nextLine();				
				notify(read);								//il testo va alla view associata, che osserva la connessione
				if(read.toLowerCase()== "esci" ){
					active = false;
				}
			}			
		} catch (IOException | NoSuchElementException e) {
			System.err.println("Errore!");
		}
			close();		
	}

	
	public void asyncSend(final String message){			//asincrono, thread apposito per i messaggi
		new Thread(new Runnable() {			
			@Override
			public void run() {
				try {
					out.writeBytes(message);
					out.flush();
				} catch (IOException e) {
					System.err.println("Messaggio non inviato!");
				}											
			}
		}).start();
	}
	
	public synchronized void closeConnection() {		
		
		try {
			out.writeBytes("Connessione terminata");								
			out.flush();
			socket.close();
		} catch (IOException e) {
			System.err.println("Errore nell chiusura!");
		}
		active = false;
	}
	
	private void close() {
		closeConnection();		
		System.out.println("Deregistro il client!");
		server.deregisterConnection(this);
	}
	
	
	//		executor.submit(this);				//Equivalente a new Thread(c).start();				//lo affido ad un thread	

}