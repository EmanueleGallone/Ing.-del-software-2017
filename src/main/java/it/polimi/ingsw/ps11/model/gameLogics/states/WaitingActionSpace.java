package it.polimi.ingsw.ps11.model.gameLogics.states;

import it.polimi.ingsw.ps11.view.viewEvents.FamilySelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.CouncilSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.FloorSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.HarvestSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.MarketSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.ProductionSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.SpaceSelectedEvent;
/**
 * <h3> State </h3>
 * <p> Classe che rappresenta lo stato di attesa della scelta dell'action space su cui posizionare il familiare da parte del giocatore.</p>
 * @see 
 */
public class WaitingActionSpace extends PlayState {

	private FamilySelectedEvent familyMember;
	
	public WaitingActionSpace(FamilySelectedEvent familySelectedEvent) {
		this.familyMember = familySelectedEvent;
	}
	
	
	public void actionSpaceSelected(SpaceSelectedEvent event){
		event.setFamilySelectedEvent(familyMember);
		stateHandler().nextState(new PlayState());
		event.accept(stateHandler().currentState());
	}
	
	@Override
	public void handle(FloorSelectedEvent floorSelectedEvent) {
		stateHandler().nextState(new FloorSelected(floorSelectedEvent));
		stateHandler().currentState().handle(familyMember);
	}
	
	@Override
	public void handle(MarketSelectedEvent marketSelectedEvent) {
		actionSpaceSelected(marketSelectedEvent);
	}

	@Override
	public void handle(ProductionSelectedEvent productionSelectedEvent) {
		actionSpaceSelected(productionSelectedEvent);
	}

	@Override
	public void handle(HarvestSelectedEvent harvestSelectedEvent) {
		actionSpaceSelected(harvestSelectedEvent);
	}
	
	@Override
	public void handle(CouncilSelectedEvent councilSelectedEvent) {
		actionSpaceSelected(councilSelectedEvent);

	}
	
}
