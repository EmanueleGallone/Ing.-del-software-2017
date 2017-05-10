package it.polimi.ingsw.ps11.cranio.familyMember;

import it.polimi.ingsw.ps11.cranio.player.Player;

public class BlackFamilyMember extends FamilyMember {
	
	
	public BlackFamilyMember(Player player){
		super(player);
		id = 1;
	}
	
	@Override
	public String toString() {
		return "BlackFamilyMember [value=" + value + " isUsed="+ isUsed + "]";
	}
	
	

}
