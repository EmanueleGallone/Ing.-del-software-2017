package it.polimi.ingsw.ps11.view.textualView.components;

import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.FloorView;

public class TextualFloorView extends FloorView {

	private final int SPACE = 20;
	
	public TextualFloorView(Class<? extends Tower> whichTower, int whichFloor) {
		super(whichTower, whichFloor);
		this.cardView = new TextualDevelopmentCardView();
		this.resourceView = new TextualResourceView();
	}

	@Override
	public void print() {
		//vorrei mostrare il giocatore invece del familiare
		TextualConsole console = new TextualConsole();
		String card = "None";
		String family = "None";
		int actionCost = 1;
		
		if (floor != null && floor.getCard() != null)
			card = floor.getCard().getName();
		
		if(floor != null && floor.getActionSpace().getFamilyMember() != null)
			family = floor.getActionSpace().getFamilyMember().getClass().getSimpleName();
		
		//if(floor.getActionSpace().getActionCost() != null)
			actionCost = floor.getActionSpace().getActionCost();
		
		console.print( "Floor " + (whichFloor + 1) 
						+ "           Card: " + card 
						+ console.printSpace(SPACE-card.length()) + "ActionCost: " + actionCost
						+ console.printSpace(SPACE-family.length()) + "Occupied : " + family
						+"\t"
						);
		
		if(floor.getActionSpace().getResources() != null){
			resourceView.update(floor.getActionSpace().getResources());
			resourceView.print();
			console.println("");
		}
	}
	
}
