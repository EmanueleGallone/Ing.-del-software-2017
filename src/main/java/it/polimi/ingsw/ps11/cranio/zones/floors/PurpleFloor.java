package it.polimi.ingsw.ps11.cranio.zones.floors;

import it.polimi.ingsw.ps11.cranio.cards.PurpleCard;
import it.polimi.ingsw.ps11.cranio.resources.list.Coin;
import it.polimi.ingsw.ps11.cranio.zones.ActionSpace;
import it.polimi.ingsw.ps11.cranio.zones.Floor;

public class PurpleFloor extends Floor<PurpleCard, Coin> {

	public PurpleFloor(ActionSpace<Coin> actionSpace, PurpleCard card) {
		super(actionSpace, card);
		
	}
	
	public PurpleFloor(ActionSpace<Coin> actionSpace) {
		super(actionSpace);
		
	}

}
