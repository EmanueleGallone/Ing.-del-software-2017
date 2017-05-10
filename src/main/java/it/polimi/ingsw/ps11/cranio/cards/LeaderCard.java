package it.polimi.ingsw.ps11.cranio.cards;

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
