package it.polimi.ingsw.ps11.model.dices;

import java.io.Serializable;

public class DiceManager implements Serializable {
	
	private BlackDice blackDice;
	private WhiteDice whiteDice;
	private OrangeDice orangeDice;
	
	public DiceManager() {
		blackDice = new BlackDice();
		whiteDice = new WhiteDice();
		orangeDice = new OrangeDice();
	}
	
	private DiceManager(DiceManager toCopy) {
		//copy Constructor
		blackDice = toCopy.getBlackDice().clone();
		whiteDice = toCopy.getWhiteDice().clone();
		orangeDice = toCopy.getOrangeDice().clone();
	}
	
	public void rollDices(){
		blackDice.rollDice();
		whiteDice.rollDice();
		orangeDice.rollDice();
	}
	
	public BlackDice getBlackDice() {
		return blackDice;
	}
	
	public WhiteDice getWhiteDice() {
		return whiteDice;
	}
	
	public OrangeDice getOrangeDice() {
		return orangeDice;
	}
	
	public String toString(){
		return "Dices: " + blackDice.toString() + whiteDice.toString() + orangeDice.toString();		
	}
	
	@Override
	public DiceManager clone(){
		return new DiceManager(this);
	}
	
}
