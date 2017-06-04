package it.polimi.ingsw.ps11.network.client.messages;

import it.polimi.ingsw.ps11.network.genericMessage.GenericRecogniser;
import it.polimi.ingsw.ps11.network.genericMessage.Message;

public abstract class ClientMessage<T> extends Message<T> implements ClientMessageInterface{

	public ClientMessage(T message) {
		super(message);
	}

	@Override
	public void gAccept(GenericRecogniser recogniser){
		recogniser.execute(this);
	}

}
