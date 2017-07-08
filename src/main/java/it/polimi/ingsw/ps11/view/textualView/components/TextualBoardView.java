package it.polimi.ingsw.ps11.view.textualView.components;

import it.polimi.ingsw.ps11.model.cards.list.BlueCard;
import it.polimi.ingsw.ps11.model.cards.list.GreenCard;
import it.polimi.ingsw.ps11.model.cards.list.PurpleCard;
import it.polimi.ingsw.ps11.model.cards.list.YellowCard;
import it.polimi.ingsw.ps11.model.game.Board;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.BoardView;
import it.polimi.ingsw.ps11.view.viewGenerica.components.TowerView;

public class TextualBoardView extends BoardView {

	public TextualBoardView() {

		towerViews.add(new TextualTowerView("GreenTower"));
		towerViews.add(new TextualTowerView("BlueTower"));
		towerViews.add(new TextualTowerView("YellowTower"));
		towerViews.add(new TextualTowerView("PurpleTower"));
		
		diceView = new TextualDiceView();
		
		harvestView = new TextualHarvestView();
		productionView = new TextualProductionView();
		councilPalaceView = new TextualCouncilPalaceView();
		marketView = new TextualMarketView();
		churchView = new TextualChurchView();
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
		churchView.print();
		console.print("\n");
	}

}
