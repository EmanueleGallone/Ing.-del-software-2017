package it.polimi.ingsw.ps11.network.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import it.polimi.ingsw.ps11.network.connection.Connection;
import it.polimi.ingsw.ps11.network.server.messages.DefaultServerMessage;


public class Server implements Runnable {	
	
	private static final int PORT = 60000;
	
	private GamesManager gamesManager;
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
	  gamesManager.add(connection);
	}
	
	
	@Override
	public void run() {
		System.out.println("Server started");
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
