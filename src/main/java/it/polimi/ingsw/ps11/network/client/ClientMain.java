package it.polimi.ingsw.ps11.network.client;

import it.polimi.ingsw.ps11.mvc.view.View;
import it.polimi.ingsw.ps11.mvc.view.textualView.tree.Console;
import it.polimi.ingsw.ps11.network.newClient.Client;


public class ClientMain {
	public static void main(String[] args) {

		Console console = new Console();
		View view = null;
		boolean cond = true;
		while(cond){
			String input = console.read("Scegli modalita' di gioco: Grafica [g] / Testuale [t]");
			cond = false;
			switch (input) {
			case "g":
				//view = new GraficView();
				break;
			case "t":
				//view = new TextualView();
				break;
			default:
				console.print("Non hai inserito un input valido.");
				cond = true;
				break;
			}
		}
		
		Client client = new Client(view);
		client.start();
	}
}
