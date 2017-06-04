package it.polimi.ingsw.ps11.network.client;

import java.io.IOException;
import java.net.UnknownHostException;

import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.mvc.view.View;
import it.polimi.ingsw.ps11.network.InputChangeEvent;
import it.polimi.ingsw.ps11.network.client.messages.ClientMessage;
import it.polimi.ingsw.ps11.network.connection.Connection;
import it.polimi.ingsw.ps11.network.connection.MessageBuilder;
import it.polimi.ingsw.ps11.network.genericMessage.GenericRecogniser;
import it.polimi.ingsw.ps11.network.genericMessage.Message;
import it.polimi.ingsw.ps11.network.genericMessage.TextualMessage;
import it.polimi.ingsw.ps11.network.server.ServerRecognizer;
import it.polimi.ingsw.ps11.network.server.messages.DefaultServerMessage;
import it.polimi.ingsw.ps11.network.server.messages.ServerMessage;

public class ClientController implements ServerRecognizer,GenericRecogniser {
	
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
			connection.inputChangeEvent(getServerListener());
			System.out.println("Pos client start");
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
			
			MessageBuilder messageBuilder = new MessageBuilder();
			Message<?> message = messageBuilder.deserialize(e.getMessage());
			System.out.println(message.getClass());
			process(message);
		}
	};
	
	public EventListener<InputChangeEvent> getServerListener() {
		return serverListener;
	}


	public void process(Message<?> message){
		message.gAccept(this);
	}	
	
//____________________________ COMMAND EXECUTOR _____________________________
	

	@Override
	public void execute(TextualMessage message) {
		System.out.println(message.getContent());
	}

	@Override
	public void execute(DefaultServerMessage command) {
		System.out.println("Mi è arrivato un messaggio di default con dentro: " + command.getContent());
		connection.send(new TextualMessage("Bella pe te"));
	}
}
