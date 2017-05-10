package it.polimi.ingsw.ps11.cranio.zones.floors;

import it.polimi.ingsw.ps11.cranio.cards.BlueCard;
import it.polimi.ingsw.ps11.cranio.resources.list.Stone;
import it.polimi.ingsw.ps11.cranio.zones.ActionSpace;
import it.polimi.ingsw.ps11.cranio.zones.Floor;

public class BlueFloor extends Floor<BlueCard, Stone>{

	public BlueFloor(ActionSpace<Stone> actionSpace) {
		super(actionSpace);
		
	}
	
	public BlueFloor(ActionSpace<Stone> actionSpace,BlueCard card){
		super(actionSpace,card);
	}
	

}
