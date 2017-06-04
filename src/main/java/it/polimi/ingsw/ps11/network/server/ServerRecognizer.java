package it.polimi.ingsw.ps11.network.server;

import it.polimi.ingsw.ps11.network.server.messages.DefaultServerMessage;

public interface ServerRecognizer {
	public void execute(DefaultServerMessage command);
}
