package it.polimi.ingsw.ps11.controller.client;

import it.polimi.ingsw.ps11.controller.message.TextualMessage;
import it.polimi.ingsw.ps11.controller.messageList.StartGameMessage;
import it.polimi.ingsw.ps11.controller.message.MessageRecognizer;

public class ClientLogic implements MessageRecognizer {

	@Override
	public void handle(TextualMessage message) {
		System.out.println(message);
	}

	@Override
	public void handle(StartGameMessage startGameMessage) {
		
	}

}
