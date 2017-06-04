package it.polimi.ingsw.ps11.network.newServer.messages;

public class Default implements ServerMessageVisitor{

	@Override
	public void accept(ServerRecognizer recognizer) {
		recognizer.execute(this);
	}

}
