package it.polimi.ingsw.ps11.controller.message;

import it.polimi.ingsw.ps11.controller.network.Connection;

public class MessageEvent {

	private Connection source;
	private Message message;
	
	public MessageEvent(Message message) {
		this.message = message;
	}
	
	public MessageEvent(Message message, Connection source) {
		this.message = message;
		this.source = source;
	}
	
	public Connection getSource() {
		return source;
	}
	
	public void setSource(Connection source) {
		this.source = source;
	}
	
	public Message getMessage() {
		return message;
	}
	
}
