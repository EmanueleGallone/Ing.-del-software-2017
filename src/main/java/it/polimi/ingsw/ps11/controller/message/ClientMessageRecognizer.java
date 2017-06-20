package it.polimi.ingsw.ps11.controller.message;

import it.polimi.ingsw.ps11.controller.messageList.toClient.StartGameMessage;

public interface ClientMessageRecognizer extends MessageRecognizer {

	@Override
	default void handle(ClientMessage clientMessage) {
		clientMessage.accept(this);
	}
	
	@Override
	default void handle(ServerMessage serverMessage) {
		//Di default non fa nulla se gli arriva un messaggio per il server
	}
	
	public void handle(StartGameMessage message);
	
	
}
