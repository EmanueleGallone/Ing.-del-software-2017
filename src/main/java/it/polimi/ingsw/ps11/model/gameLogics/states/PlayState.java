package it.polimi.ingsw.ps11.model.gameLogics.states;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInSpaceAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInYieldAction;
import it.polimi.ingsw.ps11.model.modelEvents.TextualEvent;
import it.polimi.ingsw.ps11.model.zones.Market;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.yield.Yield;
import it.polimi.ingsw.ps11.view.viewEvents.ConfirmViewEvent;
import it.polimi.ingsw.ps11.view.viewEvents.EndTurnEvent;
import it.polimi.ingsw.ps11.view.viewEvents.FamilySelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.ResourceSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.FloorSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.HarvestSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.MarketSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.ProductionSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.SpaceSelectedEvent;

public class PlayState extends DefaultState{

	
	//EventManager manager = new EventManager();
	
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
	public void handle(ConfirmViewEvent confirmEvent) {
		
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
			Market market = stateHandler().getGame().getBoard().getMarket();
			ActionSpace space = market.getActionSpace(marketSelectedEvent.getActionSpace());
			ActionManager aManager = stateHandler().actions();
			FamilyInSpaceAction action = new FamilyInSpaceAction(aManager,selectFMember(marketSelectedEvent), space);
			action = aManager.affect(action);
			stateHandler().nextState(new WaitConfirm(action));
		}
	}
	
	protected FamilyMember selectFMember(SpaceSelectedEvent event){
		String fName= event.getFamilySelectedEvent().getFamilyMember();
		return stateHandler().getPlayer().getFamilyManager().getFamilyMember(fName);	
	}
	
	@Override
	public void handle(ProductionSelectedEvent productionSelectedEvent) {
		if(familySelectedCheck(productionSelectedEvent)){
			FamilyMember fMember = selectFMember(productionSelectedEvent);
			Yield yield = stateHandler().getGame().getBoard().getProduction();
			placeFamilyInYield(yield, fMember);
		}
	}

	@Override
	public void handle(HarvestSelectedEvent harvestSelectedEvent) {
		if(familySelectedCheck(harvestSelectedEvent)){
			FamilyMember fMember = selectFMember(harvestSelectedEvent);
			Yield yield = stateHandler().getGame().getBoard().getHarvest();
			placeFamilyInYield(yield, fMember);
		}
	}
	
	protected void placeFamilyInYield(Yield yield, FamilyMember fMember){
		ActionManager aManager = stateHandler().actions();
		FamilyInYieldAction action = new FamilyInYieldAction(aManager, yield, fMember);
		action = aManager.affect(action);
		stateHandler().nextState(new WaitConfirm(action));
	}

	@Override
	public void handle(EndTurnEvent endTurnEvent) {
		stateHandler().getGameLogic().nextPlayer();
	}


}
