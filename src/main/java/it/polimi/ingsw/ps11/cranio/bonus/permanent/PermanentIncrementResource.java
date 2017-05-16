package it.polimi.ingsw.ps11.cranio.bonus.permanent;

import it.polimi.ingsw.ps11.cranio.bonus.istant.ResourceIncrementBonus;
import it.polimi.ingsw.ps11.cranio.observers.Observer;

public class PermanentIncrementResource implements Observer{

	private ResourceIncrementBonus effect;
	
	
	public PermanentIncrementResource(ResourceIncrementBonus effect) {
		this.effect = effect;
	}


	@Override
	public void update() {
		
	}
	
	

}
