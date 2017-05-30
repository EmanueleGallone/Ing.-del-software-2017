package it.polimi.ingsw.ps11.cranio.malus;

import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.player.Player;

public class TakeNoPointsFromCard<T extends DevelopmentCard> {
	
	private Player owner;
	private T cardType;
	
	public TakeNoPointsFromCard() {
		
	}
	
	
	public void behaviour(){
		
	}
	
	
	
	public Player getOwner() {
		return owner;
	}
	
	public void setOwner(Player owner) {
		this.owner = owner;
	}

}
