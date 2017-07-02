package it.polimi.ingsw.ps11.model.dices;

import java.io.Serializable;

public class DiceProxy implements Serializable{

	private Dice dice;
	public DiceProxy(Dice dice) {
		if(dice == null)
			dice = new Dice();
		this.dice = dice;
	}
	
	public int getValue(){
		return dice.getValue();
	}
}
