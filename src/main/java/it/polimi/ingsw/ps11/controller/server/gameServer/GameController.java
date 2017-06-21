package it.polimi.ingsw.ps11.controller.server.gameServer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import it.polimi.ingsw.ps11.controller.message.Message;
import it.polimi.ingsw.ps11.controller.message.MessageEvent;
import it.polimi.ingsw.ps11.controller.message.MessageReceiver;
import it.polimi.ingsw.ps11.controller.message.ModelMessage;
import it.polimi.ingsw.ps11.controller.message.TextualMessage;
import it.polimi.ingsw.ps11.controller.message.ViewMessage;
import it.polimi.ingsw.ps11.controller.network.Connection;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.gameLogics.GameLogic;
import it.polimi.ingsw.ps11.model.modelEvents.ModelEvent;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEvent;

public class GameController implements MessageReceiver,Runnable {

	private HashMap<Connection, Player> clients = new HashMap<>();
	private GameLogic gameLogic;
	
	public GameController(ArrayList<Connection> clients) {
		
		int i = 0;
		PlayerFactory pFactory = new PlayerFactory();
		
		for(Connection client : clients){
			client.attachListener(messageListener);
			Player player = pFactory.newPlayer(i);
			player.setName("Giocatore " + (i + 1));
			this.clients.put(client, player);
			i++;
		}
		
		gameLogic = new GameLogic(new ArrayList<>(this.clients.values()));
		gameLogic.attach(modelListener);
	}
	
	@Override
	public void run() {
		gameLogic.run();
	}
	
	public Connection getClient(Player player) throws IllegalArgumentException{
		for (Connection c : clients.keySet()){
			if(player.equals(this.clients.get(clients))){
				return c;
			}
		}
		throw new IllegalArgumentException();
	}
	
	
	private transient EventListener<ModelEvent> modelListener = new EventListener<ModelEvent>() {

		@Override
		public void handle(ModelEvent e) {
			Connection connection = getClient(e.getReceiver());
			try {
				connection.send(new ModelMessage(e));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	};
	
	private transient EventListener<MessageEvent> messageListener = new EventListener<MessageEvent>() {
		
		@Override
		public void handle(MessageEvent e) {
			Message message = e.getMessage();
			message.setSource(e.getSource());
			execute(message);
		}
	};
	
	public void execute(Message message){
		message.accept(this);
	}
	
// Handle message from client 

	@Override
	public void receive(TextualMessage message) {
		System.out.println(message.getMessage());
	}


	@Override
	public void receive(ModelMessage mEvent) {}


	@Override
	public void receive(ViewMessage viewMessage) {
		ViewEvent event =  viewMessage.getEvent();
		event.setSource(clients.get(viewMessage));
		event.accept(gameLogic);
	}
}
