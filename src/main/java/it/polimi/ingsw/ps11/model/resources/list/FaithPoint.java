package it.polimi.ingsw.ps11.model.resources.list;

import it.polimi.ingsw.ps11.model.resources.Resource;
/**
 * <h3>FaithPoint</h3>
 * <p> Classe che rappresenta i punti fede. </p>
 */
public class FaithPoint extends Resource {

	public FaithPoint() {
		this(DEFAULT);

	}
	
	public FaithPoint(int value){
		super(value);
	}

	@Override
	public FaithPoint clone() {
		return new FaithPoint(this.value);
	}
}
