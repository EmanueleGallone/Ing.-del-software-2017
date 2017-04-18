package it.polimi.ingsw.dices;

public abstract class Dice {
	protected static final int MAX_FACES = 6;
	protected int value;
	
	
	
	//rolls a Dice; I don't know how a computer rolls a dice but I think that it doesn't need more explanation,right?
	//#TryingToBeFunnyWhileCodingButFailingMiserably #FinishThisGameOrDieTrying #IWantToGraduate. ema
	public abstract void rollDice();
	
	public abstract int getValue();
	
	@Override
	public abstract String toString();

}
