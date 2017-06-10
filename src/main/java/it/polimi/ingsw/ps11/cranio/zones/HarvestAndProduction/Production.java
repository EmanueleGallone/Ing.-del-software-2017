package it.polimi.ingsw.ps11.cranio.zones.HarvestAndProduction;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.zones.ActionSpace.ActionSpace;
import it.polimi.ingsw.ps11.cranio.zones.ActionSpace.FamilyMemberSpace;
import it.polimi.ingsw.ps11.cranio.zones.ActionSpace.MultipleActionSpace;

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
}
