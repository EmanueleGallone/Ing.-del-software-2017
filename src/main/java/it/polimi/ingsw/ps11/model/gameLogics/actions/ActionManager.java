package it.polimi.ingsw.ps11.model.gameLogics.actions;

import java.util.HashMap;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
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
	private HashMap<String, Action> actions = new HashMap<>();
	
	
	public ActionManager(Player player) {
		this.player = player;
	}
	
	public <T extends Action> T get(Class<T> action){
		Action actionDecorator = actions.get(action.toString());
		if(actionDecorator != null){
			actionDecorator = actionDecorator.clone();
		}
		return (T) actionDecorator;
	}

	public void add (Action action){
		actions.put(action.target().toString(), action);
	}
	
	public Player getSubject(){
		return player;
	}
	
	public IncrementAction newIncrementAction(ResourceList resource){
		IncrementAction decorator = get(IncrementAction.class);
		IncrementAction action = new IncrementAction(this,resource);
		if (decorator!=null){
			 decorator.decore(action);
			 return decorator;
		}
		return action;
	}
	
	public DecrementAction newDecrementAction(ResourceList resource){
		DecrementAction a = get(DecrementAction.class);
		DecrementAction action = new DecrementAction(this,resource);
		if (a!=null)
			return a.decore(action);
		return action;
	}
	
	public FamilyInFloorAction newFamilyInFloorAction(Tower tower, Floor floor, FamilyMember fMember, ResourceList cost, Servant servant){
		FamilyInSpaceAction sAction = this.newFamilyInSpaceAction(fMember, floor.getActionSpace());
		FamilyInTowerAction tAction = this.newFamilyInTowerAction(tower, fMember);
		GetCardAction getCard = this.newGetCardAction(floor.getCard(), cost);
		
		FamilyInFloorAction action = new FamilyInFloorAction(this, tAction, sAction, getCard);
		FamilyInFloorAction decorator = this.get(FamilyInFloorAction.class);
		if (decorator != null )
			return decorator.decore(action);
		return action;
	}
	public FamilyInFloorAction newFamilyInFloorAction(Tower tower, Floor floor, FamilyMember fMember, ResourceList cost){
		return newFamilyInFloorAction(tower, floor, fMember, cost,new Servant(0));
	}
	
	
	public UseServantAction newUseServantAction(Servant servant, FamilyMember fMember){
		UseServantAction action = new UseServantAction(this,servant, fMember);
		UseServantAction a = get(UseServantAction.class);
		if (a!=null)
			return a.decore(action);
		return action;
	}
	
	public <T extends Action> T decore (T a1 , T a2){
		if(a1 != null)
			return a1.decore(a2);
	}

	public FamilyInSpaceAction newFamilyInSpaceAction(FamilyMember fMember, ActionSpace space){
		FamilyInSpaceAction a = get(FamilyInSpaceAction.class);
		FamilyInSpaceAction action = new FamilyInSpaceAction(this, fMember, space);
		if (a!=null)
			return a.decore(action);
		return action;
	}
	
	public GetCardAction newGetCardAction( DevelopmentCard card, ResourceList cost){
		GetCardAction a = get(GetCardAction.class);
		GetCardAction action = new GetCardAction(this, card, cost);
		if (a!=null)
			return a.decore(action);
		return action;
	}
	
	public FamilyInTowerAction newFamilyInTowerAction(Tower tower, FamilyMember familyMember){
		FamilyInTowerAction a = get(FamilyInTowerAction.class);
		FamilyInTowerAction action = new FamilyInTowerAction(this, tower, familyMember);
		if (a!=null)
			return a.decore(action);
		return action;
	}
}
