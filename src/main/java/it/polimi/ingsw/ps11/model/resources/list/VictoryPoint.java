package it.polimi.ingsw.ps11.model.resources.list;

import it.polimi.ingsw.ps11.model.resources.Resource;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/**
 * <h3>VictoryPoint</h3>
 * <p> Classe che rappresenta la risorsa punti Vittoria. Estende la classe Resource.</p>
 * @see Resource
 */
public class VictoryPoint extends Resource{
	
	private static final String id = "VictoryPoint";
	
	public VictoryPoint(){
		this(DEFAULT);
	}
	
	public VictoryPoint(int value){
		super(id,value);
	}

	@Override
	public VictoryPoint clone() {
		return new VictoryPoint(this.value);
	}
	
	@Override
	public VictoryPoint getFrom(ResourceList resourceList) {
		VictoryPoint resource = resourceList.get(id);
		if (resource == null) {
			return new VictoryPoint();
		}
		return resource;
	}
}
