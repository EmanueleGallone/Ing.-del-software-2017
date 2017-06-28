package it.polimi.ingsw.ps11.model.gameLogics.states;

import it.polimi.ingsw.ps11.view.viewEvents.FamilySelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.FloorSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.HarvestSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.MarketSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.ProductionSelectedEvent;

public class FamilySelected extends PlayState {

	private FamilySelectedEvent event;
	
	public FamilySelected(FamilySelectedEvent event) {
		this.event = event;
	}
	
	@Override
	public void handle(FloorSelectedEvent floorSelectedEvent) {
		
	}
	
	@Override
	public void handle(HarvestSelectedEvent harvestSelectedEvent) {
	
	}
	
	@Override
	public void handle(MarketSelectedEvent marketSelectedEvent) {
	
	}
	
	@Override
	public void handle(ProductionSelectedEvent productionSelectedEvent) {
	
	}
	
	
}
