package it.polimi.ingsw.ps11.alpha.socket.server.messages;

import it.polimi.ingsw.ps11.alpha.socket.Message;

public abstract class ServerMessage<T> extends Message<T> implements ServerMessageInterface{

	public ServerMessage(T message) {
		super(message);
	}
}
