package it.polimi.ingsw.ps11.controller.messageList.toServer;

import it.polimi.ingsw.ps11.controller.message.ServerMessage;
import it.polimi.ingsw.ps11.controller.message.ServerMessageRecognizer;

public class EndTurnMessage implements ServerMessage{

	@Override
	public void accept(ServerMessageRecognizer recognizer) {
		recognizer.handle(this);
	}

}
