package it.polimi.ingsw.ps11.controller;

import it.polimi.ingsw.ps11.controller.client.Client;
import it.polimi.ingsw.ps11.controller.network.rmi.RMIConnection;
import it.polimi.ingsw.ps11.view.textualView.TextualView;

public class RmiClientStarter {
	
	public static void main(String[] args) {
		new Client(new TextualView(), new RMIConnection(3099)).run();
	}
	
}
