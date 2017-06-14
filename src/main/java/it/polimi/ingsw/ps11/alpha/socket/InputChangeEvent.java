package it.polimi.ingsw.ps11.alpha.socket;

import it.polimi.ingsw.ps11.alpha.socket.connection.Connection;

public class InputChangeEvent<T extends Message<?>> {

	private Connection<T,?> source;
	private T message;
	
	public InputChangeEvent(Connection<T,?> connection, T message) {
		this.source = connection;
		this.message = message;
	}
	
	public Connection<T,?> getConnection() {
		return source;
	}
	public T getMessage() {
		return message;
	}
}


