package it.polimi.ingsw.ps11.controller;

import it.polimi.ingsw.ps11.controller.client.Client;
import it.polimi.ingsw.ps11.controller.network.socket.SocketConnection;
import it.polimi.ingsw.ps11.view.graphicView.GraphicView;
import it.polimi.ingsw.ps11.view.textualView.TextualView;

public class SocketClientStarter {
	public static void main(String[] args) {
		new Client(new TextualView(), new SocketConnection()).run();
	//	new Client(new GraphicView(), new SocketConnection()).run();
		
	}
}
