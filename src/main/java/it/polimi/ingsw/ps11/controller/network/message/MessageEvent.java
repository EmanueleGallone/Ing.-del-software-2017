package it.polimi.ingsw.ps11.controller.network.message;

import it.polimi.ingsw.ps11.controller.network.Connection;
/**
 * <h3> MessageEvent </h3>
 * <p> Classe generica che gestisce un messaggio di networking.</p>
 */
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
