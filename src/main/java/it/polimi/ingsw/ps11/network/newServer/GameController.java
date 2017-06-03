package it.polimi.ingsw.ps11.network.newServer;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;

import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.mvc.view.textualView.tree.Console;
import it.polimi.ingsw.ps11.network.Connection;
import it.polimi.ingsw.ps11.network.messages.InputChangeEvent;
import it.polimi.ingsw.ps11.network.messages.Message;

public class GameController implements Runnable {

	
	private Game game;
	private HashMap<Connection, Player> clients = new HashMap<>();
	private Player defaultPlayer; //Andrà caricato da file
	
	
	public GameController(ArrayList<Connection> connections) {
		
		System.out.println("Nuovo match iniziato");
		
		PlayerFactory factory = new PlayerFactory();
		int i = 0;
		for(Connection c : connections){
			clients.put(c,factory.newPlayer(i));
			c.inputChangeEvent(esecutore);
			i++;
		}
		game = new Game(new ArrayList<>(clients.values()));
	}


	EventListener<InputChangeEvent> esecutore = new EventListener<InputChangeEvent>() {

		@Override
		public void handle(InputChangeEvent e) {
		   //Player player = clients.get(e.getConnection());
		   System.out.println(e.getMessage().getObject());
		}
	};
	
	EventListener<Connection> disconnectionListener = new EventListener<Connection>() {

		@Override
		public void handle(Connection e) {
			System.out.println("Player disconnected");
		}
	};
	
	@Override
	public void run() {
		System.out.println("Server puoi scrivere");
		while(true){
			String message = new Console().read();
			for(Connection connection : clients.keySet()){
				
				Gson gson = new Gson();
				String out = gson.toJson(new Message(message.getClass().toString(), message));
				connection.send(out);
			}
		}
	}
	
}
