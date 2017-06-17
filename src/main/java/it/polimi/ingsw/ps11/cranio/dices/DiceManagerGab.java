package it.polimi.ingsw.ps11.cranio.dices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import it.polimi.ingsw.ps11.cranio.resources.list.Coin;


public class DiceManagerGab implements Iterable<Dice>{
	
	private static final int DEFAULT_VALUE = 0;
	private HashMap<String, Dice> dices = new HashMap<>();
	
// start constructor

	public DiceManagerGab() {
		
		BlackDice blackDice = new BlackDice();
		WhiteDice whiteDice = new WhiteDice();
		OrangeDice orangeDice = new OrangeDice();
		dices.put(blackDice.getClass().toString(), blackDice);
		dices.put(whiteDice.getClass().toString(), whiteDice);
		dices.put(orangeDice.getClass().toString(), orangeDice);
		
	}
	
	private DiceManagerGab(DiceManagerGab toCopy){
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
	
	public BlackDice getBlackDice() {
		return (BlackDice) dices.get(BlackDice.class.toString());
	}
	
	public WhiteDice getWhiteDice() {
		return (WhiteDice) dices.get(WhiteDice.class.toString());
	}
	
	public OrangeDice getOrangeDice() {
		return (OrangeDice) dices.get(OrangeDice.class.toString());
	}
	
	public String toString(){
		String string = "";
		
		for(Dice dice: dices.values()){
			string = string + dice.toString() + "\n";
		}
		return string.substring(0, string.length() - 1)+ ".";
	}
	
	@Override
	public DiceManagerGab clone(){
		return new DiceManagerGab(this);
	}

	@Override
	public Iterator<Dice> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
