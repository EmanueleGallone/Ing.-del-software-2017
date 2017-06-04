package it.polimi.ingsw.ps11.network.newClient.messages;

public class Default implements ClientMessage {

	@Override
	public void accept(ClientRecognizer recognizer) {
		recognizer.execute(this);
	}



}
