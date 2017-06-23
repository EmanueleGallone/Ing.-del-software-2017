package it.polimi.ingsw.ps11.view.textualView.components;

import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.FloorView;

public class TextualFloorView extends FloorView {
	
	private final int SPACE = 30;
	
	public TextualFloorView(Class<? extends Tower> whichTower, int whichFloor) {
		super(whichTower, whichFloor);
		this.cardView = new TextualDevelopmentCardView();
		this.resourceView = new TextualResourceView();
	}

	@Override
	public void print() {
		TextualConsole console = new TextualConsole();
		String card = "None";
		
		if (floor.getCard() != null)
			card = floor.getCard().getName();
		
		console.print( "Floor " + (whichFloor + 1) 
						+ "           Card: " + card 
						+ console.printSpace(SPACE-card.length()) + "ActionCost: " + floor.getActionSpace().getActionCost()
						+ "\t"
						);
		
		if(floor.getActionSpace().getResources() != null){
			resourceView.update(floor.getActionSpace().getResources());
			resourceView.print();
			console.println("");
		}
		
	}
	
	@Override
	public void selected() {
		TextualConsole console = new TextualConsole();
		//qui posso stampare i dettagli della carta e poi chiedere se conferma l'azione di posizionare il familiare
		
		if(this.floor.getCard() != null){
			this.cardView.update(this.floor.getCard());
			this.cardView.print();
		}
		
		
		console.print("\nDEBUG Sei arrivato al floor : " + this.whichFloor +" della torre : " + this.tower);
		console.print("\nDo you confirm the choice? (y/n)");
		String choice = console.read();
		if("y".equalsIgnoreCase(choice)){
			//crea evento con parametri 
		}
		else {
			return;
		}
	}
	
}
