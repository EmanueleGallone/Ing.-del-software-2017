package it.polimi.ingsw.ps11.network.client;

import it.polimi.ingsw.ps11.network.client.messages.ClientMessage;
import it.polimi.ingsw.ps11.network.client.messages.DefaultClientMessage;
import it.polimi.ingsw.ps11.network.genericMessage.GenericRecogniser;
import it.polimi.ingsw.ps11.network.server.messages.ServerMessage;

public interface ClientRecognizer extends GenericRecogniser {
	
	
	public void execute(DefaultClientMessage command);
	
	
	
	@Override
	public default void execute(ClientMessage<?> clientMessage){
		clientMessage.accept(this);
	}

	public default void execute(ServerMessage<?> serverMessage){
		//Di default non fa niente se gli arriva un messaggio dal server essendo un ClientRecogniser
	}
}
