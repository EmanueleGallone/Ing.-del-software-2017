package it.polimi.ingsw.ps11.cranio.malus.thirdPeriod;

import it.polimi.ingsw.ps11.cranio.malus.Excommunication;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.resources.Resource;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.resources.list.VictoryPoint;

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
