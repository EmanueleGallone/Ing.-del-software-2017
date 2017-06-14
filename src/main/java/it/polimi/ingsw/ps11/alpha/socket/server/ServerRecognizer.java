package it.polimi.ingsw.ps11.alpha.socket.server;

import it.polimi.ingsw.ps11.alpha.socket.server.messages.DefaultServerMessage;
import it.polimi.ingsw.ps11.alpha.socket.server.messages.ServerMessage;
import it.polimi.ingsw.ps11.alpha.socket.server.messages.UpdateGameMessage;

public interface ServerRecognizer {
	
	public void execute(DefaultServerMessage command);
	public void execute(UpdateGameMessage command);

	public default void execute(ServerMessage<?> serverMessage){
		serverMessage.accept(this);
	}
}
