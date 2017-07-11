package it.polimi.ingsw.ps11.model.gameLogics.states;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.GetCardAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInFloorAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInSpaceAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInTowerAction;
import it.polimi.ingsw.ps11.model.modelEvents.UpdateFamilyMemberEvent;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.view.viewEvents.FamilySelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.ResourceSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.FloorSelectedEvent;
/**
 * <h3> State </h3>
 * <p> Classe che rappresenta lo stato che segue l'azione di selezione di un piano da parte di un giocatore. Richiede che siano stati attivati
 * gli stati di selezione di un piano, un familiare e che venga eseguita un FamilyInFloorAction.</p>
 */
public class FloorSelected extends PlayState {

	private FloorSelectedEvent floorSelectedEvent;
	private FamilySelectedEvent familySelectedEvent;
	
	private FamilyInFloorAction action;
	
	public FloorSelected(FloorSelectedEvent event) {
		this.floorSelectedEvent = event;
	}
	
	public void createAction(ResourceList cost){
		Tower tower = stateHandler().getGame().getBoard().getTower(floorSelectedEvent.getTower());
		Floor floor = tower.getFloor(floorSelectedEvent.getFloor());
		FamilyMember fMember = stateHandler().getPlayer().getFamilyManager().getFamilyMember(familySelectedEvent.getFamilyMember()); 
		
		ActionManager aManager = stateHandler().actions();
		
		FamilyInTowerAction tAction = new FamilyInTowerAction(aManager,tower, fMember);
		FamilyInSpaceAction sAction = new FamilyInSpaceAction(aManager,fMember, floor.getActionSpace());
		GetCardAction getCard = new GetCardAction(aManager,floor, cost);
		
		tAction = aManager.affect(tAction);
		sAction = aManager.affect(sAction);
		getCard = aManager.affect(getCard);
		
		execute(tAction,sAction,getCard);
	}
	
	
	public void execute(FamilyInTowerAction tAction, FamilyInSpaceAction sAction, GetCardAction getCardAction){
		ActionManager aManager = stateHandler().actions();
		getCardAction.attach(listener);
		
		action = aManager.affect(new FamilyInFloorAction(aManager, tAction, sAction, getCardAction));
		
		if(action.isLegal()){
			action.perform();
			stateHandler().nextState(new PlayState());
		}
	}
	
	EventListener<ArrayList<ResourceList>> listener = new EventListener<ArrayList<ResourceList>>() {

		@Override
		public void handle(ArrayList<ResourceList> e) {
			stateHandler().nextState(new WaitResource(e,action));
		}
	};
	
	public void setAction(FamilyInFloorAction action) {
		this.action = action;
	}
	
	@Override
	public void handle(FamilySelectedEvent familySelectedEvent) {
		this.familySelectedEvent = familySelectedEvent;
		createAction(null);
	}
	
	
	@Override
	public void handle(ResourceSelectedEvent resourceSelectedEvent) {
		createAction(resourceSelectedEvent.getResourceList());
	}
	
	@Override
	public void notifyToClient() {
		Player player = stateHandler().actions().state().getPlayer();
		stateHandler().invoke(new UpdateFamilyMemberEvent(player.getFamilyManager()));
	}
	
}
