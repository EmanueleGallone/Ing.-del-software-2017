package it.polimi.ingsw.ps11.view.viewGenerica.components;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.zones.Board;
import it.polimi.ingsw.ps11.view.viewGenerica.ViewComponent;

public abstract class BoardView extends ViewComponent {

	protected ArrayList<TowerView> towerViews = new ArrayList<>(); 
	protected HarvestView harvestView;
	protected ProductionView productionView;
	protected DiceView diceView;
	protected CouncilPalaceView councilPalaceView;
	protected MarketView marketView;
	//protected ChurchView churchView;
	
	public BoardView() {
	
	}
	
	public void update(Board board) {
		productionView.update(board.getProduction());
		harvestView.update(board.getHarvest());
		diceView.update(board.getDices());
		councilPalaceView.update(board.getCouncilPalace());
		marketView.update(board.getMarket());
		//churchView.update(board.getChurch());
		
		for(TowerView t : towerViews){
			t.update(board.getTower(t.getTower()));
		}
	}
	
	public ArrayList<TowerView> getTowerViews() {
		return towerViews;
	}


}
