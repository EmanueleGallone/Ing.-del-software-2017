package it.polimi.ingsw.ps11.controller.message;

import java.io.Serializable;

public class Message implements MessageVisitor, Serializable {

	private String message;
	
	public Message(String message) {
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
