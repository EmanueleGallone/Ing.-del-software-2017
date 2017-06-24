package it.polimi.ingsw.ps11.model.bonus.ema;

import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class ResourceExchangeBonus extends PlayerBonus {

	private ResourceList exchanger;
	private ResourceList exchangeable;
	
	public ResourceExchangeBonus(ResourceList exchanger, ResourceList exchangeable) {
		this.exchanger = exchanger;
		this.exchangeable = exchangeable;
	}
	
	@Override
	public void behavior() {
		//if( il giocatore ha scelto se scambiare la risorsa )
		//getOwner().getResourceList().subtract(exchanger);
		//getOwner().getResourceList().sum(exchangeable);
	}

}
