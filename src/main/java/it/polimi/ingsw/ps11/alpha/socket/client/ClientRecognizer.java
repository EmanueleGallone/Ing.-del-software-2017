package it.polimi.ingsw.ps11.alpha.socket.client;

import it.polimi.ingsw.ps11.alpha.socket.client.messages.ClientMessage;
import it.polimi.ingsw.ps11.alpha.socket.client.messages.DefaultClientMessage;

public interface ClientRecognizer {
	
	public void execute(DefaultClientMessage command);
	
	public default void execute(ClientMessage<?> clientMessage){
		clientMessage.accept(this);
	}
}
