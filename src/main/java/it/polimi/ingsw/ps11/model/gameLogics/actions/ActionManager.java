package it.polimi.ingsw.ps11.model.gameLogics.actions;

import java.util.HashMap;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.State;
import it.polimi.ingsw.ps11.model.gameLogics.StateHandler;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.ActiveYieldAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.DecrementAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.EndGameAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.EndTurnAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.FamilyInFloorAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.FamilyInSpaceAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.FamilyInTowerAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.GetCardAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.IncrementAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.UseServantAction;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Servant;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;

public class ActionManager {
	
	Player player;
	StateHandler stateHandler;
	private HashMap<String, Action<?>> actions = new HashMap<>();
	
	public StateHandler getStateHandler() {
		return stateHandler;
	}
	
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

	
	public void changeState(State state){
		stateHandler.nextState(state);
	}
	
// Actions constructors __________________
	
	
	public EndTurnAction newEndTurn(){
		EndTurnAction action = new EndTurnAction(this);
		return make(EndTurnAction.class, action);
	}
	
	public IncrementAction newIncrementAction(ResourceList resource){
		IncrementAction action = new IncrementAction(this,resource);
		return make(IncrementAction.class, action);
	}
	
	
	public DecrementAction newDecrementAction(ResourceList resource){
		DecrementAction action = new DecrementAction(this,resource);
		return make(DecrementAction.class, action);
	}
	
	
	
	public GetCardAction newGetCardAction(DevelopmentCard card, ResourceList cost){
		GetCardAction action = new GetCardAction(this, card,cost);
		return make(GetCardAction.class, action);
	}

	
// _____________________________________ position familyMember _________________________________________

	public FamilyInFloorAction newFamilyInFloorAction(FamilyInTowerAction tAction, FamilyInSpaceAction sAction ,GetCardAction getCard){
		FamilyInFloorAction action = new FamilyInFloorAction(this, tAction, sAction, getCard);
		return make(FamilyInFloorAction.class, action);
	}
	
	public FamilyInSpaceAction newFamilyInSpace(FamilyMember fMember, ActionSpace space){
		FamilyInSpaceAction action = new FamilyInSpaceAction(this, fMember, space);
		return make(FamilyInSpaceAction.class, action);
	}
	
	public FamilyInTowerAction newFamilyInTower(Tower tower, FamilyMember familyMember){
		FamilyInTowerAction action = new FamilyInTowerAction(this, tower, familyMember);
		return make(FamilyInTowerAction.class, action);
	}
	
	
// ___________________________________________________________________________________________
	
	
	public UseServantAction newUseServant(Servant servant, FamilyMember fMember){
		UseServantAction action = new UseServantAction(this,servant, fMember);
		return make(UseServantAction.class, action);
	}
	
	public ActiveYieldAction newActiveYield(String cardType, int value){
		ActiveYieldAction action = new ActiveYieldAction(this,cardType, value);
		return make(ActiveYieldAction.class, action);
	}
	
	public EndGameAction newEndGame(){
		return make(EndGameAction.class, new EndGameAction());
	}
	
}
