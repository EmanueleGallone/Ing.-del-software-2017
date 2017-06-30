package it.polimi.ingsw.ps11.model.dices;
/**
 * <h3> BlacKDice </h3>
 * <p> Classe concreta che rappresenta il dado di colore Arancione. Estende la classe Dice.</p>
 * @see Dice
 */
public class OrangeDice extends Dice {
	
	public OrangeDice(){
		super();	
	}
	
	@Override
	public String toString() {
		return "YellowDice [value=" + value + "]";
	}
	
	@Override
	public OrangeDice clone() {
		OrangeDice clone = new OrangeDice();
		
		clone.value = this.value;
		
		return clone;
	}
	

}
