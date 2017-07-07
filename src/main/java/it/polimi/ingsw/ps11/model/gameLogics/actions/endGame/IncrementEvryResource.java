package it.polimi.ingsw.ps11.model.gameLogics.actions.endGame;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.resources.Resource;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.VictoryPoint;

public class IncrementEvryResource implements Action{
	
	private final int COST = 5;
	private ActionManager aManager;
	
	public IncrementEvryResource(ActionManager aManager) {
		this.aManager = aManager;
	}
	
	@Override
	public boolean isLegal() {
		return true;
	}

	@Override
	public void perform() {
		ResourceList playerResource = aManager.state().getPlayer().getResourceList();
		int totalPoint,sum=0;
		for(Resource resource : playerResource){
			sum = sum + resource.getValue();
		}
		
		totalPoint = sum/COST;
		playerResource.sum(new ResourceList(new VictoryPoint(totalPoint)));
	}

	@Override
	public IncrementEvryResource clone() {
		return new IncrementEvryResource(aManager);
	}

}
