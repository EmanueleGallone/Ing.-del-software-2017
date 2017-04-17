package it.polimi.cards;

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
