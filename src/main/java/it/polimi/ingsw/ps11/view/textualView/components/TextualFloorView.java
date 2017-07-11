package it.polimi.ingsw.ps11.view.textualView.components;

import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.FloorView;
/**
 * <p>
 * Modulo della CLI che permette di stampare un piano inerente ad una torre. verra' visualizzata a schermo la carta, l'eventuale risorsa e lo spazio azione
 * </p>
 *
 */
public class TextualFloorView extends FloorView {

	private final int SPACE = 30;
	
	public TextualFloorView(String whichTower, int whichFloor) {
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
			family = floor.getActionSpace().getFamilyMember().getId();
		
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
