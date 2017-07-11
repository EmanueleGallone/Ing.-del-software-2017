package it.polimi.ingsw.ps11.controller;

import it.polimi.ingsw.ps11.controller.client.Client;
import it.polimi.ingsw.ps11.controller.network.socket.SocketConnection;
import it.polimi.ingsw.ps11.view.graphicView.GraphicView;

/**
 * <p> Classe usata per lanciare un client Socket con interfaccia grafica senza passare per la scelta dei componenti.</p>
 */
public class SocketClientStarter {
	public static void main(String[] args) {
	//	new Client(new TextualView(), new SocketConnection()).run();
		new Client(new GraphicView(), new SocketConnection()).run();
		
	}
}
