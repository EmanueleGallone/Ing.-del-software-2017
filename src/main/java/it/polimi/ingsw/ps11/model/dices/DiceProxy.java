package it.polimi.ingsw.ps11.model.dices;

import java.io.Serializable;
/**
 * <h3> DiceProxy </h3>
 * <p> Classe proxy che utilizzato per nascondere il riferimento al dado effettivo. Rende noto il solo <code>valore</code> del dado.</p>
 * @see Dice
 */
public class DiceProxy implements Serializable{

	private Dice dice;
	public DiceProxy(Dice dice) {
		if(dice == null)
			dice = new Dice();
		this.dice = dice;
	}
	
	public int getValue(){
		return dice.getValue();
	}
}
