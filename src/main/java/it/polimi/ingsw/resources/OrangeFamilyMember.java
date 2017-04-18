package it.polimi.ingsw.resources;

import it.polimi.ingsw.dices.YellowDice;

public class OrangeFamilyMember extends FamilyMember {
	
	public OrangeFamilyMember(){
		super();
	}
	
	public void setValue(YellowDice dice) {
		this.value = dice.getValue();		
	}

	@Override
	public String toString() {
		return "YellowFamilyMember [value=" + value + "]";
	}

	@Override
	public void setValue(int value) {
		this.value = value;
		
	}

}
