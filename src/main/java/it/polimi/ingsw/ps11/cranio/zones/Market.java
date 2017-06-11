package it.polimi.ingsw.ps11.cranio.zones;

import it.polimi.ingsw.ps11.cranio.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.cranio.zones.actionSpace.MultipleActionSpace;

public class Market {
	
	private MultipleActionSpace space = new MultipleActionSpace();
	
	public Market() {
		
	}
	
	public void addActionSpace(ActionSpace actionSpace){
		space.addActionSpace(actionSpace);
	}
	
}
