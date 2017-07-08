package it.polimi.ingsw.ps11.model.resources.list;

import it.polimi.ingsw.ps11.model.resources.Resource;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/**
 * <h3>Servant</h3>
 * <p> Classe che rappresenta la risorsa Servitori. Estende la classe Resource.</p>
 * @see Resource
 */
public class Servant extends Resource {
	
	private static final String id = "Servant";

	public Servant(){
		this(DEFAULT);
	}
	
	public Servant(int value){
		super(id,value);
	}

	@Override
	public Servant clone() {
		return new Servant(this.value);
	}
	
	@Override
	public Servant getFrom(ResourceList resourceList) {
		Servant resource = resourceList.get(id);
		if (resource == null) {
			return new Servant();
		}
		return resource;
	}
}
