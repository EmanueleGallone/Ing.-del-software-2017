package it.polimi.ingsw.zones;

import java.util.ArrayList;

import it.polimi.cards.DevelopmentCard;

public abstract class Tower extends Zone {
	protected final static int MAX_CARDS_PER_TOWER = 4;
	
	protected final int fourthPosition = 7; //top card
	protected final int thirdPosition = 5;
	protected final int secondPosition = 3;
	protected final int firstPosition = 1; //bottom card
	
	protected ArrayList<DevelopmentCard> cards;
	
	protected Tower(){
		cards = new ArrayList<>();
	}
	
	public void removeCard(int position){
		cards.set(position,null);
	}
	
	public DevelopmentCard getCard(int number){
		return cards.get(number);
	}
	
	//start of getters
	public int getFourthPositionValue() {
		return fourthPosition;
	}

	public int getThirdPositionValue() {
		return thirdPosition;
	}

	public int getSecondPositionValue() {
		return secondPosition;
	}

	public int getFirstPositionValue() {
		return firstPosition;
	}// end of getters

}
