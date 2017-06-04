package it.polimi.ingsw.ps11.posNetwork.messages;

public class TextualMessage extends Message<String>{

	public TextualMessage(String message) {
		super(message);
	}

	@Override
	public void gAccept(GenericRecogniser r) {
		r.execute(this);
	}

}
