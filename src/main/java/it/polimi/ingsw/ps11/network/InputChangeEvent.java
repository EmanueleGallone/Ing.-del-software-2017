package it.polimi.ingsw.ps11.network;

import it.polimi.ingsw.ps11.network.connection.Connection;

public class InputChangeEvent {

	private Connection source;
	private String message;
	
	public InputChangeEvent(Connection connection, String message) {
		this.source = connection;
		this.message = message;
	}
	
	public Connection getConnection() {
		return source;
	}
	public String getMessage() {
		return message;
	}
}


