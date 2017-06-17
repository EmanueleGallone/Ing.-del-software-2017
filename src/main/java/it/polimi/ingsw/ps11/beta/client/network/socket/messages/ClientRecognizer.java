package it.polimi.ingsw.ps11.beta.client.network.socket.messages;

import it.polimi.ingsw.ps11.beta.client.network.socket.messages.list.EndTurnMessage;

public interface ClientRecognizer {

	public void execute(EndTurnMessage message);
}
