package it.polimi.ingsw.ps11.network.messages;

import it.polimi.ingsw.ps11.network.Connection;

public class InputChangeEvent {

	private Connection connection;
	private Message message;
	
	public InputChangeEvent(Connection connection, Message message) {
		this.connection = connection;
		this.message = message;
	}

	
	public Connection getConnection() {
		return connection;
	}
	public Message getMessage() {
		return message;
	}
}


