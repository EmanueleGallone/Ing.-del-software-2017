package it.polimi.ingsw.ps11.controller.client.network.socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.controller.client.RemoteClient;
import it.polimi.ingsw.ps11.controller.client.network.socket.connection.Connection;
import it.polimi.ingsw.ps11.controller.client.network.socket.connection.MessageArrivedEvent;
import it.polimi.ingsw.ps11.controller.message.Message;
import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;

public class RemoteSocketClient implements RemoteClient {

	private Connection connection;
	private EventHandler<MessageArrivedEvent> messageListener = new EventHandler<>();
	
	public RemoteSocketClient(Socket socket) throws UnknownHostException, IOException {
		connection = new Connection(socket);
		connection.attachMessageListener(messageHandler);
		connection.on();
	}

	@Override
	public void send(Message message) throws RemoteException {
		try {
			connection.send(message);
		} catch (IOException e) {
			//e.printStackTrace();
			throw new RemoteException();
		}
	}
	
	private EventListener<MessageArrivedEvent> messageHandler = new EventListener<MessageArrivedEvent>() {
		
		@Override
		public void handle(MessageArrivedEvent e) {
			messageListener.invoke(e);
		}
	};
	
	public void attachMessageListener(EventListener<MessageArrivedEvent> newMessageListener){
		messageListener.attach(newMessageListener);
	}
	
// Invoke method on client
	
	/*
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
		send(new StartGameMessage(game, player));
	}
	
	*/
// Handle message from client
/*
	@Override
	public void execute(EndTurnMessage message) {
		endTurnEvent.invoke(new EndTurnEvent());
	}
	*/

// ________________________ 
	
/*

	
// Send message ______________________________________
	
	protected void send(Message message) {
		try {
			connection.send(serialize(message));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected String serialize(Message message){
		JsonAdapter json = new JsonAdapter();
		return json.toJson(wrapper);
	}
	*/
}
