package it.polimi.ingsw.dices;

import java.util.Random;

public abstract class Dice {
	protected static final int MAX_FACES = 6;
	protected int value;
	private Random gen = new Random();
	
	public Dice(){
		this.value = 0;
	}
	
	
	
	//rolls a Dice; I don't know how a computer rolls a dice but I think that it doesn't need more explanation,right?
	//#TryingToBeFunnyWhileCodingButFailingMiserably #FinishThisGameOrDieTrying #IWantToGraduate. ema
	public void rollDice(){
		this.value = gen.nextInt(MAX_FACES) +1;
	}
	
	public int getValue(){
		return this.value;
	}
	
	@Override
	public abstract String toString();

}
