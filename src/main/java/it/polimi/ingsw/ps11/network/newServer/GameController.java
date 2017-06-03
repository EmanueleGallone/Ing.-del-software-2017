package it.polimi.ingsw.ps11.network.newServer;

import java.util.ArrayList;
import java.util.HashMap;

import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.network.Connection;
import it.polimi.ingsw.ps11.network.messages.Message;

public class GameController implements Runnable {

	
	private Game game;
	private HashMap<Connection, Player> clients = new HashMap<>();
	private Player defaultPlayer; //Andrà caricato da file
	
	
	public GameController(ArrayList<Connection> connections) {
		PlayerFactory factory = new PlayerFactory();
		int i = 0;
		for(Connection c : connections){
			clients.put(c,factory.newPlayer(i));
			c.inputChangeEvent(esecutore);
			i++;
		}
		game = new Game(new ArrayList<>(clients.values()));
	}


	EventListener<Message> esecutore = new EventListener<Message>() {

		@Override
		public void handle(Message e) {
		   Player player = clients.get(e.getConnection());
		   
		}
	};
	
	@Override
	public void run() {
		
	}
	
}
