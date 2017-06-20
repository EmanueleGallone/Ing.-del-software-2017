package it.polimi.ingsw.ps11.controller.messageList.message;

import it.polimi.ingsw.ps11.controller.message.Message;
import it.polimi.ingsw.ps11.controller.message.MessageRecognizer;

public class TextualMessage implements Message {

	private String message;
	
	public TextualMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	@Override
	public void accept(MessageRecognizer recognizer) {
		recognizer.handle(this);
	}
	
	@Override
	public String toString() {
		return message;
	}
}
