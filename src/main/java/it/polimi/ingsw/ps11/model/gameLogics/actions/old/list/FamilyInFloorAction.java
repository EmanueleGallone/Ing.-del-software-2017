package it.polimi.ingsw.ps11.model.gameLogics.actions.old.list;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.NeutralFamilyMember;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;

public class FamilyInFloorAction extends PlayerAction {

	private Tower tower;
	private Floor floor;
	private FamilyMember familyMember;
	private ResourceList costIfNotFree = new ResourceList(new Coin(3));
	
	//Il familiare di supporto serve ad alcuni bonus per alterare il valore del familiare
	private FamilyMember supportFamilyMember;
	
	
//	public FamilyInFloorAction(FamilyMember familyMember, Tower tower , int floor){
//		this.tower = tower;
//		this.floor = tower.getFloor(floor);
//		supportFamilyMember = familyMember.clone();
//	}
	
	public FamilyInFloorAction(Player player, FamilyMember familyMember, Tower tower , int floor) {
		super(player);
		this.tower = tower;
		this.floor = tower.getFloor(floor);
		supportFamilyMember = familyMember.clone();
	}
	
// Logics ________________________
	
	@Override
	public void perform() {
		floor.placeFamilyMember(familyMember, getPlayer());
		if(!tower.isFree()){
			DecrementResourceAction tax = new DecrementResourceAction(getPlayer(), costIfNotFree);
			actionManager().perform(tax);
		}
	}

	@Override
	public boolean isLegal() {
		ActionSpace actionSpace = floor.getActionSpace();
		boolean result = checkTower() && actionSpace.isFree();
		return result && actionSpace.getActionCost() >= supportFamilyMember.getValue();
	}
	

// _____________________________________________________
	
	public boolean checkTower(){
		if (familyMember.getClass() != NeutralFamilyMember.class && contains(getPlayer())){
			return false;
		}
		else if (!tower.isFree()) {
			DecrementResourceAction action = new DecrementResourceAction(getPlayer(),costIfNotFree);
			return actionManager().isLegal(action);
		}
		return true;
	}
	
	
	private boolean contains(Player player){
		// Ritorna true se sulla torre c'e' un familyMember del giocatore passato che non sia il familiare neutro
		for(Floor floor : tower.getFloors()){
			ActionSpace aSpace = floor.getActionSpace();
			if (aSpace.getOwner().equals(player) && aSpace.getFamilyMember().getClass() != NeutralFamilyMember.class){
				return true;
			}
		}
		return false;
	}
	
// Getters  _____________________________________
	
	public FamilyMember getFamilyMember() {
		// Deve restituire il familiare di supporto non l'originale
		return supportFamilyMember;
	}
	public Tower getTower() {
		return tower;
	}
}
