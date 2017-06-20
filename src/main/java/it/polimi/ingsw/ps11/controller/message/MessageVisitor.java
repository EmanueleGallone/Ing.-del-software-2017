package it.polimi.ingsw.ps11.controller.message;

public interface MessageVisitor {

	public void accept(MessageRecognizer recognizer);
}
