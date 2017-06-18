package it.polimi.ingsw.ps11.controller;

import it.polimi.ingsw.ps11.controller.client.network.rmi.RMIClient;
import it.polimi.ingsw.ps11.controller.client.network.socket.SocketClient;

public class MainMvc {
	
	
		public static void main(String[] args){
			
			
			//Avvia due client
			SocketClient.main(null);
			RMIClient.main(null);
			
			/*
			TextualView textualView = new TextualView();
			ArrayList<Player> players = new ArrayList<>();
			
			//Player p1 = new Player(Colors.RED);
			//Player p2 = new Player(Colors.BLUE);
			
			Player p1 = new Player();
			Player p2 = new Player();
			p1.setName("Jack");
			p2.setName("Sparrow");
			
			players.add(p1);
			players.add(p2);
			
			Game game = new Game(players);
			
			Controller controller = new Controller(new Model(game), textualView);
			controller.start();
			*/
		}
}
