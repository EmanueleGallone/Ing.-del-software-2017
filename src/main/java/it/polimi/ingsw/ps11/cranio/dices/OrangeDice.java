package it.polimi.ingsw.ps11.cranio.dices;

public class OrangeDice extends Dice {
	
	public OrangeDice(){
		super();	
	}
	
	private OrangeDice(OrangeDice toCopy){
		//copy Constructor
		this.value = toCopy.value;
	}
	
	@Override
	public String toString() {
		return "YellowDice [value=" + value + "]";
	}
	
	@Override
	public OrangeDice clone() {
		return new OrangeDice(this);
	}
	

}
