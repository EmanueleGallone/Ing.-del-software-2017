package it.polimi.ingsw.ps11.network.messages;

public class DefaultCommand implements CommandInterface{

	@Override
	public void accept(CommandRecognizer recognizer) {
		recognizer.execute(this);
	}

}
