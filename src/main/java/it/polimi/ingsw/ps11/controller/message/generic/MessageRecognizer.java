package it.polimi.ingsw.ps11.controller.message.generic;

import it.polimi.ingsw.ps11.controller.message.toClient.ServerMessage;
import it.polimi.ingsw.ps11.controller.message.toClient.StartGameMessage;
import it.polimi.ingsw.ps11.controller.message.toServer.ClientMessage;

public interface MessageRecognizer {

	public void handle(TextualMessage message);

	public void handle(StartGameMessage startGameMessage);

	//Messaggi solo per il client
	public void handle(ServerMessage clientMessage);
	
	//Messaggi solo per il server
	public void handle(ClientMessage serverMessage);
}
