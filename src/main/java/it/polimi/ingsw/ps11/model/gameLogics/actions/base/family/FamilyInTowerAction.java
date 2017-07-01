package it.polimi.ingsw.ps11.model.gameLogics.actions.base.family;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.DecrementAction;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;

public class FamilyInTowerAction implements Action<FamilyInTowerAction> {

	protected ResourceList taxIfNotFree = new ResourceList(new Coin(3));
	
	protected ActionManager aManager;
	protected Tower tower;
	protected FamilyMember familyMember;
	
	public FamilyInTowerAction(ActionManager aManager, Tower tower, FamilyMember familyMember) {
	
		this.aManager = aManager;
		this.tower = tower;
		this.familyMember = familyMember.clone();
	}


	@Override
	public void perform() {
		if(!tower.isFree()){
			DecrementAction tax = aManager.newDecrementAction(taxIfNotFree);
			tax.perform();
		}
	}

	@Override
	public boolean isLegal() {
		if(contains(tower, aManager.getSubject()) && !familyMember.isNeutral()){
			return false;
		}
		return checkTax();
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
			if (aSpace.getOwner() != null && aSpace.getOwner().equals(player) && !aSpace.getFamilyMember().isNeutral()){
				return true;
			}
		}
		return false;
	}
	
	public Tower getTower() {
		return tower;
	}
	
	// _________________________ Method for action system ________________________

	@Override
	public void attach(ActionManager aManager) {
		FamilyInTowerAction increment = aManager.get(target());
		if(increment == null){
			increment = this;
		}
		aManager.add(increment.decore(this));
	}

	@Override
	public Class<FamilyInTowerAction> target() {
		return FamilyInTowerAction.class;
	}
	
	@Override
	public FamilyInTowerAction decore(FamilyInTowerAction action) {
		if(action != this){
			return action.decore(this);
		}
		return this;
	}

	@Override
	public FamilyInTowerAction clone() {
		// TODO Auto-generated method stub
		return null;
	}

}
