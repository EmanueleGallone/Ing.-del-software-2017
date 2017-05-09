package pos.dices;

import java.util.Random;

import pos.familyMembers.Colors;

public class Dice {
	
	protected static final int MAX_FACES = 6;
	protected int value;
	private Random gen = new Random();
	Colors color;
	
	public Dice(Colors color){
		this.value = 0;
		this.color = color;
	}
	
	
	public void rollDice(){
		this.value = gen.nextInt(MAX_FACES) +1;
	}
	
	public int getValue(){
		return this.value;
	}
	public Colors getColors() {
		return color;
	}
}
