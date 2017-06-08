package it.polimi.ingsw.ps11.mvc.view.textualView.components;

import it.polimi.ingsw.ps11.mvc.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.mvc.view.viewGenerica.components.FloorView;

public class TextualFloor extends FloorView {
	
	public TextualFloor(String id) {
		super(id);
	}

	@Override
	public void print() {
		TextualConsole console = new TextualConsole();
		console.println("Card: " + floor.getCard().getName() +" ActionCost: " + floor.getActionSpace().getActionCost());
	}
}
