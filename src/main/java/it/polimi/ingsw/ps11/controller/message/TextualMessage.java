package it.polimi.ingsw.ps11.controller.message;

import it.polimi.ingsw.ps11.controller.network.Connection;

public class TextualMessage implements Message {

	private Connection connection;
	private String message;
	
	public TextualMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	@Override
	public void accept(MessageReceiver recognizer) {
		recognizer.receive(this);
	}
	
	@Override
	public String toString() {
		return message;
	}

	@Override
	public void setSource(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Connection getSource() {
		return connection;
	}
}