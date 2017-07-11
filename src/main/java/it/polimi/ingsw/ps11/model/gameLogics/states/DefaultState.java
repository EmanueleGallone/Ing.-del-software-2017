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
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.CouncilSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.FloorSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.HarvestSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.MarketSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.ProductionSelectedEvent;
/**
 * <h3> DefaultState </h3>
 * <p> Classe che lo stato di Default, raccoglie ogni altro State e li gestisce tramite il Visitor Pattern. </p>
 * @see State
 */
public class DefaultState extends State {

	
	private void defCommand(){
		stateHandler().invoke("Is not your turn!");
	}
	
	@Override
	public void handle(FloorSelectedEvent floorSelectedEvent) {
		defCommand();
	}

	@Override
	public void handle(FamilySelectedEvent familySelectedEvent) {
		defCommand();
	}

	@Override
	public void handle(MarketSelectedEvent marketSelectedEvent) {
		defCommand();
	}

	@Override
	public void handle(ProductionSelectedEvent productionSelectedEvent) {
		defCommand();
	}
	
	@Override
	public void handle(TextualViewEvent textualViewEvent) {
		stateHandler().getGameLogic().notifyAllClients(new TextualEvent(textualViewEvent.getMessage()));
	}

	@Override
	public void handle(HarvestSelectedEvent harvestSelectedEvent) {
		defCommand();
	}

	@Override
	public void handle(ResourceSelectedEvent resourceSelectedEvent) {
		defCommand();
	}

	@Override
	public void handle(ConfirmViewEvent confirmEvent) {}

	@Override
	public void handle(EndTurnEvent endTurnEvent) {
		defCommand();
	}

	@Override
	public void handle(AskUpdateEvent updateEvent) {
		stateHandler().invoke(new GameUpdateEvent(stateHandler().getGame()));
	}

	@Override
	public void notifyToClient() {}

	@Override
	public void handle(ActiveLeaderCardEvent activeLeaderCardEvent) {
		defCommand();
	}

	@Override
	public void handle(CouncilSelectedEvent councilSelectedEvent) {}

}
