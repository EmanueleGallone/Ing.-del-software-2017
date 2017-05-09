package it.polimi.ingsw.resources;

import gioco.da.console.Player;

public class FamilyMember extends Resource implements Cloneable {
	protected boolean isUsed;
	protected String owner; //importante per il controllo che nella stessa torre non vi siano più familiari dello stesso giocatore
	
	public FamilyMember(Player player){
		super();
		isUsed = false;
		owner = player.getPlayerName(); //ancora non utilizzato
	}
	
	public FamilyMember(){
		super();
		isUsed = false;
	}
	
	/**
	 * public void setIsUsed(boolean value) 
	 * setter per la variabile isUsed
	 * @param value - boolean 
	 */
	public void setIsUsed(boolean value){
		isUsed = value;
	}
	
	/**
	 *  public boolean isUsed()
	 * se il familiare è stato usato ritorna true 
	 * @return boolean 
	 */
	public boolean isUsed(){
		return isUsed;
	}
	
	@Override
	public FamilyMember clone (){
		try {
			
			return (FamilyMember) super.clone();
			
		} catch (CloneNotSupportedException e) {
			System.err.println("Clone not supported!");
		}
		return null; 
	}
	
	public String getOwnerName(){
		return this.owner; //inutilizzato
	}

}
