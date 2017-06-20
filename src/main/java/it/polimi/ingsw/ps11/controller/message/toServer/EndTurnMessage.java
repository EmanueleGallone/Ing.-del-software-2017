package it.polimi.ingsw.ps11.controller.message.toServer;

public class EndTurnMessage implements ClientMessage{

	@Override
	public void accept(ServerMessageRecognizer recognizer) {
		recognizer.handle(this);
	}

}
