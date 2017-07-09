package it.polimi.ingsw.ps11.model.familyMember;

import java.io.Serializable;

import it.polimi.ingsw.ps11.model.dices.DiceProxy;
public abstract class FamilyMember implements Serializable{
	
	private final int DEFAULT_MODIFIER = 0;
	private String id;
	
	protected DiceProxy dice;
	protected boolean used = false;
	
	public FamilyMember(String id){
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public int getValue(){
		int value = 0;
		if(dice != null)
			value = dice.getValue();
		return value;
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
	
	public abstract FamilyMember getFrom(FamilyMemberManager familyMemberManager);
	
	@Override
	public abstract FamilyMember clone();
	
	/**<h3> String toString() </h3>
	 * <p>TIPOFAMILIARE "[value=" + value + ", modifier=" + modifier + "]"</p>
	 */
	public String toString() {
		return "FamilyMember [value=" + getValue() + "]";
	}
	
	/**<h3> boolean isNeutral() </h3>
	 * <p> Indica se un familiare è di tipo Neutrale</p>
	 * @return true se il familiare è di tipo Neutral, false altrimenti
	 */
	public boolean isNeutral() {
		return false;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(obj.getClass().equals(this.getClass())){
			FamilyMember fMember = (FamilyMember) obj;
				return fMember.getValue() == fMember.getValue() && this.getId().equals(fMember.getId());
		}
		return false;
	}
	
}
