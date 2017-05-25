package it.polimi.ingsw.ps11.cranio.events.list;

import it.polimi.ingsw.ps11.cranio.events.Event;
import it.polimi.ingsw.ps11.mvc.posView.TextualView;

public class TextualViewEvent extends Event<TextualView>{

	public TextualViewEvent() {
	
	}
	
	public TextualViewEvent(TextualView textualView) {
		this.source = textualView;
	}
	
	
}
