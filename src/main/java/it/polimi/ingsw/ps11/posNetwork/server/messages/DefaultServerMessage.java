package it.polimi.ingsw.ps11.posNetwork.server.messages;

import it.polimi.ingsw.ps11.posNetwork.messages.GenericRecogniser;
import it.polimi.ingsw.ps11.posNetwork.messages.ServerMessage;

public class DefaultServerMessage extends ServerMessage<String>{

	public DefaultServerMessage(String message) {
		super(message);
	}

	@Override
	public void accept(ServerRecognizer recognizer) {
		recognizer.execute(this);
	}

	@Override
	public void gAccept(GenericRecogniser r) {
		r.execute(this);
	}


}
