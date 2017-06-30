package it.polimi.ingsw.ps11.model.gameLogics.states;

import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.FamilyInFloorAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.FamilyInSpaceAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.FamilyInTowerAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.GetCardAction;
import it.polimi.ingsw.ps11.model.modelEvents.ModelEvent;
import it.polimi.ingsw.ps11.model.modelEvents.UpdateFamilyMemberEvent;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.view.viewEvents.FamilySelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.ResourceSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.FloorSelectedEvent;

public class FloorSelected extends PlayState {

	private FloorSelectedEvent floorSelectedEvent;
	private FamilySelectedEvent familySelectedEvent;
	
	public FloorSelected(FloorSelectedEvent event) {
		this.floorSelectedEvent = event;
		Player player = stateHandler().actions().getSubject();
		stateHandler().invoke(new UpdateFamilyMemberEvent(player.getFamilyManager()));
	}
	
	public void createAction(ResourceList cost){
		Tower tower = stateHandler().getGame().getBoard().getTower(floorSelectedEvent.getTower());
		Floor floor = tower.getFloor(floorSelectedEvent.getFloor());
		FamilyMember fMember = stateHandler().getPlayer().getFamilyManager().getFamilyMember(familySelectedEvent.getFamilyMember()); 
		
		ActionManager aManager = stateHandler().actions();
		
		FamilyInTowerAction tAction = aManager.newFamilyInTower(tower, fMember);
		FamilyInSpaceAction sAction = aManager.newFamilyInSpace(fMember, floor.getActionSpace());
		GetCardAction getCard = aManager.newGetCardAction(floor.getCard(), cost);
		getCard.attach(listener);
		
		FamilyInFloorAction action = aManager.newFamilyInFloorAction(tAction, sAction, getCard);
		
		if(action.isLegal()){
			action.perform();
			stateHandler().resetState();
		}
	}
	
	EventListener<ModelEvent> listener = new EventListener<ModelEvent>() {

		@Override
		public void handle(ModelEvent e) {
			stateHandler().invoke(e);
		}
	};
	
	@Override
	public void handle(FamilySelectedEvent familySelectedEvent) {
		this.familySelectedEvent = familySelectedEvent;
		createAction(null);
	}
	
	
	@Override
	public void handle(ResourceSelectedEvent resourceSelectedEvent) {
		createAction(resourceSelectedEvent.getResourceList());
	}
	
}
