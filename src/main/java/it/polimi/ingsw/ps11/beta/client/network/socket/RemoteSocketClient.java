package it.polimi.ingsw.ps11.beta.client.network.socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.beta.client.events.EndTurnEvent;
import it.polimi.ingsw.ps11.beta.client.network.RemoteClient;
import it.polimi.ingsw.ps11.beta.client.network.socket.connection.Connection;
import it.polimi.ingsw.ps11.beta.client.network.socket.connection.events.NewMessageEvent;
import it.polimi.ingsw.ps11.beta.client.network.socket.messages.ClientMessage;
import it.polimi.ingsw.ps11.beta.client.network.socket.messages.ClientMessageWrapper;
import it.polimi.ingsw.ps11.beta.client.network.socket.messages.ClientRecognizer;
import it.polimi.ingsw.ps11.beta.client.network.socket.messages.list.EndTurnMessage;
import it.polimi.ingsw.ps11.beta.server.network.socket.messages.ServerMessage;
import it.polimi.ingsw.ps11.beta.server.network.socket.messages.ServerMessageWrapper;
import it.polimi.ingsw.ps11.beta.server.network.socket.messages.list.PrintMessage;
import it.polimi.ingsw.ps11.beta.server.network.socket.messages.list.UpdatePlayerMessage;
import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.json.JsonAdapter;
import it.polimi.ingsw.ps11.cranio.player.Player;

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
	
	@Override
	public void update(Player player) throws RemoteException {
		send(new UpdatePlayerMessage(player));
	}
	
	@Override
	public void startGame(Game game, Player player) throws RemoteException {
		
	}
	
// Handle message from client

	@Override
	public void execute(EndTurnMessage message) {
		endTurnEvent.invoke(new EndTurnEvent());
	}

// ________________________ 
	
	private void handleMessage(ClientMessage message){
		message.accept(this);
	}
	
	private EventListener<NewMessageEvent> messageHandler = new EventListener<NewMessageEvent>() {

		@Override
		public void handle(NewMessageEvent e) {
			
			JsonAdapter jsonAdapter = new JsonAdapter();
			ClientMessageWrapper wrapper = jsonAdapter.fromJson(e.getMessage(), ClientMessageWrapper.class);
			ClientMessage message = wrapper.getMessage();
			handleMessage(message);
		}
	};
	
// Send message ______________________________________
	
	protected void send(ServerMessage message) {
		try {
			connection.send(serialize(message));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected String serialize(ServerMessage message){
		JsonAdapter json = new JsonAdapter();
		ServerMessageWrapper wrapper = new ServerMessageWrapper(message);
		return json.toJson(wrapper);
	}

}
