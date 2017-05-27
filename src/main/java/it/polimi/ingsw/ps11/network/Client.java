package it.polimi.ingsw.ps11.network;

import java.net.Socket;

import it.polimi.ingsw.ps11.cranio.player.Player;

public class Client {
	private final int PORT = 60000;
	private Socket socket;
	private Player player;
	
	
	public Client(Socket socket, Player player) {
		this.socket = socket;
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}
}
