package it.polimi.ingsw.ps11.view.viewGenerica.components;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.game.Board;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.view.viewGenerica.ViewComponent;
/**
 * <h3> BoardView</h3>
 * <p> Classe astratta che rappesenta la view del tabellone di gioco generale.</p>
 * @see Board
 */
public abstract class BoardView extends ViewComponent {

	protected ArrayList<TowerView> towerViews = new ArrayList<>(); 
	protected HarvestView harvestView;
	protected ProductionView productionView;
	protected DiceView diceView;
	protected CouncilPalaceView councilPalaceView;
	protected MarketView marketView;
	protected ArrayList<Player> currentOrder;
	protected ChurchView churchView;
	
	public BoardView() {
	
	}

	public void update(Board board) {
		productionView.update(board.getProduction());
		harvestView.update(board.getHarvest());
		diceView.update(board.getDices());
		councilPalaceView.update(board.getCouncilPalace());
		marketView.update(board.getMarket());
		churchView.update(board.getChurch());
		
		for(TowerView t : towerViews){
			t.update(board.getTower(t.getTowerName()));
		}
	}
	
	public ArrayList<TowerView> getTowerViews() {
		return towerViews;
	}

	public void setTower(ArrayList <TowerView> x){
		this.towerViews = x;
	};
	
	public void setTower(int index, TowerView t){
		towerViews.set(index, t);
	};
	
	
	public DiceView getDiceView() {
		return diceView;
	}
	
	public HarvestView getHarvestView() {
		return harvestView;
	}
	
	public CouncilPalaceView getCouncilPalaceView() {
		return councilPalaceView;
	}
	
	public MarketView getMarketView() {
		return marketView;
	}
	public ProductionView getProductionView() {
		return productionView;
	}
	
	public ChurchView getChurchView() {
		return churchView;
	}

	public void update(ArrayList<Player> currentOrder) {
		this.currentOrder = currentOrder;
	}

}
