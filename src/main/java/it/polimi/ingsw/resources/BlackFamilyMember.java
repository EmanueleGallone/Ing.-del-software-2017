package it.polimi.ingsw.resources;

import it.polimi.ingsw.dices.BlackDice;
import it.polimi.ingsw.dices.Dice;

public class BlackFamilyMember extends FamilyMember {
	
	public BlackFamilyMember(){
		super();
	}
	
	public void setValue(BlackDice dice){
		this.value = dice.getValue();
	}

	@Override
	public void setValue(int value) {
		this.value = value;
		
	}

	@Override
	public String toString() {
		return "BlackFamilyMember [value=" + value + "]";
	}
	
	

}
