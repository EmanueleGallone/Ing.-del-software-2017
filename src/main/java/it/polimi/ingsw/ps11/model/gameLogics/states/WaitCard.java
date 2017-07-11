package it.polimi.ingsw.ps11.model.gameLogics.states;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.familyMember.list.NeutralFamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.GetCardAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInFloorAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInSpaceAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInTowerAction;
import it.polimi.ingsw.ps11.model.modelEvents.TextualEvent;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.view.viewEvents.ResourceSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.FloorSelectedEvent;
/**
 * <h3> WaitCard </h3>
 * <p> Classe che rappresenta lo stato di attesa della scelta del giocatore su quale carta prendere.</p>
 * @see 
 */
public class WaitCard extends PlayState{

	private String cardType;
	private Floor floor;
	private Tower tower;
	private int value;
	
	private FamilyInFloorAction action;
	
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
			stateHandler().invoke(new TextualEvent("Cannot select this card."));
		}
	}

	
	public void getCard(ResourceList cost){
		NeutralFamilyMember fMember = new NeutralFamilyMember();
		ActionManager aManager = stateHandler().actions();
		
		FamilyInSpaceAction sAction = new FamilyInSpaceAction(aManager,null, floor.getActionSpace());
		sAction.addModifier(value);
		sAction.setAlreadyDone(false);
		FamilyInTowerAction tAction = new FamilyInTowerAction(aManager, tower, fMember);
		GetCardAction getCard = new GetCardAction(aManager, floor, cost);
		
		sAction = aManager.affect(sAction);
		tAction = aManager.affect(tAction);
		getCard = aManager.affect(getCard);
		
		getCard.attach(listener);
		
		action = aManager.affect(new FamilyInFloorAction(aManager, tAction, sAction, getCard));
		
		if(action.isLegal()){
			action.perform();
			stateHandler().nextState(new PlayState());
		}
	}
	
	@Override
	public void handle(ResourceSelectedEvent resourceSelectedEvent) {
		getCard(resourceSelectedEvent.getResourceList());
	}
	
	
	EventListener<ArrayList<ResourceList>> listener = new EventListener<ArrayList<ResourceList>>() {

		@Override
		public void handle(ArrayList<ResourceList> e) {
			stateHandler().nextState(new WaitResource(e,action));
		}
	};
	
	@Override
	public void notifyToClient() {
		stateHandler().invoke(new TextualEvent("Select the action space from a floor with a value minor or equal "+ value +" to take the associated card"));
	}
}
