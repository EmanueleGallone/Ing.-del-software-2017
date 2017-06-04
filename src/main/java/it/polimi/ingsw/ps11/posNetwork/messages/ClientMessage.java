package it.polimi.ingsw.ps11.posNetwork.messages;

import it.polimi.ingsw.ps11.posNetwork.client.messages.ClientMessageInterface;

public abstract class ClientMessage<T> extends Message<T> implements ClientMessageInterface{

	public ClientMessage(T message) {
		super(message);
	}

}
