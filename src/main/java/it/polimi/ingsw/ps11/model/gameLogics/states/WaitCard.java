package it.polimi.ingsw.ps11.model.gameLogics.states;

import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.GetCardAction;
import it.polimi.ingsw.ps11.model.modelEvents.ModelEvent;
import it.polimi.ingsw.ps11.model.modelEvents.TextualEvent;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.view.viewEvents.ResourceSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.FloorSelectedEvent;

public class WaitCard extends PlayState{

	String cardType;
	private Floor floor;
	
	public WaitCard(String cardType) {
		this.cardType = cardType;
		stateHandler().invoke(new TextualEvent("Seleziona una carta da prendere tramite il bonus"));
	}
	
	@Override
	public void handle(FloorSelectedEvent floorSelectedEvent) {
		Tower tower = stateHandler().getGame().getBoard().getTower(floorSelectedEvent.getTower());
		floor = tower.getFloor(floorSelectedEvent.getFloor());
		String card = floor.getCard().getClass().toString();
		if(floor.getCard() != null && floor.getActionSpace().isFree() && (card.equals(cardType) || cardType == null)){
			getCard(null);
		}else {
			stateHandler().invoke(new TextualEvent("Non puoi selezionare questa carta"));
		}
	}
	
	private EventListener<ModelEvent> listener = new EventListener<ModelEvent>() {

		@Override
		public void handle(ModelEvent e) {
			stateHandler().invoke(e);
		}
	};
	
	public void getCard(ResourceList cost){
		GetCardAction getCard = stateHandler().actions().newGetCardAction(floor.getCard(), null);
		if(getCard.isLegal()){
			getCard.perform();
			stateHandler().resetState();
		}
	}
	
	@Override
	public void handle(ResourceSelectedEvent resourceSelectedEvent) {
		getCard(resourceSelectedEvent.getResourceList());
	}
}
