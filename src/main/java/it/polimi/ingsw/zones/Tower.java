package it.polimi.ingsw.zones;

import java.util.ArrayList;

import it.polimi.cards.DevelopmentCard;

public abstract class Tower extends Zone {
	protected final static int MAX_CARDS_PER_TOWER = 4;
	
	protected final int fourthPosition = 7; //top card
	protected final int thirdPosition = 5;
	protected final int secondPosition = 3;
	protected final int firstPosition = 1; //bottom card
	
	protected boolean fourtPositionOccupied = false;
	protected boolean thirdPositionOccupied = false;
	protected boolean secondPositionOccupied = false;
	protected boolean firstPositionOccupied = false;
	
	protected ArrayList<DevelopmentCard> cards;
	
	protected Tower(){
		cards = new ArrayList<>();
	}
	
	public void removeCard(int position){
		cards.set(position,null);
		setOccupied(position,true);
		
	}
	
	public DevelopmentCard getCard(int number){
		return cards.get(number);
	}
	
	public boolean isOccupied(int position) throws IllegalArgumentException{
		
		switch (position) {
		
		case 0:
			return firstPositionOccupied;
			
		case 1:
			return secondPositionOccupied;
			
		case 2:
			return thirdPositionOccupied;
			
		case 3:
			return fourtPositionOccupied;
			
		default:
			throw new IllegalArgumentException("Qualcosa è andato storto nel metodo \"is occupied\" ");
		
		}
	}
	
	private void setOccupied(int position,boolean value) throws IllegalArgumentException{
		
		switch (position) {
		
		case 0:
			firstPositionOccupied = value;
			break;			
		case 1:
			secondPositionOccupied = value;
			break;			
		case 2:
			thirdPositionOccupied = value;
			break;			
		case 3:
			fourtPositionOccupied = value;
			break;			
		default:
			throw new IllegalArgumentException("Qualcosa è andato storto nel metodo \"is occupied\" ");
		
		}
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
