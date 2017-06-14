package it.polimi.ingsw.ps11.alpha.socket.server.messages;

import it.polimi.ingsw.ps11.alpha.socket.server.ServerRecognizer;

public class DefaultServerMessage extends ServerMessage<String>{

	public DefaultServerMessage(String message) {
		super(message);
	}

	@Override
	public void accept(ServerRecognizer recognizer) {
		recognizer.execute(this);
	}


}
