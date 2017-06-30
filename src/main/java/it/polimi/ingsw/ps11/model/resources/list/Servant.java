package it.polimi.ingsw.ps11.model.resources.list;

import it.polimi.ingsw.ps11.model.resources.Resource;
/**
 * <h3>Servant</h3>
 * <p> Classe che rappresenta la risorsa Servitori. Estende la classe Resource.</p>
 * @see Resource
 */
public class Servant extends Resource {

	public Servant(){
		this(DEFAULT);
	}
	
	public Servant(int value){
		super(value);
	}

	@Override
	public Servant clone() {
		return new Servant(this.value);
	}
}
