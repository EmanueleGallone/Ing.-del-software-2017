package it.polimi.ingsw.ps11.model.resources;

import java.io.Serializable;
/**
 * <h3>Resource</h3>
 * <p>Classe astratta che rappresenta le risorse del gioco. Per ogni tipo di risorsa è stata creata una classe specifica.</p>
 * @see Stone, Wood, Coin, Servant, VictoryPoint, MilitaryPoint, FaithPoint.
 */
public abstract class Resource implements Serializable {
	protected static final int DEFAULT = 0;
	protected int value;
	
	//start constructor
	public Resource(){
		this(DEFAULT);
	}
	
	public Resource(int value){
		this.value = value;
	}
	
	//end constructor
	
	public int getValue(){
		return this.value;
	}
	
	public void setValue(int value){
		this.value = value;
	}
	
	/**<h3>public void increment(int value)</h3>
	 * <p>
	 * Metodo che permette di incrementare il valore della risorsa senza dove passare per il setValue().
	 * </p>
	 * @param value è il valore di incremento per la risorsa.
	 */
	public void increment(int value){
		this.value += value;
		if (this.value < 0)
			this.value = 0;
	}
	
	@Override
	public abstract Resource clone();
	
	@Override
	public boolean equals(Object obj) {
		if(obj.getClass() == this.getClass() && ((Resource)obj).getValue() == value){
			return true;
		}
		return false;
	}
}
