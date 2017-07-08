package it.polimi.ingsw.ps11.model.resources.list;

import it.polimi.ingsw.ps11.model.resources.Resource;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/**
 * <h3>Coin</h3>
 * <p> Classe che rappresenta la risorsa Moneta. Estende la classe Resource.</p>
 * @see Resource
 */
public class Coin extends Resource {
	
	private static final String id = "Coin";
	
	public Coin(){
		this(DEFAULT);
	}
	
	public Coin(int value){
		super(id,value);
	}

	@Override
	public Coin clone() {
		return  new Coin(this.value);
	}

	@Override
	public Coin getFrom(ResourceList resourceList) {
		Coin resource = resourceList.get(id);
		if (resource == null) {
			return new Coin();
		}
		return resource;
	}
}
