package it.polimi.ingsw.ps11.view.textualView.components;

import it.polimi.ingsw.ps11.model.zones.towers.BlueTower;
import it.polimi.ingsw.ps11.model.zones.towers.GreenTower;
import it.polimi.ingsw.ps11.model.zones.towers.PurpleTower;
import it.polimi.ingsw.ps11.model.zones.towers.YellowTower;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.BoardView;
import it.polimi.ingsw.ps11.view.viewGenerica.components.TowerView;

public class TextualBoardView extends BoardView {

	public TextualBoardView() {
		//Questa cosa potrebbe essere convertita un un ciclo, sarebbe meglio??
		towerViews.add(new TextualTowerView(GreenTower.class));
		towerViews.add(new TextualTowerView(BlueTower.class));
		towerViews.add(new TextualTowerView(YellowTower.class));
		towerViews.add(new TextualTowerView(PurpleTower.class));
		
		diceView = new TextualDiceView();
		
		harvestView = new TextualHarvestView();
		productionView = new TextualProductionView();
		councilPalaceView = new TextualCouncilPalaceView();
	}
	
	@Override
	public void print() {
		TextualConsole console = new TextualConsole();
		console.println("Board: ");
		for(TowerView towerView : towerViews){
			towerView.print();
		}
		harvestView.print();
		productionView.print();
		councilPalaceView.print();
		diceView.print();
	}

}
