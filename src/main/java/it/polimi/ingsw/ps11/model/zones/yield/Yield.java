package it.polimi.ingsw.ps11.model.zones.yield;

import java.io.Serializable;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.actionSpace.FamilyMemberSpace;
import it.polimi.ingsw.ps11.model.zones.actionSpace.MultipleActionSpace;

public class Yield implements FamilyMemberSpace, Serializable {

	private ActionSpace singleActionSpace = new ActionSpace();
	private MultipleActionSpace multipleActionSpace = new MultipleActionSpace();
	
	public Yield() {
	
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
	
	@Override
	public Yield clone(){
		Yield clone = new Yield();
		
		if (this.singleActionSpace != null)
			clone.singleActionSpace = this.singleActionSpace.clone();
		
		if(this.multipleActionSpace != null)
			clone.multipleActionSpace = this.multipleActionSpace.clone();
		
		return clone;
	}
}
