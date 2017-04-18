package it.polimi.ingsw.dices;

import java.util.Random;

public class WhiteDice extends Dice {
private Random gen = new Random();
	
	public WhiteDice(){
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
		return "WhiteDice [value=" + value + "]";
	}

}
