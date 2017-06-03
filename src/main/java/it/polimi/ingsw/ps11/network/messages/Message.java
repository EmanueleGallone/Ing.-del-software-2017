package it.polimi.ingsw.ps11.network.messages;

import it.polimi.ingsw.ps11.network.Connection;

public class Message {
	
	private String type, object;
	private Connection connection;
	
	
	public Message(String type, String object) {
		this.type = type;
		this.object = object;
	}
	
	public Message(String type, String object, Connection connection) {
		this.type = type;
		this.object = object;
		this.connection = connection;
	}
	
	public Class<? extends Command> getType() {
		try {
			return (Class<? extends Command>) Class.forName(type);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return DefaultCommand.class;
	}
	
	public String getObject() {
		return object;
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	public Connection getConnection() {
		return connection;
	}
}
