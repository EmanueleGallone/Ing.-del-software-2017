package it.polimi.ingsw.ps11.view.viewEvents;

import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.CouncilSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.FloorSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.HarvestSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.MarketSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.ProductionSelectedEvent;

public interface ViewListener {

	public void handle(FloorSelectedEvent floorSelectedEvent);
	public void handle(FamilySelectedEvent familySelectedEvent);
	public void handle(MarketSelectedEvent marketSelectedEvent);
	public void handle(ProductionSelectedEvent productionSelectedEvent);
	public void handle(HarvestSelectedEvent harvestSelectedEvent);
	public void handle(ResourceSelectedEvent resourceSelectedEvent);
	public void handle(ConfirmViewEvent confirmEvent);
	public void handle(EndTurnEvent endTurnEvent);
	public void handle(AskUpdateEvent updateEvent);
	public void handle(TextualViewEvent textualViewEvent);
	public void handle(ActiveLeaderCardEvent activeLeaderCardEvent);
	public void handle(CouncilSelectedEvent councilSelectedEvent);
}
