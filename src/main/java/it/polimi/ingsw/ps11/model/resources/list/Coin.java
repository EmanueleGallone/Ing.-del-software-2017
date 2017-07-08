package it.polimi.ingsw.ps11.model.resources.list;

import it.polimi.ingsw.ps11.model.resources.Resource;
/**
 * <h3>Coin</h3>
 * <p> Classe che rappresenta la risorsa Moneta. Estende la classe Resource.</p>
 * @see Resource
 */
public class Coin extends Resource {
	
	private final static String id = "Coin";
	
	public Coin(){
		this(id,DEFAULT);
	}
	
	public Coin(String id, int value){
		super(id,value);
	}

	@Override
	public Coin clone() {
		return  new Coin(id,this.value);
	}
}
