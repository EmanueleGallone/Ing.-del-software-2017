package it.polimi.ingsw.dices;

import java.util.Random;

public class BlackDice extends Dice {
	private Random gen = new Random();
	
	public BlackDice(){
		super();		
	}

	@Override
	public String toString() {
		return "BlackDice [value=" + value + "]";
	}

}
