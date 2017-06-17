package it.polimi.ingsw.ps11.view.viewGenerica.components;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.zones.Board;
import it.polimi.ingsw.ps11.view.viewGenerica.ViewComponent;

public abstract class BoardView extends ViewComponent {

	private ArrayList<TowerView> towerViews;
	private HarvestView harvestView;
	private ProductionView productionView;
	private DiceView diceView;
	private CouncilPalaceView councilPalaceView;
	
	public BoardView() {
		
	}
	
	public void update(Board board) {
		productionView.update(board.getProduction());
		harvestView.update(board.getHarvest());
		diceView.update(board.getDices());
		councilPalaceView.update(board.getCouncilPalace());
		for(TowerView t : towerViews){
			t.update(board.getTower(t.getTower()));
		}
	}


}
