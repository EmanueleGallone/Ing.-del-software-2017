package it.polimi.ingsw.ps11.network.server;

import java.util.ArrayList;
import java.util.HashMap;

import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.network.InputChangeEvent;
import it.polimi.ingsw.ps11.network.client.ClientRecognizer;
import it.polimi.ingsw.ps11.network.client.messages.DefaultClientMessage;
import it.polimi.ingsw.ps11.network.connection.Connection;
import it.polimi.ingsw.ps11.network.genericMessage.GenericRecogniser;
import it.polimi.ingsw.ps11.network.genericMessage.Message;
import it.polimi.ingsw.ps11.network.genericMessage.TextualMessage;


public class GameController implements ClientRecognizer,Runnable {

	
	private Game game;
	private HashMap<Connection, Player> clients = new HashMap<>();
	private Player defaultPlayer; //Andrà caricato da file
	
	
	public GameController(ArrayList<Connection> connections) {
		
		System.out.println("Nuovo match iniziato");
		
		PlayerFactory factory = new PlayerFactory();
		int i = 0;
		for(Connection c : connections){
			clients.put(c,factory.newPlayer(i));
			c.inputChangeEvent(clientListener);
			i++;
		}
		game = new Game(new ArrayList<>(clients.values()));
	}

	EventListener<InputChangeEvent> clientListener = new EventListener<InputChangeEvent>() {
		@Override
		public void handle(InputChangeEvent e) {
			process(e.getMessage());
		}
	};
	
	public EventListener<InputChangeEvent> getServerListener() {
		return clientListener;
	}


	public void process(Message<?> message){
		message.gAccept(this);
	}
	
	
	EventListener<Connection> disconnectionListener = new EventListener<Connection>() {

		@Override
		public void handle(Connection e) {
			System.out.println("Player disconnected");
		}
	};
	
	
	
	@Override
	public void run() {
		Player player = game.getRoundManager().next();
		
		//Manda un messaggio al player per dirgli che è il suo turno
		
		//Aspetta 2 minuti e intanto ascolta i comandi 
		//Dopo 2 minuti oppure quando il player fa il passaTurno fa di nuovo la roundManager.next();
		
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
	public void execute(TextualMessage message) {
		System.out.println(message.getContent());
	}


	@Override
	public void execute(DefaultClientMessage command) {
		System.out.println("Mi è arrivato un messaggio di default con dentro: " + command.getContent());
	}
}
