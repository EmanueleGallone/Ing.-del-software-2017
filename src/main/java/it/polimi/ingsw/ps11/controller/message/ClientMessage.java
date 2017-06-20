package it.polimi.ingsw.ps11.controller.message;

public interface ClientMessage extends Message {

	@Override
	public default void accept(MessageRecognizer recognizer) {
		recognizer.handle(this);
	}
	
	public void accept(ClientMessageRecognizer recognizer);

}
