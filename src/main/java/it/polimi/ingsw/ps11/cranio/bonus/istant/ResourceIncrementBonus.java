package it.polimi.ingsw.ps11.cranio.bonus.istant;

import it.polimi.ingsw.ps11.cranio.bonus.Bonus;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;

public class ResourceIncrementBonus extends Bonus {

	private ResourceList target,value;
	
	public ResourceIncrementBonus(ResourceList value) {
		this.value = value;
	}
	
	@Override
	public void behavior(){
		this.target.sum(value);
	}
	
	public void setTarget(ResourceList target){
		this.target = target;
	}
}
