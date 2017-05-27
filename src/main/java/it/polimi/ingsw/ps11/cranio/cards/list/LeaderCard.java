package it.polimi.ingsw.ps11.cranio.cards.list;

import it.polimi.ingsw.ps11.cranio.cards.Card;

public class LeaderCard extends Card {
	private String name;
	
	public LeaderCard(String name){
		this.name=name;
		
	}

	@Override
	public String toString() {
		return "LeaderCard [name=" + name + "]";
	}
	

}
