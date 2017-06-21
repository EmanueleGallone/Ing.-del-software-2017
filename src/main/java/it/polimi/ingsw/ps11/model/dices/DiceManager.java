package it.polimi.ingsw.ps11.model.dices;

import java.io.Serializable;
/**
 * <h3>DiceManager</h3>
 * <p> Classe container per i dadi.
 * </p>
 * @version 1.0
 * @see it.polimi.ingsw.ps11.model.dices.Dice Dice
 *
 */
public class DiceManager implements Serializable {
	
	private BlackDice blackDice;
	private WhiteDice whiteDice;
	private OrangeDice orangeDice;
	
	public DiceManager() {
		blackDice = new BlackDice();
		whiteDice = new WhiteDice();
		orangeDice = new OrangeDice();
	}
	
	/**<h3>public void rollDices()</h3>
	 * <p>
	 * Metodo che emula il lancio dei dadi. Nei campi value dei singoli dadi viene assegnato un valore Random tra 1 e 6;
	 * </p>
	 */
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
		DiceManager clone = new DiceManager();
		
		clone.blackDice = this.blackDice.clone();
		clone.whiteDice = this.whiteDice.clone();
		clone.orangeDice = this.orangeDice.clone();
		
		return clone;
	}
	
}
