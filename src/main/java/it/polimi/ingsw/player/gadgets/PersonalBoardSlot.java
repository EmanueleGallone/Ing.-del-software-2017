package it.polimi.ingsw.player.gadgets;

import it.polimi.cards.*;
import it.polimi.ingsw.ps11.zones.Zone;

public class PersonalBoardSlot extends Zone {
	private DevelopmentCard developmentcard;
	
	public PersonalBoardSlot(){
		this.developmentcard = new PurpleCard();
	}

}
