package it.polimi.ingsw.ps11.view.viewGenerica.components;

import it.polimi.ingsw.ps11.model.zones.harvestAndProduction.Production;
import it.polimi.ingsw.ps11.view.viewGenerica.ViewComponent;

public abstract class ProductionView extends ViewComponent{

	protected Production production;
	
	public void update(Production production){
		this.production = production;
	}
	
	//public abstract void selected();
}
