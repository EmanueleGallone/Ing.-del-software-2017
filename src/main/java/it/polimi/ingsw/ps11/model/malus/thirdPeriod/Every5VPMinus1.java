package it.polimi.ingsw.ps11.model.malus.thirdPeriod;

import it.polimi.ingsw.ps11.model.malus.Excommunication;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.VictoryPoint;

public class Every5VPMinus1 extends Excommunication {
	
	public Every5VPMinus1(Player player) {
		this.owner = player;
		setPeriod(3);
	}

	@Override
	public void behaviour() {
		int counter = 0;
		
		for(int i = 0; i < owner.getResourceList().getValueOf(VictoryPoint.class); i = i +5)
			if( (i % 5) == 0 ) //inutile se faccio il for a passo 5
				counter++;
		
		ResourceList resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(counter));
		
		this.owner.getResourceList().subtract(resourceList);
		
	}

}
