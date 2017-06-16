package it.polimi.ingsw.ps11.cranio.dices;

public class BlackDice extends Dice {
	
	public BlackDice(){
		super();		
	}

	@Override
	public String toString() {
		return "BlackDice [value=" + value + "]";
	}
	
	@Override
	public BlackDice clone() {
		BlackDice clone = new BlackDice();
		clone.value = this.value;
		
		return clone;
	}

}
