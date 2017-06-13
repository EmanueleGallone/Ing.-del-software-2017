package it.polimi.ingsw.ps11.alpha.socket;

import it.polimi.ingsw.ps11.network.connection.Connection;
import it.polimi.ingsw.ps11.network.genericMessage.Message;

public class InputChangeEvent {

	private Connection source;
	private Message<?> message;
	
	public InputChangeEvent(Connection connection, Message<?> message) {
		this.source = connection;
		this.message = message;
	}
	
	public Connection getConnection() {
		return source;
	}
	public Message<?> getMessage() {
		return message;
	}
}


