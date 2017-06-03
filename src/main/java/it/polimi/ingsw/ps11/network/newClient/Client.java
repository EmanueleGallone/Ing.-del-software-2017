package it.polimi.ingsw.ps11.network.newClient;

import it.polimi.ingsw.ps11.mvc.view.View;
import it.polimi.ingsw.ps11.mvc.view.textualView.tree.Console;
import it.polimi.ingsw.ps11.network.Connection;

public class Client extends Thread {
	
	private ClientController controller;
	
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
	
	public Client(View view) {
		controller = new ClientController(view, new Connection());
	}
	public Client(View view, Connection connection) {
		controller = new ClientController(view, connection);
	}
	
	@Override
	public void run() {
		controller.start();
	}
	
}
