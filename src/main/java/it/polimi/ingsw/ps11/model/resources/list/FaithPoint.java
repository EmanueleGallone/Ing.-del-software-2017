package it.polimi.ingsw.ps11.model.resources.list;

import it.polimi.ingsw.ps11.model.resources.Resource;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/**
 * <h3>FaithPoint</h3>
 * <p> Classe che rappresenta la risorsa punti Fede. Estende la classe Resource.</p>
 * @see Resource
 */
public class FaithPoint extends Resource {
	
	private static final String id = "FaithPoint";

	public FaithPoint() {
		this(DEFAULT);

	}
	
	public FaithPoint(int value){
		super(id,value);
	}

	@Override
	public FaithPoint clone() {
		return new FaithPoint(this.value);
	}

	@Override
	public FaithPoint getFrom(ResourceList resourceList) {
		FaithPoint resource = resourceList.get(id);
		if (resource == null) {
			return new FaithPoint();
		}
		return resource;
	}
}
