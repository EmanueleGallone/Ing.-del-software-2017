package it.polimi.ingsw.ps11.cranio.familyMember;

import it.polimi.ingsw.ps11.cranio.player.Player;

public class NeutralFamilyMember extends FamilyMember {
	
	public NeutralFamilyMember(){
		super();
	}
	
	public NeutralFamilyMember(Player player){
		super(player);
	}

	@Override
	//the neutral family member always has 0 value
	public void setValue(int value) {
		this.value = value;
	}
	
	public void resetValue(){
		this.value = 0;
	}

	@Override
	public String toString() {
		return "NeutralFamilyMember [value=" + value + " isUsed="+ isUsed + "]";
	}

}
