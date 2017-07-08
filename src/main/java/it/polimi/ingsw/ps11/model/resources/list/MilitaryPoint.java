package it.polimi.ingsw.ps11.model.resources.list;

import it.polimi.ingsw.ps11.model.resources.Resource;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/**
 * <h3>MilitaryPoint</h3>
 * <p> Classe che rappresenta la risorsa punti Militari. Estende la classe Resource.</p>
 * @see Resource
 */
public class MilitaryPoint extends Resource {
	
	private static final String id = "MilitaryPoint";
	
	public MilitaryPoint(){
		this(DEFAULT);
	}
	
	public MilitaryPoint(int value){
		super(id,value);
	}

	@Override
	public MilitaryPoint clone() {
		return new MilitaryPoint(this.value);
	}
	
	@Override
	public MilitaryPoint getFrom(ResourceList resourceList) {
		MilitaryPoint resource = resourceList.get(id);
		if (resource == null) {
			return new MilitaryPoint();
		}
		return resource;
	}
}
