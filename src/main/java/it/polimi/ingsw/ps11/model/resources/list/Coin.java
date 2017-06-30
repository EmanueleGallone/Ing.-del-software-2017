package it.polimi.ingsw.ps11.model.resources.list;

import it.polimi.ingsw.ps11.model.resources.Resource;
/**
 * <h3>Coin</h3>
 * <p> Classe che rappresenta la risorsa Moneta. Estende la classe Resource.</p>
 * @see Resource
 */
public class Coin extends Resource {
	
	public Coin(){
		this(DEFAULT);
	}
	
	public Coin(int value){
		super(value);
	}

	@Override
	public Coin clone() {
		return  new Coin(this.value);
	}
}
