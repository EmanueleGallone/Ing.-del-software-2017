package it.polimi.ingsw.ps11.controller.message;

import it.polimi.ingsw.ps11.controller.messageList.toServer.EndTurnMessage;

public interface ServerMessageRecognizer extends MessageRecognizer {

	@Override
	default void handle(ServerMessage serverMessage) {
		serverMessage.accept(this);
	}
	
	@Override
	default void handle(ClientMessage clientMessage) {
		//Di default non fa nulla se gli arriva un messaggio per il client
	}
	
	public void handle(EndTurnMessage message);
}
