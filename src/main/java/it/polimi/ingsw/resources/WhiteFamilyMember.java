package it.polimi.ingsw.resources;

import it.polimi.ingsw.dices.WhiteDice;

public class WhiteFamilyMember extends FamilyMember {
	
	public WhiteFamilyMember(){
		super();
	}
	
	//metto private poi eventualmente cambio visibilità. ema
	private void updateValue(WhiteDice dice){
		this.value = dice.getValue();
	}
	
	//serve? mah.. ema
	private void setValue(WhiteDice dice){
		this.value = dice.getValue();
		
	}

	@Override
	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "WhiteFamilyMember [value=" + value + "]";
	}

}
