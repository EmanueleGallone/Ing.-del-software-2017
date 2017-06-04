package it.polimi.ingsw.ps11.posNetwork.messages;

import it.polimi.ingsw.ps11.posNetwork.server.messages.ServerMessageInterface;

public abstract class ServerMessage<T> extends Message<T> implements ServerMessageInterface{

	public ServerMessage(T message) {
		super(message);
	}

}
