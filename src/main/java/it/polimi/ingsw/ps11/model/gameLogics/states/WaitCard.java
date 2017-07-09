package it.polimi.ingsw.ps11.model.gameLogics.states;

import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.familyMember.list.NeutralFamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.GetCardAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInFloorAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInSpaceAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInTowerAction;
import it.polimi.ingsw.ps11.model.modelEvents.ModelEvent;
import it.polimi.ingsw.ps11.model.modelEvents.TextualEvent;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.view.viewEvents.ResourceSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.FloorSelectedEvent;

public class WaitCard extends PlayState{

	private FloorSelectedEvent event;
	private String cardType;
	private Floor floor;
	private Tower tower;
	private int value;
	
	public WaitCard(String cardType, int value) {
		this.cardType = cardType;
		this.value = value;
	}
	
	@Override
	public void handle(FloorSelectedEvent floorSelectedEvent) {
		Tower tower = stateHandler().getGame().getBoard().getTower(floorSelectedEvent.getTower());
		this.tower = tower;
		floor = tower.getFloor(floorSelectedEvent.getFloor());
		String card = floor.getCard().getId();

		if(floor.getCard() != null && (card.equals(cardType) || cardType == null)){
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
		NeutralFamilyMember fMember = new NeutralFamilyMember();
		ActionManager aManager = stateHandler().actions();
		
		FamilyInSpaceAction sAction = new FamilyInSpaceAction(aManager,null, floor.getActionSpace());
		sAction.addModifier(value);
		sAction.setAlreadyDone(false);
		FamilyInTowerAction tAction = new FamilyInTowerAction(aManager, tower, fMember);
		GetCardAction getCard = new GetCardAction(aManager, floor, cost);
		
		FamilyInFloorAction action = new FamilyInFloorAction(aManager,tAction, sAction, getCard);
		
		sAction = aManager.affect(sAction);
		tAction = aManager.affect(tAction);
		getCard = aManager.affect(getCard);
		action = aManager.affect(action);
		
		FloorSelected state = new FloorSelected(event);
		stateHandler().nextState(state);
		state.execute(tAction, sAction, getCard);
	}
	
	@Override
	public void handle(ResourceSelectedEvent resourceSelectedEvent) {
		getCard(resourceSelectedEvent.getResourceList());
	}
	
	@Override
	public void notifyToClient() {
		stateHandler().invoke(new TextualEvent("Seleziona una carta su un piano di valore >= ad "+ value));
	}
}
