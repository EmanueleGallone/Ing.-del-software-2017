package it.polimi.ingsw.ps11.view.textualView.components;

import it.polimi.ingsw.ps11.model.zones.Board;
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
		marketView = new TextualMarketView();
		//churchView = new TextualChurchView();
	}
	
	public TextualBoardView(Board board){
		this();
		update(board);
		
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
		marketView.print();
		console.print("\n");
		//churchView.print();
		//console.print("\n");
	}

}
