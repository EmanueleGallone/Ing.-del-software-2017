package it.polimi.ingsw.ps11.network.messages;

public interface Command {
	public void accept(CommandRecognizer recognizer);
}
