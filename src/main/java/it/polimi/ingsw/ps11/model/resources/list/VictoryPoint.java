package it.polimi.ingsw.ps11.model.resources.list;

import it.polimi.ingsw.ps11.model.resources.Resource;
/**
 * <h3>VictoryPoint</h3>
 * <p> Classe che rappresenta la risorsa punti Vittoria. Estende la classe Resource.</p>
 * @see Resource
 */
public class VictoryPoint extends Resource{
	
	public VictoryPoint(){
		this(DEFAULT);
	}
	
	public VictoryPoint(int value){
		super(value);
	}

	@Override
	public VictoryPoint clone() {
		return new VictoryPoint(this.value);
	}
}
