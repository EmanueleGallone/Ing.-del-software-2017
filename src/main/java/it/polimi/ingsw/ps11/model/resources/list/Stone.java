package it.polimi.ingsw.ps11.model.resources.list;

import it.polimi.ingsw.ps11.model.resources.Resource;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/**
 * <h3>Stone</h3>
 * <p> Classe che rappresenta la risorsa Pietra. Estende la classe Resource.</p>
 * @see Resource
 */
public class Stone extends Resource {
	
	private static final String id = "Stone";
	
	public Stone(){
		this(DEFAULT);
	}
	
	public Stone(int value){
		super(id,value);
	}
	

	@Override
	public Stone clone() {
		return new Stone(this.value);
	}
	
	@Override
	public Stone getFrom(ResourceList resourceList) {
		Stone resource = resourceList.get(id);
		if (resource == null) {
			return new Stone();
		}
		return resource;
	}
}
