package it.polimi.ingsw.ps11.controller;

import it.polimi.ingsw.ps11.controller.client.Client;
import it.polimi.ingsw.ps11.controller.network.socket.SocketConnection;

public class SocketClientStarter {
	
	public static void main(String[] args) {
		new Client(null, new SocketConnection()).run();
	}
	
}
