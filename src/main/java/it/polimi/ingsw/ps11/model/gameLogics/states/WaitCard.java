package it.polimi.ingsw.ps11.model.gameLogics.states;

import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.GetCardAction;
import it.polimi.ingsw.ps11.model.modelEvents.ModelEvent;
import it.polimi.ingsw.ps11.model.modelEvents.TextualEvent;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.FloorSelectedEvent;

public class WaitCard extends PlayState{

	String cardType;
	
	public WaitCard(String cardType) {
		this.cardType = cardType;
	}
	
	@Override
	public void handle(FloorSelectedEvent floorSelectedEvent) {
		Tower tower = stateHandler().getGame().getBoard().getTower(floorSelectedEvent.getTower());
		Floor floor = tower.getFloor(floorSelectedEvent.getFloor());
		String card = floor.getCard().getClass().toString();
		if(floor.getCard() != null && floor.getActionSpace().isFree() && (card.equals(cardType) || cardType == null)){
			GetCardAction action = stateHandler().actions().newGetCardAction(floor.getCard(), null);
			action.attach(listener);
			if(action.isLegal()){
				action.perform();
				stateHandler().resetState();
			}
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
}
