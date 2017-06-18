package it.polimi.ingsw.ps11.model.zones.harvestAndProduction;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.actionSpace.FamilyMemberSpace;
import it.polimi.ingsw.ps11.model.zones.actionSpace.MultipleActionSpace;

public class Production implements FamilyMemberSpace {

	private ActionSpace singleActionSpace = new ActionSpace();
	private MultipleActionSpace multipleActionSpace = new MultipleActionSpace();
	
	public Production() {
	
	}
	
	@Override
	public boolean placeFamilyMember(FamilyMember familyMember, Player player) {
		if(singleActionSpace.isFree())
			return singleActionSpace.placeFamilyMember(familyMember, player);
		else {
			if(player.equals(singleActionSpace.getOwner()) || multipleActionSpace.contains(player))
				return false;
			return multipleActionSpace.placeFamilyMember(familyMember, player);
		}
	}
	
	public ActionSpace getSingleActionSpace() {
		return singleActionSpace;
	}
	public MultipleActionSpace getMultipleActionSpace() {
		return multipleActionSpace;
	}
}
