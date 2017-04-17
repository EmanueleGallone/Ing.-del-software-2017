package it.polimi.ingsw.dices;

import java.util.Random;

public class WhiteDice extends Dice {
private Random gen = new Random();
	
	public WhiteDice(){
		this.value = 0;		
	}
	
	//rolls a Dice and return its value
	public int rollDice(){
		this.value = gen.nextInt(MAX_FACES) +1;
		return this.value;
	}

	@Override
	public String toString() {
		return "WhiteDice [value=" + value + "]";
	}

}
