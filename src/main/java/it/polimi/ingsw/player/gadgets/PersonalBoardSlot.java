package it.polimi.ingsw.player.gadgets;

import it.polimi.cards.*;
import it.polimi.ingsw.ps11.zones.Zone;

//e questo come lo implementiamo sulla personal board? booooo. ema
public class PersonalBoardSlot extends Zone {
	private DevelopmentCard developmentcard;
	
	public PersonalBoardSlot(){
		this.developmentcard = new PurpleCard();
	}

}
