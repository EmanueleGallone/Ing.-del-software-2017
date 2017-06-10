package it.polimi.ingsw.ps11.cranio.malus.thirdPeriod;

import it.polimi.ingsw.ps11.cranio.malus.Excommunication;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.cranio.resources.list.VictoryPoint;

public class EveryMPSubVP extends Excommunication {
	
	public EveryMPSubVP(Player player) {
		this.owner = player;
		setPeriod(3);
	}

	@Override
	public void behaviour() {
		int counter = owner.getResourceList().getValueOf(MilitaryPoint.class);
		
		ResourceList resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(counter));
		
		owner.getResourceList().subtract(resourceList);
		
		
	}

}
