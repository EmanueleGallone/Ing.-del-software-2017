package it.polimi.ingsw.ps11.network.messages;

import it.polimi.ingsw.ps11.network.Connection;

public class InputChangeEvent {

	private Connection source;
	private Message message;
	
	public InputChangeEvent(Connection connection, Message message) {
		this.source = connection;
		this.message = message;
	}

	
	public Connection getConnection() {
		return source;
	}
	public Message getMessage() {
		return message;
	}
}


