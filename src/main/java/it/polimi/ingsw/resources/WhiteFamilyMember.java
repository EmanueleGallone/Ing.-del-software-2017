package it.polimi.ingsw.resources;

import gioco.da.console.Player;

public class WhiteFamilyMember extends FamilyMember {
	
	public WhiteFamilyMember(){
		super();
	}
	
	public WhiteFamilyMember(Player player){
		super(player);
	}

	@Override
	public String toString() {
		return "WhiteFamilyMember [value=" + value + " isUsed="+ isUsed + "]";
	}

}
