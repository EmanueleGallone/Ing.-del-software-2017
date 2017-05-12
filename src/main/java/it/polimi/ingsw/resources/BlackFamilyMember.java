package it.polimi.ingsw.resources;

import gioco.da.console.Player;

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
