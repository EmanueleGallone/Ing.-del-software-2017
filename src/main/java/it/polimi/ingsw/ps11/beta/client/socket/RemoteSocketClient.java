package it.polimi.ingsw.ps11.beta.client.socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import it.polimi.ingsw.ps11.beta.client.RemoteClient;
import it.polimi.ingsw.ps11.beta.client.socket.connection.Connection;
import it.polimi.ingsw.ps11.beta.client.socket.connection.events.NewMessageEvent;
import it.polimi.ingsw.ps11.beta.client.socket.messages.ClientMessage;
import it.polimi.ingsw.ps11.beta.client.socket.messages.ClientRecognizer;
import it.polimi.ingsw.ps11.beta.client.socket.messages.EndTurnMessage;
import it.polimi.ingsw.ps11.beta.server.events.EndTurnEvent;
import it.polimi.ingsw.ps11.beta.server.socket.messages.PrintMessage;
import it.polimi.ingsw.ps11.beta.server.socket.messages.ServerMessage;
import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.cranio.json.JsonAdapter;

public class RemoteSocketClient extends RemoteClient implements ClientRecognizer {

	private Connection connection;
	
	public RemoteSocketClient(Socket socket) throws UnknownHostException, IOException {
		connection = new Connection(socket);
		connection.newMessageEvent(messageHandler);
		connection.on();
	}
	
// Invoke method on client
	
	@Override
	public void print(String message) {
		send(new PrintMessage(message));
	}
	
	protected void send(ServerMessage message) {
		try {
			connection.send(serialize(message));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected String serialize(ServerMessage message){
		JsonAdapter json = new JsonAdapter();
		return json.toJson(message);
	}

	private EventListener<NewMessageEvent> messageHandler = new EventListener<NewMessageEvent>() {

		@Override
		public void handle(NewMessageEvent e) {
			JsonAdapter json = new JsonAdapter();
			ClientMessage message = json.fromJson(e.getMessage(), ClientMessage.class);
			handleMessage(message);
		}
	};

	private void handleMessage(ClientMessage message){
		message.accept(this);
	}
	
// Handle message from client

	@Override
	public void execute(EndTurnMessage message) {
		endTurnEvent.invoke(new EndTurnEvent());
	}
	
}
