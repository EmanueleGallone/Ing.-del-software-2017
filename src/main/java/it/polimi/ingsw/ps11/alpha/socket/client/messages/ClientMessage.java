package it.polimi.ingsw.ps11.alpha.socket.client.messages;

import it.polimi.ingsw.ps11.alpha.socket.Message;

public abstract class ClientMessage<T> extends Message<T> implements ClientMessageInterface{

	public ClientMessage(T message) {
		super(message);
	}
}
