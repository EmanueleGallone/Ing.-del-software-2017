package it.polimi.ingsw.ps11.controller.client;

import it.polimi.ingsw.ps11.controller.message.generic.TextualMessage;
import it.polimi.ingsw.ps11.controller.message.toClient.ClientMessageRecognizer;
import it.polimi.ingsw.ps11.controller.message.toClient.StartGameMessage;

public class ClientLogic implements ClientMessageRecognizer {

	@Override
	public void handle(TextualMessage message) {
		System.out.println(message);
	}


	@Override
	public void handle(StartGameMessage message) {
		System.out.println("Ho ricevuto lo start message");
	}

}
