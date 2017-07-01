package it.polimi.ingsw.ps11.model.familyMember;

import java.io.Serializable;
/**
 * <h3>FamilyMember</h3>
 * <p>
 * Classe astratta che rappresenta il familiare. Per ogni familiare è stata implementata una classe concreta apposita, figlia di FamilyMember.
 * </p>
 * @version 1.0
 * @see it.polimi.ingsw.ps11.model.familyMember.list.OrangeFamilyMember OrangeFamilyMember
 * @see it.polimi.ingsw.ps11.model.familyMember.list.BlackFamilyMember BlackFamilyMember
 * @see it.polimi.ingsw.ps11.model.familyMember.list.WhiteFamilyMember WhiteFamilyMember
 * @see it.polimi.ingsw.ps11.model.familyMember.list.NeutralFamilyMember NeutralFamilyMember
 */

import it.polimi.ingsw.ps11.model.dices.Dice;
public abstract class FamilyMember implements Serializable{
	
	private final int DEFAULT_MODIFIER = 0;
	
	//protected int value; 
	protected transient Dice dice;
	protected int modifier;
	private boolean used = false;
	
	
	public FamilyMember(){
		modifier = DEFAULT_MODIFIER;
	}
	
//start logics
	
//end logics

	public int getValue(){
		int value = 0;
		if(dice == null)
			value = dice.getValue();
		return value + this.modifier;
	}

	public void setModifier(int value){
		this.modifier = value;
	}
	
	public void resetModifier(){
		modifier = DEFAULT_MODIFIER;
	}
	
	public void setDice(Dice dice) {
		this.dice = dice;
	}
	
	public abstract boolean isNeutral();
	
	public boolean isUsed() {
		return used;
	}
	
	public void setUsed(boolean used) {
		this.used = used;
	}
	
	@Override
	public abstract FamilyMember clone();
	
	@Override
	public String toString() {
		return "FamilyMember [value=" + getValue() + ", modifier=" + modifier + "]";
	}
	
}
