package it.polimi.ingsw.ps11.cranio.dices;

import java.util.Random;

public abstract class Dice {
	protected static final int MAX_FACES = 6;
	protected int value;
	private Random gen = new Random();
	
	public Dice(){
		this.value = 0;
	}	
	
	public void rollDice(){
		this.value = gen.nextInt(MAX_FACES) +1;
	}
	
	public int getValue(){
		return this.value;
	}
	
	
	@Override
	public abstract Dice clone();
	
	@Override
	public abstract String toString();

}
