package it.polimi.ingsw.ps11.view.viewGenerica.components;

import it.polimi.ingsw.ps11.model.zones.Market;
import it.polimi.ingsw.ps11.view.viewGenerica.ViewComponent;

public abstract class MarketView extends ViewComponent {

	protected Market market = new Market(4);
	
	public void update(Market market) {
		this.market = market;
	}
}
