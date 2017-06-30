package it.polimi.ingsw.ps11.model.dices;
/**
 * <h3> BlacKDice </h3>
 * <p> Classe concreta che rappresenta il dado di colore Nero. Estende la classe Dice.</p>
 * @see Dice
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
