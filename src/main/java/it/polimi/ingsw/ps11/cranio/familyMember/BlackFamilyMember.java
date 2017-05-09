package it.polimi.ingsw.ps11.cranio.familyMember;

import it.polimi.ingsw.ps11.cranio.player.Player;

public class BlackFamilyMember extends FamilyMember {
	
	public BlackFamilyMember(){
		super();
	}
	
	public BlackFamilyMember(Player player){
		super(player);
	}
	
	@Override
	public String toString() {
		return "BlackFamilyMember [value=" + value + " isUsed="+ isUsed + "]";
	}
	
	

}
