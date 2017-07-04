package it.polimi.ingsw.ps11.model.gameLogics.newActions.family;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.newActions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.newActions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.newActions.resources.DecrementAction;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;

public class FamilyInTowerAction implements Action {
	protected ResourceList taxIfNotFree = new ResourceList(new Coin(3));
	
	private ActionManager aManager;
	private Tower tower;
	private FamilyMember familyMember;
	
	public FamilyInTowerAction(ActionManager aManager, Tower tower, FamilyMember familyMember) {
	
		this.aManager = aManager;
		this.tower = tower;
		if(familyMember!=null)
			this.familyMember = familyMember.clone();
	}


	@Override
	public void perform() {
		if(!tower.isFree()){
			DecrementAction tax = new DecrementAction(aManager, taxIfNotFree);
			tax = aManager.affect(tax);
			tax.perform();
		}
	}

	@Override
	public boolean isLegal() {
		if(contains(tower, aManager.state().getPlayer()) && !familyMember.isNeutral()){
			return false;
		}
		return checkTax();
	}
	
	public boolean checkTax(){
		if(!tower.isFree()){
			DecrementAction tax = aManager.affect(new DecrementAction(aManager, taxIfNotFree));
			return tax.isLegal();
		}
		return true;
	}
	
	public boolean contains(Tower tower, Player player){
		// Ritorna true se c'e' un familyMember di un giocatore che non sia il familiare neutro
		for(Floor floor : tower.getFloors()){
			ActionSpace aSpace = floor.getActionSpace();
			FamilyMember fMember = floor.getActionSpace().getFamilyMember();
			if (aSpace.getOwner() != null && aSpace.getOwner().equals(player) && !fMember.isNeutral()){
				return true;
			}
		}
		return false;
	}
	
	public Tower getTower() {
		return tower;
	}
	
	@Override
	public FamilyInTowerAction clone(){
		Tower t = tower;
		FamilyMember f = familyMember;
		if(t != null)
			t = tower.clone();
		if(f != null)
			f = f.clone();
		return new FamilyInTowerAction(aManager, t, f);
	}
}
