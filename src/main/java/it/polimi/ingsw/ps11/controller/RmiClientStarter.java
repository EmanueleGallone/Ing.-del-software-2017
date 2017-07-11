package it.polimi.ingsw.ps11.controller;

import java.util.Random;

import it.polimi.ingsw.ps11.controller.client.Client;
import it.polimi.ingsw.ps11.controller.network.rmi.RMIConnection;
import it.polimi.ingsw.ps11.view.graphicView.GraphicView;
/**
 * <p> Classe usata per lanciare un client RMI con interfaccia grafica senza passare per la scelta dei componenti.</p>
 */
public class RmiClientStarter {
	
	public static void main(String[] args) {
		
		int i = 0, max = 10;
		Random gen = new Random();
		int port = gen.nextInt(62000)+1024;
		while (i < max) {
			try {
				RMIConnection connection = new RMIConnection(port);
				//new Client(new TextualView(), connection).run();
				new Client(new GraphicView(), connection).run();
				i = max;
			} catch (Exception e) {
				e.printStackTrace();
				port++;
			}
		}
		//new Client(new TextualView(), new RMIConnection(3099)).run();
	}
	
}
