package it.polimi.ingsw.ps11.view.textualView.components;

import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.BoardView;
import it.polimi.ingsw.ps11.view.viewGenerica.components.TowerView;

public class TextualBoardView extends BoardView {

	public TextualBoardView() {
		//Questa cosa potrebbe essere convertita un un ciclo, sarebbe meglio??
		towerViews.add(new TextualTowerView(0,"GreenTower"));
		towerViews.add(new TextualTowerView(1,"BlueTower"));
		towerViews.add(new TextualTowerView(2,"YellowTower"));
		towerViews.add(new TextualTowerView(3,"PurpleTower"));
		
		diceView = new TextualDiceView();
		
		harvestView = new TextualHarvestView();
		productionView = new TextualProductionView();
		councilPalaceView = new TextualCouncilPalaceView();
	}
	
	@Override
	public void print() {
		TextualConsole console = new TextualConsole();
		console.println("\t\t\tBoard \n");
		for(TowerView towerView : towerViews){
			towerView.print();
			console.print("\n");
		}
		diceView.print();
		console.print("\n");
		harvestView.print();
		console.print("\n");
		productionView.print();
		console.print("\n");
		councilPalaceView.print();
		console.print("\n");
	}

}
