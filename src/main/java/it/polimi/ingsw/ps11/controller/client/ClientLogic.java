package it.polimi.ingsw.ps11.controller.client;

import it.polimi.ingsw.ps11.controller.message.Message;
import it.polimi.ingsw.ps11.controller.message.MessageRecognizer;

public class ClientLogic implements MessageRecognizer {

	@Override
	public void handle(Message message) {
		System.out.println(message);
	}

}
