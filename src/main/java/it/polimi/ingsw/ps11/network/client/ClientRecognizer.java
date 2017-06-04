package it.polimi.ingsw.ps11.network.client;

import it.polimi.ingsw.ps11.network.client.messages.DefaultClientMessage;

public interface ClientRecognizer {
	public void execute(DefaultClientMessage command);
}
