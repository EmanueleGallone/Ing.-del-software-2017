package it.polimi.ingsw.ps11.view.viewGenerica.components;

import it.polimi.ingsw.ps11.model.zones.yield.Yield;
import it.polimi.ingsw.ps11.view.viewGenerica.ViewComponent;

public abstract class ProductionView extends ViewComponent{

	protected Yield production;
	
	public void update(Yield production){
		this.production = production;
	}
	
}
