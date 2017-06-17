package it.polimi.ingsw.ps11.model.malus.thirdPeriod;

import it.polimi.ingsw.ps11.model.malus.Excommunication;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.Resource;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.VictoryPoint;

public class EveryResourceSubVP extends Excommunication {
	
	public EveryResourceSubVP(Player player) {
		this.owner = player;
	}

	@Override
	public void behaviour() {
		int counter = 0;
		for(Resource resource : owner.getResourceList()){
			counter = counter + resource.getValue();
		}
		
		ResourceList resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(counter));
		
		owner.getResourceList().subtract(resourceList);
		
	}

}
