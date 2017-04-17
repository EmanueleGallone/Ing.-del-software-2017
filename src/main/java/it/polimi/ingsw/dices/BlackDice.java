package it.polimi.ingsw.dices;

import java.util.Random;

public class BlackDice extends Dice {
	private Random gen = new Random();
	
	public BlackDice(){
		this.value = 0;		
	}
	
	//rolls a Dice and return its value
	public int rollDice(){
		this.value = gen.nextInt(MAX_FACES) +1;
		return this.value;
	}

	@Override
	public String toString() {
		return "BlackDice [value=" + value + "]";
	}

}
