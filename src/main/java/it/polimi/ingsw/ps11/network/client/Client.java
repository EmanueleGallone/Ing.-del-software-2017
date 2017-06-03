package it.polimi.ingsw.ps11.network.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

import it.polimi.ingsw.ps11.cranio.player.Player;

public class Client extends Thread {
	private final static int PORT = 60000;		//da cambiare lo static
	private Player player;
	private Scanner keyboard;
	private PrintStream out;
	private BufferedReader in;
	private Socket socket;
    private String responseLine, mode;
    private Object read;
    private ClientController controller;
    
    /* Il main thread manda via socket ciò che legge da tastiera
     * Il nuovo Thread di riga 39 legge l'input da socket, lo deserializza e lo passa al controller
     * Quando il controller ha bisogno, chiama la funzione send di riga 68 per serializzare e poi mandare via socket
     */
	
	public static void main(String[] args) {
		try {
			Socket socket = new Socket( InetAddress.getLocalHost() , PORT );
			new Thread(new Client(socket)).start();
		} catch (IOException e) {
			System.err.println("Errore, nessun Server a cui collegarsi");
		}
		/*while (true) {
	         out.println(keyboard.nextLine());
	     }*/
	}
	
	public Client(Socket socket) {
		keyboard = new Scanner(System.in);
		System.out.println("Inserire nome Giocatore");
		this.socket = socket;
		this.player = new Player();
		this.player.setName(keyboard.nextLine());
		System.out.println("Scegliere modalità di gioco: testuale o grafica?");
		mode = keyboard.nextLine();
		/*while(mode.toLowerCase()!= "testuale" && mode.toLowerCase()!="grafica"){
			System.out.println("Errore nell'input. Digitare \"testuale\" o \"grafica\"");
			mode = keyboard.nextLine();
		}*/
	}
	
	public void run(){
		setup();
		while(true){
			try{
				read = in.readLine();
				System.out.println(read);
				/*read = deserialize(in.readLine());
				if(read.getClass().equals(String.class)) System.out.println(read);
				else ClientController.activate(read);*/
		}catch (IOException e) {				
			System.err.println("Errore nella lettura");;
		}
		}	
	}
	
	public void send(Object object){
		out.println(serialize(object));
	}
	
	private String serialize(Object object) {
		return null;
	}

	private Object deserialize(String responseLine) {
		return null;
	}

	private void setup(){
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		    out = new PrintStream(socket.getOutputStream());
		    out.println(player.getName());
			System.out.println(in.readLine());
			read = in.readLine();
			System.out.println(read);
			System.out.println(read);
			
			controller = new ClientController(mode, read);
			
		} catch (IOException e) {
			System.err.println("Errore nella lettura di I/O da socket");;
		}
}
	}
