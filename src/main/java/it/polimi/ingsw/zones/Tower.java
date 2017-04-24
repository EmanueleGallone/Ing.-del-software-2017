package it.polimi.ingsw.zones;

import java.util.ArrayList;

import it.polimi.cards.DevelopmentCard;

public abstract class Tower extends Zone {
	
	protected ArrayList<DevelopmentCard> cards;
	
	protected Tower(){
		cards = new ArrayList<>();
	}

}
