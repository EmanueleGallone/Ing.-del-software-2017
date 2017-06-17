package it.polimi.ingsw.ps11.controller.client.network.socket.messages;

import it.polimi.ingsw.ps11.controller.client.network.socket.messageList.EndTurnMessage;

public interface ClientRecognizer {

	public void execute(EndTurnMessage message);
}
