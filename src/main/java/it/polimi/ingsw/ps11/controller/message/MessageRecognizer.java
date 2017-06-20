package it.polimi.ingsw.ps11.controller.message;

import it.polimi.ingsw.ps11.controller.messageList.message.TextualMessage;
import it.polimi.ingsw.ps11.controller.messageList.toClient.StartGameMessage;

public interface MessageRecognizer {

	public void handle(TextualMessage message);

	public void handle(StartGameMessage startGameMessage);

	//Messaggi solo per il client
	public void handle(ClientMessage clientMessage);
	
	//Messaggi solo per il server
	public void handle(ServerMessage serverMessage);
}
