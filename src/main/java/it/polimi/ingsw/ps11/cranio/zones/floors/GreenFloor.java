package it.polimi.ingsw.ps11.cranio.zones.floors;

import it.polimi.ingsw.ps11.cranio.cards.GreenCard;
import it.polimi.ingsw.ps11.cranio.resources.list.Wood;
import it.polimi.ingsw.ps11.cranio.zones.ActionSpace;
import it.polimi.ingsw.ps11.cranio.zones.Floor;

public class GreenFloor extends Floor<GreenCard, Wood> {

	public GreenFloor(ActionSpace<Wood> actionSpace, GreenCard card) {
		super(actionSpace, card);
		
	}
	
	public GreenFloor(ActionSpace<Wood> actionSpace) {
		super(actionSpace);
		
	}

}
