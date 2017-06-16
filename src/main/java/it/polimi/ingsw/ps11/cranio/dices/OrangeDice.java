package it.polimi.ingsw.ps11.cranio.dices;

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
