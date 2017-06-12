package it.polimi.ingsw.ps11.cranio.zones;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.cranio.zones.actionSpace.MultipleActionSpace;

public class CouncilPalace extends MultipleActionSpace {
	
	
	public ArrayList<Player> getNewOrder(){
		ArrayList<Player> newOrder = new ArrayList<>();
		for(ActionSpace space : multipleActionSpace){
			newOrder.add(space.getOwner());
		}
		return newOrder;
	}

}
