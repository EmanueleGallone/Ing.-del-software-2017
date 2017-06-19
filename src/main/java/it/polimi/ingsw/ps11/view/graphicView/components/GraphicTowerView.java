package it.polimi.ingsw.ps11.view.graphicView.components;

import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.view.viewGenerica.components.TowerView;

public class GraphicTowerView extends TowerView{

	//pannello Tower
	
	public GraphicTowerView(Class<? extends Tower> towerColor) {
		super(0);
		
		/*floors.add(new GraphicFloorView(towerColor, 0));
		floors.add(new TextualFloorView(towerColor, 1));
		floors.add(new TextualFloorView(towerColor, 2));
		floors.add(new TextualFloorView(towerColor, 3));
		*/
	}

	@Override
	public void print() {
		
	}

}
