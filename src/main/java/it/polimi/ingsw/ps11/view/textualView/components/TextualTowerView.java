package it.polimi.ingsw.ps11.view.textualView.components;

import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.FloorView;
import it.polimi.ingsw.ps11.view.viewGenerica.components.TowerView;

public class TextualTowerView extends TowerView {

	public TextualTowerView(int whichTower, String towerName) {
		super(whichTower,towerName);
		floors.add(new TextualFloorView(whichTower, 0));
		floors.add(new TextualFloorView(whichTower, 1));
		floors.add(new TextualFloorView(whichTower, 2));
		floors.add(new TextualFloorView(whichTower, 3));
	}

	@Override
	public void print() {
		TextualConsole console = new TextualConsole();
		console.println(towerName + "\n");
		for(FloorView f : floors){
			f.print();
		}
	}
}
