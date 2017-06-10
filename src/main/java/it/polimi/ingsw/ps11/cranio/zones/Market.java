package it.polimi.ingsw.ps11.cranio.zones;

import it.polimi.ingsw.ps11.cranio.zones.ActionSpace.ActionSpace;
import it.polimi.ingsw.ps11.cranio.zones.ActionSpace.MultipleActionSpace;

public class Market {
	
	private MultipleActionSpace space = new MultipleActionSpace();
	
	public Market() {
		
	}
	
	public void addActionSpace(ActionSpace actionSpace){
		space.addActionSpace(actionSpace);
	}
	
}
