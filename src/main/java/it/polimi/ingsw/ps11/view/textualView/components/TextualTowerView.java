package it.polimi.ingsw.ps11.view.textualView.components;

import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.FloorView;
import it.polimi.ingsw.ps11.view.viewGenerica.components.TowerView;

public class TextualTowerView extends TowerView {

	
	public TextualTowerView(Class<? extends Tower> whichTower, String towerName) {
		super(whichTower,towerName);
		
		for(int i = 0; i< TOWERNUMBER; i++){
			floorViews.add(new TextualFloorView(whichTower, i));
		}
	}
	
	public TextualTowerView(Class<? extends Tower> whichTower) {
		this(whichTower,whichTower.getSimpleName());
	}
	
	public TextualTowerView(Tower tower) {
		super(tower);
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
			this.floorViews.get(0).selected();
			//crea evento dicendo quale torre e' stata selezionata e mi fermo.
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
