package it.polimi.ingsw.ps11.model.dices;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;

/**
 * <h3> DiceManager </h3>
 * <p> Classe Manager per i <code>Dice</code>. Associa ad ogni tipo di dato il dado corrispondente. Uno per ogni partita. Ad ogni turno 
 * assegna ad ogni suo dado un valore casuale compreso tra 1 e 6.</p>
 * @see DevelopmentCard
 */
public class DiceManager implements Iterable<Dice>,Serializable{
	
	private HashMap<String, Dice> dices = new HashMap<String, Dice>();

	public DiceManager(ArrayList<Dice> dices) {
		for(Dice dice : dices){
			this.dices.put(dice.getName(), dice);
		}
	}
	
	/**<h3> void rollDices() </h3>
	 * <p> Assegna un valore random compreso tra 1 e 6 ad ogni dado contenuto nel Dicemanager</p>
	 */
	public void rollDices(){
		for(String dice: dices.keySet()){
			dices.get(dice).rollDice();
		}
	}
	
	public HashMap<String, Dice> getDices() {
		return dices;
	}
	
	@Override
	public DiceManager clone(){
		ArrayList<Dice> dices = new ArrayList<>(this.dices.values());
		DiceManager copy = new DiceManager((ArrayList<Dice>)dices.clone());
		return copy;
	}

	@Override
	public Iterator<Dice> iterator() {
		return new ArrayList<>(this.dices.values()).iterator();
	}
	
	public DiceProxy get(String name){
		return  new DiceProxy(dices.get(name));
	}
	
	
	/**<h3> String toString() </h3>
	 * <p> Per ogni dado stampa : TIPODADO [value= ]\n </p>
	 */
	public String toString(){
		String string = "";
		
		for(Dice dice: dices.values()){
			string = string + dice.toString() + "\n";
		}
		return string.substring(0, string.length() - 1)+ ".";
	}
	
//	public <T extends Dice> void setDice(T dice){
//	  this.dices.put(dice.getClass().toString() , dice.clone());
//  }
//	public <T extends Dice> T getDice(Class<T> diceClass){
//		return getDice(diceClass.toString());
//	}
//	
//	public <T extends Dice> T getDice(String diceClass){
//		return (T) dices.get(diceClass);
//	}
//	
//	public int getValueOf(String diceClass){
//		Dice d = this.getDice(diceClass);
//		if (d == null)
//			return DEFAULT_VALUE;
//		return d.getValue();
//	}
//	
//	public <T extends Dice> int getValueOf(Class<T> diceClass){
//		return getValueOf(diceClass.toString());
//	}
}
