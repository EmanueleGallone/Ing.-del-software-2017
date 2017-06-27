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
		this(tower.getClass());
		update(tower);
	}

	@Override
	public void print() {
		TextualConsole console = new TextualConsole();
		console.println(towerName + "\n");
		for(FloorView f : floorViews){
			f.print();
		}
	}
	
}
