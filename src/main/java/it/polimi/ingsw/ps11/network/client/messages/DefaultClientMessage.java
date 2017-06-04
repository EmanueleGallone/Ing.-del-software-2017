package it.polimi.ingsw.ps11.network.client.messages;

import it.polimi.ingsw.ps11.network.client.ClientRecognizer;
import it.polimi.ingsw.ps11.network.genericMessage.GenericRecogniser;

public class DefaultClientMessage extends ClientMessage<String> {

	
	public DefaultClientMessage() {
		super(new String());
	}
	
	public DefaultClientMessage(String message) {
		super(message);
	}

	@Override
	public void accept(ClientRecognizer recognizer) {
		recognizer.execute(this);
	}

}
