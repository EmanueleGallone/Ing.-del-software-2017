package it.polimi.ingsw.ps11.model.bonus.ema.malus.thirdPeriod;

import it.polimi.ingsw.ps11.model.bonus.ema.malus.Excommunication;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.model.resources.list.VictoryPoint;

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
