package it.polimi.ingsw.ps11.view.viewEvents;

public class TextualViewEvent extends ViewEvent{

	private String message = "";
	
	public TextualViewEvent(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	@Override
	public void accept(ViewListener listener) {
		listener.handle(this);
	}

}
