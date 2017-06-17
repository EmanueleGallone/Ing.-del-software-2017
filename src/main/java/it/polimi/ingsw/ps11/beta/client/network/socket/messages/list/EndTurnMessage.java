package it.polimi.ingsw.ps11.beta.client.network.socket.messages.list;

import it.polimi.ingsw.ps11.beta.client.network.socket.messages.ClientMessage;
import it.polimi.ingsw.ps11.beta.client.network.socket.messages.ClientRecognizer;

public class EndTurnMessage extends ClientMessage {

	@Override
	public void accept(ClientRecognizer clientRecognizer) {
		clientRecognizer.execute(this);
	}


}
