package it.polimi.ingsw.ps11.model.resources.list;

import it.polimi.ingsw.ps11.model.resources.Resource;
/**
 * <h3>MilitaryPoint</h3>
 * <p> Classe che rappresenta la risorsa punti Militari. Estende la classe Resource.</p>
 * @see Resource
 */
public class MilitaryPoint extends Resource {
	
	public MilitaryPoint(){
		this(DEFAULT);
	}
	
	public MilitaryPoint(int value){
		super(value);
	}

	@Override
	public MilitaryPoint clone() {
		return new MilitaryPoint(this.value);
	}
}
