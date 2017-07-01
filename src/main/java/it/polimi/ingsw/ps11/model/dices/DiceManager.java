package it.polimi.ingsw.ps11.model.dices;

import java.io.Serializable;
import java.util.HashMap;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;

/**
 * <h3> DiceManager </h3>
 * <p> Classe Manager per i <code>Dice</code>. Associa ad ogni tipo di dato il dado corrispondente. Uno per ogni partita. </p>
 * @see DevelopmentCard
 */
public class DiceManager implements Serializable{
	
	private static final int DEFAULT_VALUE = 0;
	private HashMap<String, Dice> dices = new HashMap<String, Dice>();
	
// start constructor

	public DiceManager() {
		dices.put(BlackDice.class.toString(), new Dice());
		dices.put(WhiteDice.class.toString(), new Dice());
		dices.put(OrangeDice.class.toString(), new Dice());
	}
	
	private DiceManager(DiceManager toCopy){
		//copy constructor
		//attenzione, bisogna fare così, ho già testato che in altri modi si passa semplicemente un riferimento invece che creare nuovi oggetti
		for(Dice dice: toCopy.dices.values())
			setDice(dice.clone()); // o si usa il setter, oppure si fa la put sulla map
		
	}

// end constructor	
// Start setters
	
	public <T extends Dice> void setDice(T dice){
		this.dices.put(dice.getClass().toString() , dice.clone());
	}
	
	protected void setDices(HashMap<String, Dice> dices) {
		this.dices = dices;
	}
	
//End setters
// start logic
	
	/**<h3> void rollDices() </h3>
	 * <p> Assegna un valore random compreso tra 1 e 6 ad ogni dado contenuto nel Dicemanager</p>
	 */
	public void rollDices(){
		for(String dice: dices.keySet()){
			dices.get(dice).rollDice();
		}
	}
	
	public <T extends Dice> T getDice(Class<T> diceClass){
		return getDice(diceClass.toString());
	}
	
	public <T extends Dice> T getDice(String diceClass){
		return (T) dices.get(diceClass);
	}
	
	public int getValueOf(String diceClass){
		Dice d = this.getDice(diceClass);
		if (d == null)
			return DEFAULT_VALUE;
		return d.getValue();
	}
	
	public <T extends Dice> int getValueOf(Class<T> diceClass){
		return getValueOf(diceClass.toString());
	}
	
	public HashMap<String, Dice> getDices() {
		return dices;
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
	
	@Override
	public DiceManager clone(){
		return new DiceManager(this);
	}
}
