package it.polimi.ingsw.ps11.controller.message.toServer;

import it.polimi.ingsw.ps11.controller.message.generic.Message;
import it.polimi.ingsw.ps11.controller.message.generic.MessageRecognizer;

public interface ClientMessage extends Message {

	@Override
	public default void accept(MessageRecognizer recognizer) {
		recognizer.handle(this);
	}
	
	public void accept(ServerMessageRecognizer recognizer);

}
