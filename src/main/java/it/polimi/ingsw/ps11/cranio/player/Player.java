package it.polimi.ingsw.ps11.cranio.player;

import java.util.ArrayList;
import java.util.Arrays;

import it.polimi.ingsw.ps11.cranio.cards.CardManager;
import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMemberManager;
import it.polimi.ingsw.ps11.cranio.resources.*;
import it.polimi.ingsw.ps11.cranio.resources.list.*;



public class Player{
	
	private static final String DEFAULT_NAME = "Predefinito";
	private static final ArrayList<Resource> DEFAULT_RESOURCE = new ArrayList<>(Arrays.asList(new Wood(2),new Stone(2),new Servant(3),new Coin(5),new VictoryPoint(0),new FaithPoint(0),new MilitaryPoint(0)));	
	
	private String name;
	
	private ResourceList resourceList;
	private FamilyMemberManager familyManager;
	private CardManager cardManager;
	
// Start constructors
	
	public Player(){
		this(DEFAULT_RESOURCE);
	}
	
	public Player(ArrayList<Resource> resources ) {
		
		name = DEFAULT_NAME;
		
		this.resourceList = new ResourceList(resources);
		this.cardManager = new CardManager();
		this.familyManager = new FamilyMemberManager(this);
	}


// End constructors
	
// Start logic
	
	
// End logic
	
// Start getters
	
	public ResourceList getResourceList() {
		return resourceList;
	}
	
	public CardManager getCardManager() {
		return cardManager;
	}
	
	public FamilyMemberManager getFamilyManager() {
		return familyManager;
	}
	
	public String getName() {
		return name;
	}
	
// End getters
	
	public void setName(String name) {
		this.name = name;
	}

	
	@Override
	public Player clone(){
		try {
			return (Player) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public String toString() {
		return "Player [name=" + name 
				+"\n resourceList=" + resourceList +"\n"
				+"\n familyManager=" + familyManager +"\n"
				+ "\n cardManager=" + cardManager + "\n" 
				+ "]";
	}
}