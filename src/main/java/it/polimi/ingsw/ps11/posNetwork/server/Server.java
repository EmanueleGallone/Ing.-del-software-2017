package it.polimi.ingsw.ps11.posNetwork.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import it.polimi.ingsw.ps11.posNetwork.Connection;
import it.polimi.ingsw.ps11.posNetwork.server.messages.DefaultServerMessage;
import it.polimi.ingsw.ps11.posNetwork.server.messages.StampaBlu;


public class Server implements Runnable {	
	
	private static final int PORT = 60000;
	
	private GamesManager gamesManager;
	private ArrayList<Connection> connection = new ArrayList<>();
	ServerSocket serverSocket;
	
	public Server() throws IOException {
		gamesManager = new GamesManager(); // La lobby andrà caricata da file
		serverSocket = new ServerSocket(PORT);
	}
	
	private void listen() throws IOException{
	  Socket socket = serverSocket.accept();
	  Connection connection = new Connection(socket);
	  
	  connection.on();
	  System.out.println("New connection");
	  DefaultServerMessage m = new DefaultServerMessage("Ciao");
	  connection.send(m);
	  connection.send(new StampaBlu("bo"));

	 // gamesManager.add(connection);
	}
	
	
	@Override
	public void run() {
		System.out.println("Pos Server started");
		try {
			while (true) {
				listen();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	
	public static void main(String[] args) {
		try {
			new Thread(new Server()).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
