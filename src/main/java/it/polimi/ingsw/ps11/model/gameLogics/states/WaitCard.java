package it.polimi.ingsw.ps11.model.gameLogics.states;

import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.familyMember.list.NeutralFamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.GetCardAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.family.FamilyInFloorAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.family.FamilyInSpaceAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.family.FamilyInTowerAction;
import it.polimi.ingsw.ps11.model.modelEvents.ModelEvent;
import it.polimi.ingsw.ps11.model.modelEvents.TextualEvent;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.view.viewEvents.ResourceSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.FloorSelectedEvent;

public class WaitCard extends PlayState{

	private String cardType;
	private Floor floor;
	private Tower tower;
	private int value;
	
	public WaitCard(String cardType, int value) {
		this.cardType = cardType;
		this.value = value;
		stateHandler().invoke(new TextualEvent("Seleziona una carta su un piano di valore >= ad "+ value));
	}
	
	@Override
	public void handle(FloorSelectedEvent floorSelectedEvent) {
		Tower tower = stateHandler().getGame().getBoard().getTower(floorSelectedEvent.getTower());
		this.tower = tower;
		floor = tower.getFloor(floorSelectedEvent.getFloor());
		String card = floor.getCard().getClass().toString();

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
		fMember.setModifier(value);
		FamilyInSpaceAction sAction = stateHandler().actions().newFamilyInSpace(fMember, floor.getActionSpace());
		FamilyInTowerAction tAction = stateHandler().actions().newFamilyInTower(tower, fMember);
		
		GetCardAction getCard = stateHandler().actions().newGetCardAction(floor.getCard(), cost);
		FamilyInFloorAction action = stateHandler().actions().newFamilyInFloorAction(tAction, sAction, getCard);
		
		if(action.isLegal()){
			getCard.perform();
			stateHandler().resetState();
		}
	}
	
	@Override
	public void handle(ResourceSelectedEvent resourceSelectedEvent) {
		getCard(resourceSelectedEvent.getResourceList());
	}
}
