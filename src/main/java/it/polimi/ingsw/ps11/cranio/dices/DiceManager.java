package it.polimi.ingsw.ps11.cranio.dices;

public class DiceManager {
	
	private BlackDice blackDice;
	private WhiteDice whiteDice;
	private OrangeDice orangeDice;
	
	public DiceManager() {
		blackDice = new BlackDice();
		whiteDice = new WhiteDice();
		orangeDice = new OrangeDice();
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
	
}
