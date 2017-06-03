package it.polimi.ingsw.ps11.network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import it.polimi.ingsw.ps11.cranio.player.Player;

public class Client {
	private final int PORT = 60000;
	private Socket socket;
	private Player player;
	private ObjectOutputStream fromServer;
	private ObjectInputStream toServer;
	
	
	public Client(Socket socket) {
		this.socket = socket;
	}
	
	public Client() {
		player = new Player();
		
		try {
			socket = new Socket("localhost",PORT);
			fromServer = new ObjectOutputStream(socket.getOutputStream());
			toServer = new ObjectInputStream(socket.getInputStream());
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public static void main(String[] args) {
		Client client = new Client();
	}

}
