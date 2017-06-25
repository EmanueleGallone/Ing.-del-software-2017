package it.polimi.ingsw.ps11.view.viewGenerica.components;

import it.polimi.ingsw.ps11.model.zones.yield.Yield;
import it.polimi.ingsw.ps11.view.viewGenerica.ViewComponent;

public abstract class HarvestView extends ViewComponent{
	
	protected Yield harvest;
	
	public void update(Yield harvest){
		this.harvest = harvest;
	}
}
