package it.polimi.ingsw.ps11.network.genericMessage;

public class TextualMessage extends Message<String>{

	public TextualMessage(String message) {
		super(message);
	}

	@Override
	public void gAccept(GenericRecogniser r) {
		r.execute(this);
	}

}
