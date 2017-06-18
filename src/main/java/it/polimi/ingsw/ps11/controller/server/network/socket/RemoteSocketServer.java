package it.polimi.ingsw.ps11.controller.server.network.socket;

import java.io.IOException;
import java.net.UnknownHostException;

import it.polimi.ingsw.ps11.controller.client.network.socket.connection.Connection;
import it.polimi.ingsw.ps11.controller.client.network.socket.connection.NewMessageEvent;
import it.polimi.ingsw.ps11.controller.client.network.socket.messageList.EndTurnMessage;
import it.polimi.ingsw.ps11.controller.client.network.socket.messages.ClientMessage;
import it.polimi.ingsw.ps11.controller.client.network.socket.messages.ClientMessageWrapper;
import it.polimi.ingsw.ps11.controller.server.events.PrintEvent;
import it.polimi.ingsw.ps11.controller.server.events.StartGameEvent;
import it.polimi.ingsw.ps11.controller.server.events.UpdatePlayerEvent;
import it.polimi.ingsw.ps11.controller.server.network.RemoteServer;
import it.polimi.ingsw.ps11.controller.server.network.socket.messageList.PrintMessage;
import it.polimi.ingsw.ps11.controller.server.network.socket.messageList.StartGameMessage;
import it.polimi.ingsw.ps11.controller.server.network.socket.messageList.UpdatePlayerMessage;
import it.polimi.ingsw.ps11.controller.server.network.socket.messages.ServerMessage;
import it.polimi.ingsw.ps11.controller.server.network.socket.messages.ServerMessageWrapper;
import it.polimi.ingsw.ps11.controller.server.network.socket.messages.ServerRecognizer;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.json.JsonAdapter;

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

	@Override
	public void execute(UpdatePlayerMessage updatePlayerMessage) {
		this.updatePlayerEvent.invoke(new UpdatePlayerEvent(updatePlayerMessage.getPlayer()));
	}

	@Override
	public void execute(StartGameMessage startGameMessage) {
		startGameEvent.invoke(new StartGameEvent(startGameMessage.getGame(), startGameMessage.getPlayer()));
	}
	
}
