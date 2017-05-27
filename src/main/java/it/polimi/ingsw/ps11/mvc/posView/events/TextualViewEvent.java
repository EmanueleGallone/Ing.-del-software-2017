package it.polimi.ingsw.ps11.mvc.posView.events;

import it.polimi.ingsw.ps11.cranio.events.Event;
import it.polimi.ingsw.ps11.mvc.posView.TextualView;

public class TextualViewEvent<TYPE> extends Event<TYPE> {

	private TextualView textualView;
	private String input;
	
	public TextualViewEvent() {
		
	}
	
	public TextualViewEvent(TYPE source) {
		this.source = source;
	}
	
	public TextualViewEvent(TYPE source,TextualView textualView) {
		this.source = source;
		this.textualView = textualView;
	}
	
	public TextualViewEvent(TYPE source,String string) {
		this.source = source;
		this.input = string;
	}
	
	public TextualView getTextualView() {
		return textualView;
	}
	
	public String getInput() {
		return input;
	}
	
	public void setInput(String input) {
		this.input = input;
	}
	public void setTextualView(TextualView textualView) {
		this.textualView = textualView;
	}
}
