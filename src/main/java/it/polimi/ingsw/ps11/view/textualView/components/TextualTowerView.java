package it.polimi.ingsw.ps11.view.textualView.components;

import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.FloorView;
import it.polimi.ingsw.ps11.view.viewGenerica.components.TowerView;

public class TextualTowerView extends TowerView {

	public TextualTowerView(Class<? extends Tower> towerColor) {
		super(towerColor);
		floors.add(new TextualFloorView(towerColor, 0));
		floors.add(new TextualFloorView(towerColor, 1));
		floors.add(new TextualFloorView(towerColor, 2));
		floors.add(new TextualFloorView(towerColor, 3));
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
