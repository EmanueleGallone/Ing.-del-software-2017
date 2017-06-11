package it.polimi.ingsw.ps11.cranio.actions.list.player;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.resources.list.Coin;
import it.polimi.ingsw.ps11.cranio.zones.Floor;
import it.polimi.ingsw.ps11.cranio.zones.ActionSpace.ActionSpace;
import it.polimi.ingsw.ps11.cranio.zones.towers.Tower;

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
		if(tower.contains(getSource())){
			DecrementResourceAction tax = new DecrementResourceAction(getSource(), new ResourceList(new Coin(3)));
			tax.perform();
		}
		observers.performEvent(this);
	}

	@Override
	public boolean isLegal() {
		boolean result = observers.validationEvent(this);

		if (tower.contains(getSource())){
			ResourceList resourceList = new ResourceList(new Coin(3));
			result = result && getSource().getResourceList().canSubtract(resourceList);
		}
		
		return result && floor.getActionSpace().getActionCost() >= supportFamilyMember.getValue();
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
