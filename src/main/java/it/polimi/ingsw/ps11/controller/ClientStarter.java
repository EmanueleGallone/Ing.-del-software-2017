package it.polimi.ingsw.ps11.controller;

import java.net.Socket;

import it.polimi.ingsw.ps11.controller.client.Client;
import it.polimi.ingsw.ps11.controller.network.rmi.RMIConnection;
import it.polimi.ingsw.ps11.controller.network.socket.SocketConnection;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.textualView.TextualView;

public class ClientStarter {
	
	public static void main(String[] args) {
		TextualConsole console = new TextualConsole();
		console.print("Do you want to play with socket or rmi? (s/r) : ");
		String network = console.read();
		console.print("\n Do you want to play with CLI or GUI? (c/g) : ");
		String view = console.read();
		
		if (network.equalsIgnoreCase("s") && view.equalsIgnoreCase("c")) {
			new Client(new TextualView(), new SocketConnection()).run();
		}
		if (network.equalsIgnoreCase("r") && view.equalsIgnoreCase("c")) {
			new Client(new TextualView(), new RMIConnection(1099)).run();
		}
	}

}
