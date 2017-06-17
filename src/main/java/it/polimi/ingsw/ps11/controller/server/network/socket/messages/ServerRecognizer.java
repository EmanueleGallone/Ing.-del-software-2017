package it.polimi.ingsw.ps11.controller.server.network.socket.messages;

import it.polimi.ingsw.ps11.controller.server.network.socket.messageList.PrintMessage;
import it.polimi.ingsw.ps11.controller.server.network.socket.messageList.StartGameMessage;
import it.polimi.ingsw.ps11.controller.server.network.socket.messageList.UpdatePlayerMessage;

public interface ServerRecognizer {
	
	public void execute(PrintMessage printMessage);
	public void execute(UpdatePlayerMessage updatePlayerMessage);
	public void execute(StartGameMessage startGameMessage);
	
}
