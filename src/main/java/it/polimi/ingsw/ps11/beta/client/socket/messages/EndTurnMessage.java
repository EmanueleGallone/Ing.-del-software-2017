package it.polimi.ingsw.ps11.beta.client.socket.messages;

public class EndTurnMessage implements ClientMessage {

	@Override
	public void accept(ClientRecognizer clientRecognizer) {
		clientRecognizer.execute(this);
	}


}
