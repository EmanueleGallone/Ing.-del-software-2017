package it.polimi.ingsw.zones;

import java.util.ArrayList;

import it.polimi.cards.DevelopmentCard;
import it.polimi.ingsw.resources.Coin;
import it.polimi.ingsw.resources.FamilyMember;
import it.polimi.ingsw.resources.Resource;

public abstract class Tower extends Zone {
	//CLASSE DA RIVEDERE
	
	protected final static int MAX_CARDS_PER_TOWER = 4;
	
	protected final int fourthPosition = 7; //top card
	protected final int thirdPosition = 5;
	protected final int secondPosition = 3;
	protected final int firstPosition = 1; //bottom card
	
	protected ArrayList<ActionSpace> actionSpace;
	
	protected ArrayList<DevelopmentCard> cards; //le carte nella torre.
	
	protected Tower(){
		cards = new ArrayList<DevelopmentCard>();
		//slots = new FamilyMember[4];
		actionSpace = new ArrayList<ActionSpace>();
		//instanceActionSpace();
	}
	
	public void takeCard(int position, FamilyMember f){
		//DA MODIFICARE
		cards.set(position,null); //uso il set null in modo da evitare lo shifting
		actionSpace.get(position).setSlot(f); //inserisco il familiare nello spazio azione associato
		
	}
	
	public DevelopmentCard getCard(int number){
		return cards.get(number);
	}
	
	public boolean isOccupied(int position){
		
		return actionSpace.get(position).isOccupied();
	}
	
	protected void setOccupied(int position,FamilyMember familyChoice){
		
		actionSpace.get(position).setSlot(familyChoice);
	}
	
	/*private void instanceActionSpace(){
		//brutto questo metodo. si dovrebbe usare un ciclo.
		//bisogna che ogni torre instanzi questo metodo per conto suo -> abstract
		
		actionSpace.add(new ActionSpace()); //primo action Space
		actionSpace.add(new ActionSpace());
		actionSpace.add(new ActionSpace(new Coin(),1)); //ATTENZIONE. va settato il tipo di risorsa da prendere (vedi tabellone)
		actionSpace.add(new ActionSpace(new Coin(),2));
	}*/
	
	protected abstract void instanceActionSpace();
	
	private void printActionSpace(){
		for(ActionSpace a : actionSpace)
			System.out.println("ho questo in pancia " + a.getSlotFamilyMember()); //debug
	}
	
	public Resource getResourceActionSpace(int position){
		return actionSpace.get(position).getResource1();
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
	}

	// end of getters

}
