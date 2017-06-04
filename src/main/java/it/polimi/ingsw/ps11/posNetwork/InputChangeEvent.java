package it.polimi.ingsw.ps11.posNetwork;

import it.polimi.ingsw.ps11.posNetwork.messages.Message;

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


