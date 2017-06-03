package it.polimi.ingsw.ps11.network.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server extends Thread{

	private ServerSocket serverSocket;
	private Lobby lobby;
	private ServerController controller;
	PrintStream outputStream;
	DataInputStream dInputStream;
	DataOutputStream dOutputStream;
	
	private static final int PORT = 60000, maxClientsCount = 128;
	private HashMap<String, GameConnection> connections = new HashMap<String, GameConnection>();
	//il server regge 128 connessioni contemporanee 
	 
	public Server() {
		//defaultPlayer = carica da file; 
		lobby = new Lobby(this);
		controller = new ServerController(this);
		try {
			serverSocket = new ServerSocket(PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run(){
		
		System.out.println("Server Attivo: connessione giocatori");
		
		while(true){
			try {
				Socket socket = serverSocket.accept();
		        outputStream = new PrintStream(socket.getOutputStream());
		        if(connections.size() == maxClientsCount){
		        	 outputStream.println("Server too busy. Try later.");
			         outputStream.close();
			          socket.close();
		        } else {
	        		GameConnection connection = new GameConnection(socket);
			        connections.put(connection.getName(), connection);
			        System.out.println("<" + connection.getPlayerName() + "> si è connesso al server.");
					lobby.addClient(connection.getPlayerName(),connection);//nella lobby vengono tenuti i giocatori in attesa
		        }										
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ServerController getController(){
		return this.controller;
	}
	
	public static void main(String[] args){
		Server server = new Server();
		server.start();
	}
	
	
}