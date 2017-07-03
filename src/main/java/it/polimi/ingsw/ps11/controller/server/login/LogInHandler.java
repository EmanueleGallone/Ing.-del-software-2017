package it.polimi.ingsw.ps11.controller.server.login;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import it.polimi.ingsw.ps11.controller.network.Connection;
import it.polimi.ingsw.ps11.controller.network.message.LogInMessage;
import it.polimi.ingsw.ps11.controller.network.message.MessageEvent;
import it.polimi.ingsw.ps11.controller.network.message.MessageListener;
import it.polimi.ingsw.ps11.controller.network.message.ModelMessage;
import it.polimi.ingsw.ps11.controller.network.message.TextualMessage;
import it.polimi.ingsw.ps11.controller.network.message.ViewMessage;
import it.polimi.ingsw.ps11.controller.server.ConnectionHandler;
import it.polimi.ingsw.ps11.model.JsonAdapter;
import it.polimi.ingsw.ps11.model.events.EventListener;

public class LogInHandler implements MessageListener, EventListener<MessageEvent> {

	private ArrayList<Connection> waitingClient = new ArrayList<>();
	private ConnectionHandler connectionHandler = new ConnectionHandler();
	
	
	private Register register;
	
	public LogInHandler() {
		try {
			FileReader reader = new FileReader(Register.getRegisterurl());
			register = new JsonAdapter().fromJson(reader,Register.class);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public void handle(Connection connection){
		connection.attachListener(this);
	}


	@Override
	public void receive(TextualMessage message) {}
	
	@Override
	public void receive(ModelMessage modelMessage) {}
	
	@Override
	public void receive(ViewMessage viewMessage) {}

	
	@Override
	public void receive(LogInMessage logInMessage) {		
		if(logInMessage.getId() != null && logInMessage.getPw() != null){
			User user = new User(logInMessage.getId(), logInMessage.getPw());
			Connection connection = logInMessage.getSource();
			connection.setId(logInMessage.getId());
			
			if(register.search(user)){
				waitingClient.remove(connection);
				connectionHandler.handle(connection);
				return;
			}else {
				connection.send("Dati non validi per il login");
			}
			
			if(register.addNew(user)){
				waitingClient.remove(connection);
				connectionHandler.addToLobby(connection);
				connection.send("Ti sei registrato con successo, il tuo nome è: " + user.getId());
				return;
			}
			else {
				connection.send("Registrazione fallita, nome utente già in uso");
			}
			

		}
	}
	
	@Override
	public void handle(MessageEvent e) {
		e.getMessage().setSource(e.getSource());
		e.getMessage().accept(this);
	}	
}
