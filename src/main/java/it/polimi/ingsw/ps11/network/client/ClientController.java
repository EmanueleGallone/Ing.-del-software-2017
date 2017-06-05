package it.polimi.ingsw.ps11.network.client;

import java.io.IOException;
import java.net.UnknownHostException;

import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.mvc.view.View;
import it.polimi.ingsw.ps11.network.InputChangeEvent;
import it.polimi.ingsw.ps11.network.connection.Connection;
import it.polimi.ingsw.ps11.network.connection.MessageBuilder;
import it.polimi.ingsw.ps11.network.genericMessage.GenericRecogniser;
import it.polimi.ingsw.ps11.network.genericMessage.Message;
import it.polimi.ingsw.ps11.network.genericMessage.TextualMessage;
import it.polimi.ingsw.ps11.network.server.ServerRecognizer;
import it.polimi.ingsw.ps11.network.server.messages.DefaultServerMessage;
import it.polimi.ingsw.ps11.network.server.messages.UpdateGameMessage;

public class ClientController implements ServerRecognizer {
	
	private View view;
	private Connection connection;
	
	
	public ClientController(View view , Connection connection) {
		this.view = view;
		this.connection = connection;
	}
	
// _________________________________________________________________
	
	public void start(){
		
		try {
			connection.on();
			connection.inputChangeEvent(serverListener);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
// _________________________ EVENT LISTENER ________________________
	
	EventListener<InputChangeEvent> serverListener = new EventListener<InputChangeEvent>() {
		@Override
		public void handle(InputChangeEvent e) {
			process(e.getMessage());
		}
	};


	public void process(Message<?> message){
		message.gAccept(this);
	}	
	
//____________________________ COMMAND EXECUTOR _____________________________
	

	@Override
	public void execute(TextualMessage message) {
		view.out(message.getContent());
	}

	@Override
	public void execute(DefaultServerMessage command) {
		view.out("Mi è arrivato un messaggio di default con dentro: " + command.getContent());
	}

	@Override
	public void execute(UpdateGameMessage command) {
		view.update(command.getContent());
	}
	
	
}
