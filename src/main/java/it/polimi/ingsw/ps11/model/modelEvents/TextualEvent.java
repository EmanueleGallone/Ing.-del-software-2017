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
	

}
