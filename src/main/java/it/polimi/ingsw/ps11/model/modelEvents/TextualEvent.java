package it.polimi.ingsw.ps11.model.modelEvents;

public class TextualEvent extends ModelEvent {

	private String message;
	
	public TextualEvent(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

	@Override
	public void accept(ModelListener listener) {
		listener.handle(this);
	}

	@Override
	public TextualEvent clone() {
		TextualEvent copy = new TextualEvent(message);
		if(getReceiver()!=null)
			copy.setReceiver(getReceiver().clone());
		return copy;
	}
	
	

}
