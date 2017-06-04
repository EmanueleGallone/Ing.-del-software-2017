package it.polimi.ingsw.ps11.network.newServer.messages;

public interface ServerMessageVisitor {
	public void accept(ServerRecognizer recognizer);
}
