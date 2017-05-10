package it.polimi.ingsw.ps11.cranio.familyMember;

import it.polimi.ingsw.ps11.cranio.player.Player;

public class WhiteFamilyMember extends FamilyMember {

	
	public WhiteFamilyMember(Player player){
		super(player);
		id = 2;
	}

	@Override
	public String toString() {
		return "WhiteFamilyMember [value=" + value + " isUsed="+ isUsed + "]";
	}

}