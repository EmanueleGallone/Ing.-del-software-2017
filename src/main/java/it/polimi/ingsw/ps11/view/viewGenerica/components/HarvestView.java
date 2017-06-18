package it.polimi.ingsw.ps11.view.viewGenerica.components;

import it.polimi.ingsw.ps11.model.zones.harvestAndProduction.Production;
import it.polimi.ingsw.ps11.view.viewGenerica.ViewComponent;

public abstract class HarvestView extends ViewComponent{
	
	protected Production harvest;
	
	public void update(Production harvest){
		this.harvest = harvest;
	}
}
