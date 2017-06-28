package it.polimi.ingsw.ps11.model.gameLogics.actions;

import java.util.HashMap;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.DecrementAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.FamilyInFloorAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.FamilyInSpaceAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.FamilyInTowerAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.GetCardAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.IncrementAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.UseServantAction;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Servant;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;

public class ActionManager {
	
	Player player;
	private HashMap<String, Action<?>> actions = new HashMap<>();
	
	
	
	public ActionManager(Player player) {
		this.player = player;
	}
	
	public <T extends Action<?>> T get(Class<T> action){
		Action<?> actionDecorator = actions.get(action.toString());
		if(actionDecorator != null){
			actionDecorator = actionDecorator.clone();
		}
		return (T) actionDecorator;
	}

	public void add (Action<?> action){
		actions.put(action.target().toString(), action);
	}
	
	public Player getSubject(){
		return player;
	}
	
	public <T extends Action<T>> T make (Class<T> azione, T action){
	 	 T decorator = this.get(azione);
	 	 return decore(action, decorator);
	}
	
	public <T extends Action<T>> T decore (T action , T decorator){
		if(decorator != null)
			return (T) decorator.decore(action);
		return action;
	}
	
	
	public void askToClient(){
		
	}
	
// Actions constructors __________________
	
	
	public IncrementAction newIncrementAction(ResourceList resource){
		IncrementAction action = new IncrementAction(this,resource);
		return make(IncrementAction.class, action);
	}
	
	
	public DecrementAction newDecrementAction(ResourceList resource){
		DecrementAction action = new DecrementAction(this,resource);
		return make(DecrementAction.class, action);
	}
	
	
	
	public GetCardAction newGetCardAction( DevelopmentCard card, ResourceList cost){
		GetCardAction action = new GetCardAction(this, card, cost);
		return make(GetCardAction.class, action);
	}

	
// _____________________________ Action to position familyMember _________________________________________

	public FamilyInFloorAction newFamilyInFloorAction(FamilyInTowerAction tAction, FamilyInSpaceAction sAction ,GetCardAction getCard){
		FamilyInFloorAction action = new FamilyInFloorAction(this, tAction, sAction, getCard);
		return make(FamilyInFloorAction.class, action);
	}
	
	public FamilyInFloorAction newFamilyInFloorAction(Tower tower, Floor floor, FamilyMember fMember, ResourceList cost, Servant servant){
		FamilyInTowerAction tAction = this.newFamilyInTowerAction(tower, fMember);
		FamilyInSpaceAction sAction = this.newFamilyInSpaceAction(fMember, floor.getActionSpace());
		GetCardAction getCard = this.newGetCardAction(floor.getCard(), cost);

		return newFamilyInFloorAction(tAction, sAction, getCard);
	}
	
	
	public FamilyInFloorAction newFamilyInFloorAction(Tower tower, Floor floor, FamilyMember fMember, ResourceList cost){
		return newFamilyInFloorAction(tower, floor, fMember, cost,new Servant(0));
	}
	

	
	public FamilyInSpaceAction newFamilyInSpaceAction(FamilyMember fMember, ActionSpace space){
		FamilyInSpaceAction action = new FamilyInSpaceAction(this, fMember, space);
		return make(FamilyInSpaceAction.class, action);
	}
	
	
	
	public FamilyInTowerAction newFamilyInTowerAction(Tower tower, FamilyMember familyMember){
		FamilyInTowerAction action = new FamilyInTowerAction(this, tower, familyMember);
		return make(FamilyInTowerAction.class, action);
	}
	
	
// ___________________________________________________________________________________________
	
	
	public UseServantAction newUseServantAction(Servant servant, FamilyMember fMember){
		UseServantAction action = new UseServantAction(this,servant, fMember);
		return make(UseServantAction.class, action);
	}

	
	

}
