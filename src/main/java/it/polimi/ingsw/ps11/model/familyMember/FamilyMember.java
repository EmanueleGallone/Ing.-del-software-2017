package it.polimi.ingsw.ps11.model.familyMember;

import java.io.Serializable;

import it.polimi.ingsw.ps11.model.familyMember.list.NeutralFamilyMember;
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
import it.polimi.ingsw.ps11.model.dices.DiceProxy;
public abstract class FamilyMember implements Serializable{
	
	private final int DEFAULT_MODIFIER = 0;
	
	//protected int value; 
	protected DiceProxy dice;
	protected int modifier;
	private boolean used = false;
	private String name;
	
	public FamilyMember(){
		modifier = DEFAULT_MODIFIER;
	}
	

	public FamilyMember(String name){
		this();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public int getValue(){
		int value = 0;
		if(dice != null)
			value = dice.getValue();
		return value + this.modifier;
	}

	public void setModifier(int value){
		this.modifier = value;
	}
	
	public void resetModifier(){
		modifier = DEFAULT_MODIFIER;
	}
	
	public void setDice(DiceProxy dice) {
		this.dice = dice;
	}
	
	/**<h3> boolean isUsed() </h3>
	 * <p>Indica se un familiare è già stato usato e di conseguenza non può essere riutilizzato fino alla fine del turno</p>
	 * @return true se è già stato utilizzato, false altrimenti.
	 */
	public boolean isUsed() {
		return used;
	}
	
	public void setUsed(boolean used) {
		this.used = used;
	}
	
	@Override
	public abstract FamilyMember clone();
	
	/**<h3> String toString() </h3>
	 * <p>TIPOFAMILIARE "[value=" + value + ", modifier=" + modifier + "]"</p>
	 */
	public String toString() {
		return "FamilyMember [value=" + getValue() + ", modifier=" + modifier + "]";
	}
	
	/**<h3> boolean isNeutral() </h3>
	 * <p> Indica se un familiare è di tipo Neutrale</p>
	 * @return true se il familiare è di tipo Neutral, false altrimenti
	 */
	public boolean isNeutral() {
		return false;
	}
	
}
