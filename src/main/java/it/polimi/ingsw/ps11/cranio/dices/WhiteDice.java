package it.polimi.ingsw.ps11.cranio.dices;

public class WhiteDice extends Dice {
	
	public WhiteDice(){
		super();	
	}

	@Override
	public String toString() {
		return "WhiteDice [value=" + value + "]";
	}
	
	@Override
	public WhiteDice clone() {
		WhiteDice clone = new WhiteDice();
		
		clone.value = this.value;
		
		return clone;
	}

}
