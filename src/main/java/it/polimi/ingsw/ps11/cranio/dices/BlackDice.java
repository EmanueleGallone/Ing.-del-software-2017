package it.polimi.ingsw.ps11.cranio.dices;

public class BlackDice extends Dice {
	
	public BlackDice(){
		super();		
	}
	
	private BlackDice(BlackDice toCopy){
		//copy Constructor
		this.value = toCopy.value;
	}

	@Override
	public String toString() {
		return "BlackDice [value=" + value + "]";
	}
	
	@Override
	public BlackDice clone() {
		return new BlackDice(this);
	}

}
