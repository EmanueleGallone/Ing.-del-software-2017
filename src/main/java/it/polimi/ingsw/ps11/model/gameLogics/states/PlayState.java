package it.polimi.ingsw.ps11.model.gameLogics.states;

import it.polimi.ingsw.ps11.model.gameLogics.State;
import it.polimi.ingsw.ps11.model.modelEvents.TextualEvent;
import it.polimi.ingsw.ps11.view.viewEvents.ConfirmEvent;
import it.polimi.ingsw.ps11.view.viewEvents.FamilySelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.ResourceSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.FloorSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.HarvestSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.MarketSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.ProductionSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.SpaceSelectedEvent;

public class PlayState extends State{

	
	public PlayState() {
	
	}
	
	private boolean familySelectedCheck(SpaceSelectedEvent event){
		if(!event.isComplete()){
			stateHandler().nextState(new WaitingFamilyMember(event));
			stateHandler().invoke(new TextualEvent("Seleziona un family member"));
			return false;
		}
		return true;
	}
	
// Events handling

	@Override
	public void handle(ConfirmEvent confirmEvent) {
		
	}
	
	@Override
	public void handle(ResourceSelectedEvent resourceSelectedEvent) {
		
	}
	
	@Override
	public void handle(FamilySelectedEvent familySelectedEvent) {
		stateHandler().nextState(new WaitingActionSpace(familySelectedEvent));
	}
	
	@Override
	public void handle(FloorSelectedEvent floorSelectedEvent) {
		stateHandler().nextState(new FloorSelected(floorSelectedEvent));
	}

	@Override
	public void handle(MarketSelectedEvent marketSelectedEvent) {
		if(familySelectedCheck(marketSelectedEvent)){
			
		}
	}

	@Override
	public void handle(ProductionSelectedEvent productionSelectedEvent) {
		if(familySelectedCheck(productionSelectedEvent)){
			
		}
	}

	@Override
	public void handle(HarvestSelectedEvent harvestSelectedEvent) {
		if(familySelectedCheck(harvestSelectedEvent)){
			
		}
	}


}
