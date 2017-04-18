package it.polimi.ingsw.resources;

import it.polimi.ingsw.dices.Dice;

public abstract class FamilyMember extends Resource {
	public static final int MAX_FAMILY_MEMBERS_PER_PLAYER = 4;
	
	public FamilyMember(){
		this.value = 0;
	}

	@Override
	public abstract int getValue();
	//public abstract void setValue(Dice dice); non funziona se come parametro metto qui Dice e poi nelle specializzazioni metto YellowDice etc..
	
	//attenzione da capire BENE prima di far casini con i dadi. Me la vedo io. ema
	//nota per me: magari sposto updateValue inside le varie classi family member e invece di Dice metto WhiteDice etc. etc.. ema
	public void updateValue(Dice dice){
		this.value = dice.getValue();
	}
}
