package it.polimi.ingsw.ps11.network.genericMessage;

import it.polimi.ingsw.ps11.network.client.messages.ClientMessage;
import it.polimi.ingsw.ps11.network.server.messages.ServerMessage;

public interface GenericRecogniser {
	public void execute(ClientMessage<?> clientMessage);
	public void execute(ServerMessage<?> serverMessage);
	public void execute(TextualMessage message);
	
}
