package it.polimi.ingsw.ps11.model.resources.list;

import it.polimi.ingsw.ps11.model.resources.Resource;
/**
 * <h3>MilitaryPoint</h3>
 * <p> Classe che rappresenta i punti militari. </p>
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
