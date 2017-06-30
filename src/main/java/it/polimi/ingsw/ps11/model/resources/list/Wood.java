package it.polimi.ingsw.ps11.model.resources.list;

import it.polimi.ingsw.ps11.model.resources.Resource;
/**
 * <h3>Wood</h3>
 * <p> Classe che rappresenta la risorsa Legno. Estende la classe Resource.</p>
 */
public class Wood extends Resource {

	public Wood(){
		this(DEFAULT);
	}
	
	public Wood(int value){
		super(value);
	}
	
	@Override
	public Wood clone() {
		return new Wood(this.value);
	}

}
