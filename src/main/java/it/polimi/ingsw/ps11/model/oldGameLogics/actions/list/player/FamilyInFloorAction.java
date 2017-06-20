package it.polimi.ingsw.ps11.model.oldGameLogics.actions.list.player;

import java.awt.Checkbox;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.NeutralFamilyMember;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;

public class FamilyInFloorAction extends PlayerAction<FamilyInFloorAction> {

	private Tower tower;
	private Floor floor;
	private FamilyMember familyMember;
	
	//Il familiare di supporto serve ad alcuni bonus per alterare il valore del familiare
	private FamilyMember supportFamilyMember;
	
	
	public FamilyInFloorAction(Player player){
		super(player);
	}
	
	public FamilyInFloorAction(Player player, FamilyMember familyMember, Tower tower , int floor) {
		super(player);
		this.tower = tower;
		this.floor = tower.getFloor(floor);
		supportFamilyMember = familyMember.clone();
	}
	
	public FamilyInFloorAction newIstance(FamilyMember familyMember, Tower tower , int floor){
		FamilyInFloorAction f = new FamilyInFloorAction(getSource(),familyMember,tower, floor);
		f.setObservers(observers);
		return f;
	}
	
// Logics ________________________
	
	@Override
	public void perform() {
		floor.placeFamilyMember(familyMember, getSource());
		if(!tower.isFree()){
			DecrementResourceAction tax = new DecrementResourceAction(getSource(), new ResourceList(new Coin(3)));
			tax.perform();
		}
		observers.performEvent(this);
	}

	@Override
	public boolean isLegal() {
		ActionSpace actionSpace = floor.getActionSpace();
		boolean result = observers.validationEvent(this);
		result = result && checkTower() && actionSpace.isFree();
		return result && actionSpace.getActionCost() >= supportFamilyMember.getValue();
	}
	
	public boolean checkTower(){
		if (familyMember.getClass() != NeutralFamilyMember.class && contains(getSource())){
			return false;
		}
		else if (!tower.isFree()) {
			DecrementResourceAction action = getSource().getActionHandler().get(DecrementResourceAction.class);
			action.newIstance(new ResourceList(new Coin(3)));
			return action.isLegal();
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
