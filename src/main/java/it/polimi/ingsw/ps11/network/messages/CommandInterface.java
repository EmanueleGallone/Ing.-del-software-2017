package it.polimi.ingsw.ps11.network.messages;

public interface CommandInterface {
	public void accept(CommandRecognizer recognizer);
}
