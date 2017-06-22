package it.polimi.ingsw.ps11.view.textualView.components;

import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.FloorView;
import it.polimi.ingsw.ps11.view.viewGenerica.components.TowerView;

public class TextualTowerView extends TowerView {

	public TextualTowerView(int whichTower, String towerName) {
		super(whichTower,towerName);
		for(int i = 0; i< TOWERNUMBER; i++){
			floors.add(new TextualFloorView(whichTower, i));
		}
	}

	@Override
	public void print() {
		TextualConsole console = new TextualConsole();
		console.println(towerName + "\n");
		for(FloorView f : floors){
			f.print();
		}
	}
	
	@Override
	public void selected(){
		TextualConsole console = new TextualConsole();
		console.println("(Presso 0 to Cancel)");
		console.print("Select the Floor : ");
		String whichFloor = console.read();
		
		switch (whichFloor) {
		case "1":
			//l'attributo tower indica la torre attuale -> vedi in TowerView
			// new FloorSelectedEvent(tower, 1);
			break;
		case "2":
			// new FloorSelectedEvent(tower, 2);
			break;
		case "3":
			// new FloorSelectedEvent(tower, 3);
			break;
		case "4":
			// new FloorSelectedEvent(tower, 4);
			break;

		case "0":
			return;
			
		default:
			console.printError("Unknown command");
			break;
		}
	}
	
}
