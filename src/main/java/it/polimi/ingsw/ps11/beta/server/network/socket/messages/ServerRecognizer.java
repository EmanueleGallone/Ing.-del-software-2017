package it.polimi.ingsw.ps11.beta.server.network.socket.messages;

import it.polimi.ingsw.ps11.beta.server.network.socket.messages.list.PrintMessage;
import it.polimi.ingsw.ps11.beta.server.network.socket.messages.list.StartGameMessage;
import it.polimi.ingsw.ps11.beta.server.network.socket.messages.list.UpdatePlayerMessage;

public interface ServerRecognizer {
	
	public void execute(PrintMessage printMessage);
	public void execute(UpdatePlayerMessage updatePlayerMessage);
	public void execute(StartGameMessage startGameMessage);
	
}
