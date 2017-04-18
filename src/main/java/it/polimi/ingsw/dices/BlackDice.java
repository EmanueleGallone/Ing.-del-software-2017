package it.polimi.ingsw.dices;

import java.util.Random;

public class BlackDice extends Dice {
	private Random gen = new Random();
	
	public BlackDice(){
		this.value = 0;		
	}
	
	@Override
	public void rollDice(){
		this.value = gen.nextInt(MAX_FACES) +1;
	}
	
	@Override
	public int getValue(){
		return this.value;
	}

	@Override
	public String toString() {
		return "BlackDice [value=" + value + "]";
	}

}
