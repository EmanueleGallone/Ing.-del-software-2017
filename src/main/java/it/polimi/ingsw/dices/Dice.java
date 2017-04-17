package it.polimi.ingsw.dices;

public abstract class Dice {
	protected static final int MAX_FACES = 6;
	protected int value;
	
	
	
	//rolls a Dice and return its value
	public abstract int rollDice();
	
	public abstract String toString();

}
