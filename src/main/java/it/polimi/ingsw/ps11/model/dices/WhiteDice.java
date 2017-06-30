package it.polimi.ingsw.ps11.model.dices;
/**
 * <h3> BlacKDice </h3>
 * <p> Classe concreta che rappresenta il dado di colore Bianco. Estende la classe Dice.</p>
 * @see Dice
 */
public class WhiteDice extends Dice {
	
	public WhiteDice(){
		super();	
	}

	@Override
	public String toString() {
		return "WhiteDice [value=" + value + "]";
	}
	
	@Override
	public WhiteDice clone() {
		WhiteDice clone = new WhiteDice();
		
		clone.value = this.value;
		
		return clone;
	}

}
