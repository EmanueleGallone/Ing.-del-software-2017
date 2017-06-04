package it.polimi.ingsw.ps11.posNetwork.server;

import java.util.ArrayList;
import java.util.HashMap;

import it.polimi.ingsw.ps11.cranio.JsonAdapter;
import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.network.Connection;
import it.polimi.ingsw.ps11.network.messages.Sendable;
import it.polimi.ingsw.ps11.network.messages.CommandRecognizer;
import it.polimi.ingsw.ps11.network.messages.DefaultCommand;
import it.polimi.ingsw.ps11.network.messages.InputChangeEvent;

public class GameController implements CommandRecognizer,Runnable {

	
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
			//JsonAdapter jsonAdapter = new JsonAdapter();
			//Sendable command = jsonAdapter.fromJson(e.getMessage().getObject(), e.getMessage().getType());
			//performCommand(command);
		}
	};
	
	public void performCommand(Sendable command){
		command.accept(this);
	}
	
	
	EventListener<Connection> disconnectionListener = new EventListener<Connection>() {

		@Override
		public void handle(Connection e) {
			System.out.println("Player disconnected");
		}
	};
	

	
	
	@Override
	public void run() {
		/*
		System.out.println("Server puoi scrivere");
		while(true){
			String message = new Console().read();
			for(Connection connection : clients.keySet()){
				
				Gson gson = new Gson();
				String out = gson.toJson(new Message(String.class.toString(), message));
				connection.send(out);
			}
		}*/
	}

	
	//___________________ COMMAND ____________________________
	
	@Override
	public void execute(DefaultCommand command) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void execute(Player player) {
		// TODO Auto-generated method stub
		
	}
	
}
