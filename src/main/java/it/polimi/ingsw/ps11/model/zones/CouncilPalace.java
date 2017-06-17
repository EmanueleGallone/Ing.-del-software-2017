package it.polimi.ingsw.ps11.model.zones;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.actionSpace.MultipleActionSpace;

public class CouncilPalace extends MultipleActionSpace {
	
	
	public ArrayList<Player> getNewOrder(){
		ArrayList<Player> newOrder = new ArrayList<>();
		for(ActionSpace space : multipleActionSpace){
			newOrder.add(space.getOwner());
		}
		return newOrder;
	}

}
