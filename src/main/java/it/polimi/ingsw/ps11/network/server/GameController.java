package it.polimi.ingsw.ps11.network.server;

import java.util.ArrayList;
import java.util.HashMap;

import it.polimi.ingsw.ps11.cranio.JsonAdapter;
import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.network.InputChangeEvent;
import it.polimi.ingsw.ps11.network.client.ClientRecognizer;
import it.polimi.ingsw.ps11.network.client.messages.ClientMessage;
import it.polimi.ingsw.ps11.network.client.messages.DefaultClientMessage;
import it.polimi.ingsw.ps11.network.connection.Connection;
import it.polimi.ingsw.ps11.network.connection.MessageBuilder;
import it.polimi.ingsw.ps11.network.genericMessage.GenericRecogniser;
import it.polimi.ingsw.ps11.network.genericMessage.Message;
import it.polimi.ingsw.ps11.network.genericMessage.TextualMessage;
import it.polimi.ingsw.ps11.network.server.messages.ServerMessage;


public class GameController implements ClientRecognizer,GenericRecogniser,Runnable {

	
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
			
			MessageBuilder messageBuilder = new MessageBuilder();
			Message<?> message = messageBuilder.deserialize(e.getMessage());
			System.out.println(message.getClass());
			process(message);
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
	public void execute(DefaultClientMessage command) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void execute(ClientMessage<?> clientMessage) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void execute(ServerMessage<?> serverMessage) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void execute(TextualMessage message) {
		// TODO Auto-generated method stub
		
	}
	
}
