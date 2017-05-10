package it.polimi.ingsw.ps11.cranio.zones.floors;

import it.polimi.ingsw.ps11.cranio.cards.YellowCard;
import it.polimi.ingsw.ps11.cranio.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.cranio.zones.ActionSpace;
import it.polimi.ingsw.ps11.cranio.zones.Floor;

public class YellowFloor extends Floor<YellowCard,MilitaryPoint>{
	
	public YellowFloor(ActionSpace<MilitaryPoint> actionSpace) {
		super(actionSpace);		
	}
	
	public YellowFloor(ActionSpace<MilitaryPoint> actionSpace, YellowCard card){
		super(actionSpace, card);
	}

}
