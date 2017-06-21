package it.polimi.ingsw.ps11.controller;

import it.polimi.ingsw.ps11.controller.client.Client;
import it.polimi.ingsw.ps11.controller.network.rmi.RMIConnection;

public class RmiClientStarter {
	
	public static void main(String[] args) {
		new Client(null, new RMIConnection(3099)).run();
	}
	
}
