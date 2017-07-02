package it.polimi.ingsw.ps11.controller.server;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.controller.network.Connection;
import it.polimi.ingsw.ps11.controller.network.message.LogInMessage;
import it.polimi.ingsw.ps11.controller.network.message.MessageEvent;
import it.polimi.ingsw.ps11.controller.network.message.MessageListener;
import it.polimi.ingsw.ps11.controller.network.message.ModelMessage;
import it.polimi.ingsw.ps11.controller.network.message.TextualMessage;
import it.polimi.ingsw.ps11.controller.network.message.ViewMessage;
import it.polimi.ingsw.ps11.model.events.EventListener;

public class LogInHandler implements MessageListener, EventListener<MessageEvent> {

	private ArrayList<Connection> waitingClient = new ArrayList<>();
	private ConnectionHandler connectionHandler = new ConnectionHandler();
	
	public LogInHandler() {
	
	}
	
	
	public void handle(Connection connection){
		//connection.attachListener(this);
		connection.setId("");
		connectionHandler.handle(connection);
	}


	@Override
	public void receive(TextualMessage message) {}
	
	@Override
	public void receive(ModelMessage modelMessage) {}
	
	@Override
	public void receive(ViewMessage viewMessage) {}


	@Override
	public void receive(LogInMessage logInMessage) {
		if(logInMessage.getId() != null){
			Connection connection = logInMessage.getSource();
			waitingClient.remove(connection);
			connection.setId(logInMessage.getId());
			connectionHandler.handle(connection);
		}
	}


	@Override
	public void handle(MessageEvent e) {
		e.getMessage().accept(this);
	}
	
	
	
	
}
