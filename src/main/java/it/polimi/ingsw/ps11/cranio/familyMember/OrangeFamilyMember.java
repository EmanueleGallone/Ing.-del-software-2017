package it.polimi.ingsw.ps11.cranio.familyMember;

import it.polimi.ingsw.ps11.cranio.player.Player;

public class OrangeFamilyMember extends FamilyMember {
	
	public OrangeFamilyMember(){
		super();
	}
	
	public OrangeFamilyMember(Player player){
		super(player);
	}

	@Override
	public String toString() {
		return "YellowFamilyMember [value=" + value + " isUsed="+ isUsed + "]";
	}

}
