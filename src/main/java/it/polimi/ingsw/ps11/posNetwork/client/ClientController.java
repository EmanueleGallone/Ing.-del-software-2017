package it.polimi.ingsw.ps11.posNetwork.client;

import java.io.IOException;
import java.net.UnknownHostException;

import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.mvc.view.View;
import it.polimi.ingsw.ps11.posNetwork.Connection;
import it.polimi.ingsw.ps11.posNetwork.InputChangeEvent;
import it.polimi.ingsw.ps11.posNetwork.messages.ClientMessage;
import it.polimi.ingsw.ps11.posNetwork.messages.GenericRecogniser;
import it.polimi.ingsw.ps11.posNetwork.messages.Message;
import it.polimi.ingsw.ps11.posNetwork.messages.ServerMessage;
import it.polimi.ingsw.ps11.posNetwork.messages.TextualMessage;
import it.polimi.ingsw.ps11.posNetwork.networking.MessageBuilder;
import it.polimi.ingsw.ps11.posNetwork.server.messages.DefaultServerMessage;
import it.polimi.ingsw.ps11.posNetwork.server.messages.ServerRecognizer;
import it.polimi.ingsw.ps11.posNetwork.server.messages.StampaBlu;

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
	public void execute(ClientMessage<?> clientMessage) {
		System.out.println("Destinatario sbagliato");
	}

	@Override
	public void execute(ServerMessage<?> serverMessage) {
		serverMessage.accept(this);
	}

	@Override
	public void execute(TextualMessage message) {
		System.out.println(message.getContent());
	}

	@Override
	public void execute(DefaultServerMessage command) {
		System.out.println("Operazione di default");
	}

	@Override
	public void execute(StampaBlu stampaBlu) {
		System.out.println("Devo stampare blu");
	}
}
