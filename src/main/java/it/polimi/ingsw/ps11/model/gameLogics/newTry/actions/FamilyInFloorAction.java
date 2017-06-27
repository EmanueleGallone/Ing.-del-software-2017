package it.polimi.ingsw.ps11.model.gameLogics.newTry.actions;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.newTry.Action;
import it.polimi.ingsw.ps11.model.gameLogics.newTry.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.newTry.Affecter;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;

public class FamilyInFloorAction implements Action, Affecter<FamilyInFloorAction>{

	protected ResourceList taxIfNotFree = new ResourceList(new Coin(3));
	
	protected ActionManager aManager;
	protected Tower tower;
	protected int floor;
	protected GetCardAction getCard;
	
	protected FamilyMember familyMember;
	
	public FamilyInFloorAction() {
	
	}
	
	public FamilyInFloorAction(ActionManager actionManager, Tower tower, int floor, GetCardAction getCard ) {
		this.aManager = actionManager;
		this.tower = tower;
		this.floor = floor;
	}
	
	@Override
	public void perform() {
		if(!tower.isFree()){
			DecrementAction tax = aManager.newDecrementAction(taxIfNotFree);
			tax.perform();
		}
		Floor floor = tower.getFloor(this.floor);
	}
	
	@Override
	public boolean isLegal() {
		ActionSpace space;
		try {
			space = tower.getFloor(this.floor).getActionSpace();
		} catch (IllegalArgumentException e) {
			return false;
		}
		if(contains(tower, aManager.getSubject()) && !familyMember.isNeutral()){
			return false;
		}
		else if(space.isFree() && space.getActionCost() <= familyMember.getValue()){
			return checkTax();
		}
		return false;
	}
	
	public boolean checkTax(){
		if(!tower.isFree()){
			DecrementAction tax = aManager.newDecrementAction(taxIfNotFree);
			return tax.isLegal();
		}
		return true;
	}
	
	public boolean contains(Tower tower, Player player){
		// Ritorna true se c'e' un familyMember di un giocatore che non sia il familiare neutro
		for(Floor floor : tower.getFloors()){
			ActionSpace aSpace = floor.getActionSpace();
			if (aSpace.getOwner().equals(player) && !aSpace.getFamilyMember().isNeutral()){
				return true;
			}
		}
		return false;
	}

// Method for decorator pattern ___________________
	
	@Override
	public void attach(ActionManager aManager) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<? extends Action> target() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FamilyInFloorAction decore(FamilyInFloorAction action) {
		// TODO Auto-generated method stub
		return null;
	}
// _________________________________________________
	
	@Override
	public FamilyInFloorAction clone() {
		// TODO Auto-generated method stub
		return null;
	}
}
