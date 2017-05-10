package it.polimi.ingsw.ps11.cranio.familyMember;

import it.polimi.ingsw.ps11.cranio.player.Player;

public class OrangeFamilyMember extends FamilyMember {
	
	public OrangeFamilyMember(Player player){
		super(player);
		id = 3;
	}

	@Override
	public String toString() {
		return "YellowFamilyMember [value=" + value + " isUsed="+ isUsed + "]";
	}

}
