package it.polimi.ingsw.ps11.view.textualView.components;

import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.FloorView;
import it.polimi.ingsw.ps11.view.viewGenerica.components.TowerView;

public class TextualTowerView extends TowerView {

	public TextualTowerView(int whichTower, String towerName) {
		super(whichTower,towerName);
		for(int i = 0; i< TOWERNUMBER; i++){
			floorViews.add(new TextualFloorView(whichTower, i));
		}
	}

	@Override
	public void print() {
		TextualConsole console = new TextualConsole();
		console.println(towerName + "\n");
		for(FloorView f : floorViews){
			f.print();
		}
	}
	
	@Override
	public void selected(){
		TextualConsole console = new TextualConsole();
		console.print("Select the Floor (Presso 0 to Cancel): ");
		String whichFloor = console.read();
		
		//lo switch e' necessario per il controllo sull'input
		switch (whichFloor) {
		case "1":
			//l'attributo tower indica la torre attuale -> vedi in TowerView
			this.floorViews.get(0).selected();
			break;
		case "2":
			this.floorViews.get(1).selected();
			break;
		case "3":
			this.floorViews.get(2).selected();
			break;
		case "4":
			this.floorViews.get(3).selected();
			break;

		case "0":
			return;
			
		default:
			console.printError("Unknown command");
			break;
		}
	}
	
}
