package it.polimi.ingsw.resources;

import it.polimi.ingsw.dices.YellowDice;

public class YellowFamilyMember extends FamilyMember {
	
	public YellowFamilyMember(){
		super();
	}

	@Override
	public int getValue() {
		return this.value;
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
