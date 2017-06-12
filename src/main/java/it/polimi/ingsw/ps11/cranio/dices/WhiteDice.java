package it.polimi.ingsw.ps11.cranio.dices;

public class WhiteDice extends Dice {
	
	public WhiteDice(){
		super();	
	}
	
	private WhiteDice(WhiteDice toCopy){
		//copy Constructor
		this.value = toCopy.value;
	}

	@Override
	public String toString() {
		return "WhiteDice [value=" + value + "]";
	}
	
	@Override
	public WhiteDice clone() {
		return new WhiteDice(this);
	}

}
