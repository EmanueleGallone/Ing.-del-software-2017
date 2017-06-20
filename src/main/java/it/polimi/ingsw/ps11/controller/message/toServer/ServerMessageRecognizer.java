package it.polimi.ingsw.ps11.controller.message.toServer;

import it.polimi.ingsw.ps11.controller.message.generic.MessageRecognizer;
import it.polimi.ingsw.ps11.controller.message.toClient.ServerMessage;

public interface ServerMessageRecognizer extends MessageRecognizer {

	@Override
	default void handle(ClientMessage serverMessage) {
		serverMessage.accept(this);
	}
	
	@Override
	default void handle(ServerMessage clientMessage) {
		//Di default non fa nulla se gli arriva un messaggio per il client
	}
	
	public void handle(EndTurnMessage message);
}
