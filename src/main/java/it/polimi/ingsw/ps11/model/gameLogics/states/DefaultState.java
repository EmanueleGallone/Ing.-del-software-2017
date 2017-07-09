package it.polimi.ingsw.ps11.model.gameLogics.states;

import it.polimi.ingsw.ps11.model.gameLogics.State;
import it.polimi.ingsw.ps11.model.modelEvents.GameUpdateEvent;
import it.polimi.ingsw.ps11.model.modelEvents.TextualEvent;
import it.polimi.ingsw.ps11.view.viewEvents.ConfirmViewEvent;
import it.polimi.ingsw.ps11.view.viewEvents.EndTurnEvent;
import it.polimi.ingsw.ps11.view.viewEvents.FamilySelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.ResourceSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.TextualViewEvent;
import it.polimi.ingsw.ps11.view.viewEvents.ActiveLeaderCardEvent;
import it.polimi.ingsw.ps11.view.viewEvents.AskUpdateEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.FloorSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.HarvestSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.MarketSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.ProductionSelectedEvent;
/**
 * <h3> DefaultState </h3>
 * <p> Classe che rappresenta raccoglie ogni altro State. </p>
 * @see State
 */
public class DefaultState extends State {

	@Override
	public void handle(FloorSelectedEvent floorSelectedEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handle(FamilySelectedEvent familySelectedEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handle(MarketSelectedEvent marketSelectedEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handle(ProductionSelectedEvent productionSelectedEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handle(HarvestSelectedEvent harvestSelectedEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handle(ResourceSelectedEvent resourceSelectedEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handle(ConfirmViewEvent confirmEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handle(EndTurnEvent endTurnEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handle(AskUpdateEvent updateEvent) {
		stateHandler().invoke(new GameUpdateEvent(stateHandler().getGame()));
	}

	@Override
	public void notifyToClient() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handle(TextualViewEvent textualViewEvent) {
		stateHandler().getGameLogic().notifyAllClients(new TextualEvent(textualViewEvent.getMessage()));
	}

	@Override
	public void handle(ActiveLeaderCardEvent activeLeaderCardEvent) {
		// TODO Auto-generated method stub
		
	}

}
