package it.polimi.ingsw.ps11.controller;

import java.util.Random;

import it.polimi.ingsw.ps11.controller.client.Client;
import it.polimi.ingsw.ps11.controller.network.rmi.RMIConnection;
import it.polimi.ingsw.ps11.controller.network.socket.SocketConnection;
import it.polimi.ingsw.ps11.view.graphicView.GraphicView;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.textualView.TextualView;

public class ClientStarter {
	
	private TextualConsole console = new TextualConsole();
	
	public static void main(String[] args) {
		boolean condition = true;
		TextualConsole console = new TextualConsole();
		//NB: ricorda di cambiare localhost con l'IP (da capire quale) in caso non funzionasse.		
		
		while (condition) {
			
			console.print("Do you want to play with socket or rmi? (s/r) : ");
			String network = console.read();
			console.print("\nDo you want to play with CLI or GUI? (c/g) : ");
			String view = console.read();
			
			if (network.equalsIgnoreCase("s") && view.equalsIgnoreCase("c")) {
				//lancio socket con CLI
				new Client(new TextualView(), new SocketConnection()).run();
				condition = false;
			}
			
			if (network.equalsIgnoreCase("r") && view.equalsIgnoreCase("c")) {
				//lancio RMI con CLI
				Random gen = new Random();
				new Client(new TextualView(), new RMIConnection(gen.nextInt(62000)+1024)).run();
				condition = false;
			}
			
			if (network.equalsIgnoreCase("s") && view.equalsIgnoreCase("g")) {
				//lancio socket con GUI
				new Client(new GraphicView(), new SocketConnection()).run();
				condition = false;
			}
			
			if (network.equalsIgnoreCase("r") && view.equalsIgnoreCase("g")) {
				//lancio RMI con GUI
				//non funziona la gui. bisogna mettere le due funzioni nel main di graphicView all'interno del costruttore oppure in Client
				Random gen = new Random();
				new Client(new GraphicView(), new RMIConnection(gen.nextInt(62000)+1024)).run();
				condition = false;
			}
			
			else {
				System.out.println("Command not accepted. Retry");
			}
		}
		
			
		
	}

}
