package it.polimi.ingsw.ps11.network.server.messages;

import it.polimi.ingsw.ps11.network.genericMessage.GenericRecogniser;
import it.polimi.ingsw.ps11.network.genericMessage.Message;

public abstract class ServerMessage<T> extends Message<T> implements ServerMessageInterface{

	public ServerMessage(T message) {
		super(message);
	}
	
	@Override
	public void gAccept(GenericRecogniser recogniser) {
		recogniser.execute(this);
	}
}
