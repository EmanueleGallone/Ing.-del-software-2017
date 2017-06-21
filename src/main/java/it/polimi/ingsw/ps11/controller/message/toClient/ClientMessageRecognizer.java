package it.polimi.ingsw.ps11.controller.message.toClient;

import it.polimi.ingsw.ps11.controller.message.generic.MessageRecognizer;
import it.polimi.ingsw.ps11.controller.message.toServer.ClientMessage;

public interface ClientMessageRecognizer extends MessageRecognizer {

	@Override
	default void handle(ServerMessage clientMessage) {
		clientMessage.accept(this);
	}
	
	@Override
	default void handle(ClientMessage serverMessage) {
		//Di default non fa nulla se gli arriva un messaggio per il server
	}
	
	public void handle(StartGameMessage message);
	
	
}
