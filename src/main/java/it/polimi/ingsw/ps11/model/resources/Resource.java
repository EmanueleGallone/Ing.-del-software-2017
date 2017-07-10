package it.polimi.ingsw.ps11.model.resources;

import java.io.Serializable;
/**
 * <h3>Resource</h3>
 * <p>Classe astratta che rappresenta le risorse del gioco. Per ogni tipo di risorsa è stata creata una classe concreta specifica.
 * Tali risorse sono state designate in modo tale da non poter avere valori negativi. Tutte le risorse erediteranno da questa classe un solo metodo
 * (oltre i canonici getter e setter), ovvero il metodo <code>increment</code> che permette di aggiungere o sottrarre risorse.
 * </p>
 * @version 1.0
 * @see it.polimi.ingsw.ps11.model.resources.list.Stone Stone
 * @see it.polimi.ingsw.ps11.model.resources.list.Wood Wood
 * @see it.polimi.ingsw.ps11.model.resources.list.Coin Coin
 * @see it.polimi.ingsw.ps11.model.resources.list.Servant Servant
 * @see it.polimi.ingsw.ps11.model.resources.list.FaithPoint FaithPoint
 * @see it.polimi.ingsw.ps11.model.resources.list.MilitaryPoint MilitaryPoint
 * @see it.polimi.ingsw.ps11.model.resources.list.VictoryPoint VictoryPoint
 */
public abstract class Resource implements Serializable {
	protected static final int DEFAULT = 0;
	protected int value;
	private String id;
	
	//start constructor
	public Resource(String id){
		this(id,DEFAULT);
	}
	
	public Resource(String id,int value){
		this.value = value;
		this.id = id;
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
		int result = value + getValue();
		if(result < 0)
			setValue(0);
		else
			setValue(result);
	}
	
	public String getId() {
		return id;
	}
	
	public abstract Resource getFrom(ResourceList resourceList);
	
	@Override
	public abstract Resource clone();
	
	/**<h3> boolean equals(Object) </h3>
	 * <p>Compara due risorse, ritorna true se sono dello stesso tipo e hanno lo sstesso valore</p>
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		
		if(obj.getClass() == this.getClass() && ((Resource)obj).getValue() == value){
			return true;
		}
		return false;
	}
}
