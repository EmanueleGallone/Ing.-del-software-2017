package it.polimi.ingsw.ps11.controller;

import it.polimi.ingsw.ps11.controller.client.Client;
import it.polimi.ingsw.ps11.controller.network.rmi.RMIConnection;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.textualView.TextualView;

public class RmiClientStarter {
	
	public static void main(String[] args) {
		
		int i = 0, max = 10;
		int port = 3099;
		while (i < max) {
			try {
				RMIConnection connection = new RMIConnection(port);
				new Client(new TextualView(), connection).run();
				i = max;
			} catch (Exception e) {
				System.out.println("errore");
				port++;
			}
		}
		
		
		//new Client(new TextualView(), new RMIConnection(3099)).run();
	}
	
}
