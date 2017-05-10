package gioco.da.console.zones;

import java.util.ArrayList;

import gioco.da.console.cards.DevelopmentCard;
import gioco.da.console.resources.FamilyMember;
import gioco.da.console.resources.Resource;



public abstract class Tower extends Zone {
	//CLASSE DA RIVEDERE
	
	protected final static int MAX_CARDS_PER_TOWER = 4;//inutile al momento
	
	protected ArrayList<ActionSpace> actionSpace;
	
	protected ArrayList<DevelopmentCard> cards; //le carte nella torre.
	
	protected Tower(){
		cards = new ArrayList<DevelopmentCard>();
		actionSpace = new ArrayList<ActionSpace>();
	}
	
	protected abstract void instanceActionSpace(); //funzione che deve instanziare i 4 spazi azione all'interno delle torri
	
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
	
	
	
	
	private void printActionSpace(){
		for(ActionSpace a : actionSpace)
			System.out.println("ho questo in pancia " + a.getSlotFamilyMember()); //debug
	}
	
	public Resource getResourceActionSpace(int position){
		return actionSpace.get(position).getResource1();
	}
	
	
	
	//start of getters
	public int getFourthPositionValue() {
		return actionSpace.get(3).getValue();
	}
	

	public int getThirdPositionValue() {
		return actionSpace.get(2).getValue();
	}

	public int getSecondPositionValue() {
		return actionSpace.get(1).getValue();
	}

	public int getFirstPositionValue() {
		return actionSpace.get(0).getValue();
	}

	// end of getters

}