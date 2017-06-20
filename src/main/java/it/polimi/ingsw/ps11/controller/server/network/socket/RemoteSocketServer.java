package it.polimi.ingsw.ps11.controller.server.network.socket;

import java.io.IOException;
import java.net.UnknownHostException;
import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.controller.client.network.socket.connection.Connection;
import it.polimi.ingsw.ps11.controller.client.network.socket.connection.MessageArrivedEvent;
import it.polimi.ingsw.ps11.controller.message.Message;
import it.polimi.ingsw.ps11.controller.server.network.RemoteServer;
import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;

public class RemoteSocketServer implements RemoteServer {
	
	private Connection connection;
	private EventHandler<MessageArrivedEvent> messageListener = new EventHandler<>();
	
	public RemoteSocketServer(String serverAddress, int port)  {
		connection = new Connection(serverAddress, port);
		connection.attachMessageListener(messageHandler);
	}
	
	public void connect() throws UnknownHostException, IOException{
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
	
/*
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
	
	private EventListener<MessageArrivedEvent> messageHandler = new EventListener<MessageArrivedEvent>() {

		@Override
		public void handle(MessageArrivedEvent e) {

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
	*/
	
}
