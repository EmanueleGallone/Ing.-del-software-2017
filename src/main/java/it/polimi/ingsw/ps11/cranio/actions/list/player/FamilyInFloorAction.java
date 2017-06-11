package it.polimi.ingsw.ps11.cranio.actions.list.player;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.zones.ActionSpace.ActionSpace;

public class FamilyInFloorAction extends PlayerAction<FamilyInFloorAction> {

	private ActionSpace actionSpace;
	private FamilyMember familyMember;
	
	private ActionSpace supportActionSpace;
	private FamilyMember supportFamilyMember;
	
	
	public FamilyInFloorAction(Player player){
		super(player);
	}
	
	public FamilyInFloorAction(Player player, FamilyMember familyMember, ActionSpace actionSpace) {
		super(player);
		this.actionSpace = actionSpace;
		supportActionSpace = actionSpace.clone();
		supportFamilyMember = familyMember.clone();
	}
	
	public FamilyInFloorAction newIstance(Player player, FamilyMember familyMember, ActionSpace actionSpace){
		FamilyInFloorAction f = new FamilyInFloorAction(player,familyMember,actionSpace);
		f.setObservers(observers);
		return f;
	}
	
	@Override
	public void perform() {
		actionSpace.placeFamilyMember(familyMember, getSource());
		observers.performEvent(this);
	}

	@Override
	public boolean isLegal() {
		boolean result = observers.validationEvent(this) ;
		return result && supportActionSpace.getActionCost() >= supportFamilyMember.getValue();
	}
	
	public ActionSpace getActionSpace() {
		return supportActionSpace;
	}
	public FamilyMember getFamilyMember() {
		return supportFamilyMember;
	}
}
