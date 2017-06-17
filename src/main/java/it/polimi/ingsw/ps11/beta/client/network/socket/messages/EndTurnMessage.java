package it.polimi.ingsw.ps11.beta.client.network.socket.messages;

public class EndTurnMessage extends ClientMessage {

	@Override
	public void accept(ClientRecognizer clientRecognizer) {
		clientRecognizer.execute(this);
	}


}
