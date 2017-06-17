package it.polimi.ingsw.ps11.model.cards.list;

import it.polimi.ingsw.ps11.model.cards.Card;

public class LeaderCard extends Card {
	private String name;
	
	public LeaderCard(String name){
		this.name=name;
		
	}

	@Override
	public String toString() {
		return "LeaderCard [name=" + name + "]";
	}

	@Override
	public Card clone() {
		//LeaderCard clone = new LeaderCard(this.name);
		return new LeaderCard(this.name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		
		if(this.getClass() == obj.getClass() && this.name.equalsIgnoreCase(((LeaderCard) obj).getName()))
				return true;
		
		return false;
	}
	

}
