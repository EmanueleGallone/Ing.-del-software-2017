package it.polimi.ingsw.ps11.controller.network;

import java.io.IOException;

import it.polimi.ingsw.ps11.controller.network.message.Message;
import it.polimi.ingsw.ps11.controller.network.message.MessageEvent;
import it.polimi.ingsw.ps11.controller.network.message.TextualMessage;
import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;

public abstract class Connection implements ConnectionInterface {

	private String serverAddress = "localhost";
	private int port = 4099;
	private String id;
	
	private EventHandler<MessageEvent> messageListener = new EventHandler<>();

	public Connection() {
		
	}
	
	public Connection(String id) {
		this.id = id;
	}
	
	public Connection(int port) {
		this.port = port;
	}
	
	
	public Connection(String serverAddress, int port) {
		this.serverAddress = serverAddress;
		this.port = port;
	}
	
	public void send(String message) {
		try {
			send(new TextualMessage(message));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	public String getServerAddress() {
		return serverAddress;
	}
	
	public int getPort() {
		return port;
	}
	
	public String getId() {
		return id;
	}
	
	protected void invokeMessageEvent(Message message){
		messageListener.invoke(new MessageEvent(message,this));
	}
	
	@Override
	public void attachListener(EventListener<MessageEvent> listener) {
		messageListener.attach(listener);
	}
}
