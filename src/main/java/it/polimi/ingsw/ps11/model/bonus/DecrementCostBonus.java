package it.polimi.ingsw.ps11.model.bonus;

import it.polimi.ingsw.ps11.model.gameLogics.actions.old.ActionObserver;
import it.polimi.ingsw.ps11.model.gameLogics.actions.old.list.GetCard;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;

public class DecrementCostBonus implements ActionObserver<GetCard> {

	private ResourceList resource;
	private String tower;
	
	public DecrementCostBonus(Class<? extends Tower> tower , ResourceList resource) {
		this.resource = resource;
		this.tower = tower.toString();
	}
	
	@Override
	public void affectPerform(GetCard action) {
		
	}
	
	@Override
	public boolean affectCondiction(GetCard action) {
		//Bisogna mettere il controllo sul tipo di torre
		ResourceList cost = action.getCost();
		cost.subtract(resource);
		return true;
	}

}
