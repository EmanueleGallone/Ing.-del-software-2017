package it.polimi.ingsw.ps11.controller.network.message;

import it.polimi.ingsw.ps11.controller.network.Connection;

public class LogInMessage implements Message{

	private Connection connection;
	private String id;
	
	public LogInMessage(String id) {
		this.id = id;
	}
	
	
	public String getId() {
		return id;
	}
	
	@Override
	public void setSource(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Connection getSource() {
		return connection;
	}

	@Override
	public void accept(MessageListener recognizer) {
		recognizer.receive(this);
	}

}
