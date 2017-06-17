package it.polimi.ingsw.ps11.view.textualView.components;

import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.FloorView;

public class TextualFloor extends FloorView {
	

	@Override
	public void print() {
		TextualConsole console = new TextualConsole();
		console.println( whichFloor + " Card: " + floor.getCard().getName() +" ActionCost: " + floor.getActionSpace().getActionCost());
	}
}
