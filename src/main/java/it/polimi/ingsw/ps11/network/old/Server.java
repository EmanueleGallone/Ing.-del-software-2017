package it.polimi.ingsw.ps11.network.old;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.network.newClient.Client;

public class Server extends Thread{
	private final int PORT = 60000;
	private ServerSocket serverSocket;
	private Player defaultPlayer;
	private Lobby lobby;
	
	 
	public Server() {
		//defaultPlayer = carica da file; 
		try {
			serverSocket = new ServerSocket(PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run(){
		while(true){
			
			try {
				Socket socket = serverSocket.accept();
				
				
				
				//lobby.addClient(new Client(socket, defaultPlayer.clone()));
				
				System.out.println("Connessione accettata : " + socket.getInetAddress() + "port : " + socket.getPort());
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	
	
	
	public static void main(String[] args){
		Server server = new Server();
		server.start();
	}
}
