package it.polimi.ingsw.ps11.model.dices;
/**
 * Classe concreta che rappresenta il dado nero.
 *
 */
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
