package it.polimi.ingsw.players;

import java.util.ArrayList;

import it.polimi.cards.*;
import it.polimi.ingsw.player.gadgets.PersonalBoard;
import it.polimi.ingsw.resources.*;

public abstract class Player {

	protected int position; //indicates the starting position between players when a new turn arrives. devo ancora capire come implementare
	protected PersonalBoard personalboard;
	
	public Player(){
		personalboard = new PersonalBoard();
	}
	
	public abstract PersonalBoard getPersonalBoard();
	
}
