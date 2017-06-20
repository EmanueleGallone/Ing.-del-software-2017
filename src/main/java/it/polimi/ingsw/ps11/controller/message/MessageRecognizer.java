package it.polimi.ingsw.ps11.controller.message;

import it.polimi.ingsw.ps11.controller.messageList.StartGameMessage;

public interface MessageRecognizer {

	public void handle(TextualMessage message);

	public void handle(StartGameMessage startGameMessage);
}
