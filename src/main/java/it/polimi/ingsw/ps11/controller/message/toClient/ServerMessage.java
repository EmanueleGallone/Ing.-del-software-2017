package it.polimi.ingsw.ps11.controller.message.toClient;

import it.polimi.ingsw.ps11.controller.message.generic.Message;
import it.polimi.ingsw.ps11.controller.message.generic.MessageRecognizer;

public interface ServerMessage extends Message {

	@Override
	public default void accept(MessageRecognizer recognizer) {
		recognizer.handle(this);
	}
	
	public void accept(ClientMessageRecognizer recognizer);

}
