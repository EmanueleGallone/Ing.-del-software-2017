package it.polimi.ingsw.ps11.posNetwork.client.messages;

import it.polimi.ingsw.ps11.posNetwork.messages.ClientMessage;
import it.polimi.ingsw.ps11.posNetwork.messages.GenericRecogniser;

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

	@Override
	public void gAccept(GenericRecogniser recogniser) {
		recogniser.execute(this);
	}



}
