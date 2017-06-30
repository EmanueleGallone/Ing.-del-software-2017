package it.polimi.ingsw.ps11.model.dices;

import java.util.HashMap;
import java.util.Iterator;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
/**
 * <h3> DiceManager </h3>
 * <p> Classe Manager per i dadi. Associa ad ogni tipo di dato il dado corrispondente. Uno per ogni partita. </p>
 * @see DevelopmentCard
 */
public class DiceManager implements Iterable<Dice>{
	
	private static final int DEFAULT_VALUE = 0;
	private HashMap<String, Dice> dices = new HashMap<>();
	
// start constructor

	public DiceManager() {
		
		BlackDice blackDice = new BlackDice();
		WhiteDice whiteDice = new WhiteDice();
		OrangeDice orangeDice = new OrangeDice();
		dices.put(blackDice.getClass().toString(), blackDice);
		dices.put(whiteDice.getClass().toString(), whiteDice);
		dices.put(orangeDice.getClass().toString(), orangeDice);
		
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
	
	public void rollDices(){
		for(String dice: dices.keySet()){
			dices.get(dice).rollDice();
		}
	}
	
	public <T extends Dice> T getDice(Class<T> diceClass){
		return getDice(diceClass.toString());
	}
	
	@SuppressWarnings("unchecked")
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

	@Override
	public Iterator<Dice> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
