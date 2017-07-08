package it.polimi.ingsw.ps11.model.resources.list;

import it.polimi.ingsw.ps11.model.resources.Resource;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/**
 * <h3>Wood</h3>
 * <p> Classe che rappresenta la risorsa Legno. Estende la classe Resource.</p>
 */
public class Wood extends Resource {
	
	private static final String id = "Wood";

	public Wood(){
		this(DEFAULT);
	}
	
	public Wood(int value){
		super(id,value);
	}
	
	@Override
	public Wood clone() {
		return new Wood(this.value);
	}
	
	@Override
	public Wood getFrom(ResourceList resourceList) {
		Wood resource = resourceList.get(id);
		if (resource == null) {
			return new Wood();
		}
		return resource;
	}

}
