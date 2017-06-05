package it.polimi.ingsw.ps11.network.server;

import it.polimi.ingsw.ps11.network.client.messages.ClientMessage;
import it.polimi.ingsw.ps11.network.genericMessage.GenericRecogniser;
import it.polimi.ingsw.ps11.network.server.messages.DefaultServerMessage;
import it.polimi.ingsw.ps11.network.server.messages.ServerMessage;
import it.polimi.ingsw.ps11.network.server.messages.UpdateGame;

public interface ServerRecognizer extends GenericRecogniser {
	
	public void execute(DefaultServerMessage command);
	public void execute(UpdateGame command);
	
	
	
	@Override
	public default void execute(ClientMessage<?> clientMessage){
		//Di default non fa niente se gli arriva un messaggio dal server essendo un ClientRecogniser
	}

	public default void execute(ServerMessage<?> serverMessage){
		serverMessage.accept(this);
	}
}
