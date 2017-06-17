package it.polimi.ingsw.ps11.beta.server.socket;

import java.io.IOException;
import java.net.UnknownHostException;

import it.polimi.ingsw.ps11.beta.client.events.PrintEvent;
import it.polimi.ingsw.ps11.beta.client.socket.connection.Connection;
import it.polimi.ingsw.ps11.beta.client.socket.connection.events.NewMessageEvent;
import it.polimi.ingsw.ps11.beta.client.socket.messages.ClientMessage;
import it.polimi.ingsw.ps11.beta.client.socket.messages.ClientMessageWrapper;
import it.polimi.ingsw.ps11.beta.client.socket.messages.EndTurnMessage;
import it.polimi.ingsw.ps11.beta.server.RemoteServer;
import it.polimi.ingsw.ps11.beta.server.socket.messages.PrintMessage;
import it.polimi.ingsw.ps11.beta.server.socket.messages.ServerMessage;
import it.polimi.ingsw.ps11.beta.server.socket.messages.ServerMessageWrapper;
import it.polimi.ingsw.ps11.beta.server.socket.messages.ServerRecognizer;
import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.cranio.json.JsonAdapter;

public class RemoteSocketServer extends RemoteServer implements ServerRecognizer {
	
	private Connection connection;

	public RemoteSocketServer(String serverAddress, int port)  {
		connection = new Connection(serverAddress, port);
		connection.newMessageEvent(messageHandler);
	}
	
// Invoke method on server _______________

	@Override
	public void endTurn() {
		send(new EndTurnMessage());
	}
	
	protected void send (ClientMessage message){
		try {
			connection.send(serialize(message));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected String serialize(ClientMessage message){
		JsonAdapter json = new JsonAdapter();
		ClientMessageWrapper wrapper = new ClientMessageWrapper(message);
		return json.toJson(wrapper);
	}
	
	public void connect() throws UnknownHostException, IOException{
		connection.on();
	}
	
// Handle message from server ________________________
	
	private EventListener<NewMessageEvent> messageHandler = new EventListener<NewMessageEvent>() {
		
		@Override
		public void handle(NewMessageEvent e) {

			JsonAdapter jsonAdapter = new JsonAdapter();
			ServerMessageWrapper wrapper = jsonAdapter.fromJson(e.getMessage(), ServerMessageWrapper.class);
			ServerMessage message = wrapper.getMessage();
			handleMessage(message);
		}
	};
	
	private void handleMessage(ServerMessage message){
		message.accept(this);
	}

	@Override
	public void execute(PrintMessage printMessage) {
		printEvent.invoke(new PrintEvent(printMessage.getContent()));
	}
	
}
