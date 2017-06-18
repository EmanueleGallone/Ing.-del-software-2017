package it.polimi.ingsw.ps11.view.textualView.components;

import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.FloorView;

public class TextualFloorView extends FloorView {

	public TextualFloorView(Class<? extends Tower> tower, int whichFloor) {
		super(tower, whichFloor);
		this.cardView = new TextualCardView();
	}

	@Override
	public void print() {
		TextualConsole console = new TextualConsole();
		String card = "None";
		if (floor.getCard() != null)
			card = floor.getCard().getName();
		console.println( "Floor " + (whichFloor + 1) + "           Card: " + card +"           ActionCost: " + floor.getActionSpace().getActionCost());
	}
}
