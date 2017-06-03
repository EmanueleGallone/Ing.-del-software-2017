package it.polimi.ingsw.ps11.cranio.player;

import java.util.ArrayList;
import java.util.Arrays;

import it.polimi.ingsw.ps11.cranio.cards.CardManager;
import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMemberManager;
import it.polimi.ingsw.ps11.cranio.game.Colors;
import it.polimi.ingsw.ps11.cranio.resources.Resource;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.resources.list.Coin;
import it.polimi.ingsw.ps11.cranio.resources.list.FaithPoint;
import it.polimi.ingsw.ps11.cranio.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.cranio.resources.list.Servant;
import it.polimi.ingsw.ps11.cranio.resources.list.Stone;
import it.polimi.ingsw.ps11.cranio.resources.list.VictoryPoint;
import it.polimi.ingsw.ps11.cranio.resources.list.Wood;



public class Player{
	
	private static final String DEFAULT_NAME = "Predefinito";
	
	private String name;
	private Colors color;
	
	private ResourceList resourceList;
	private FamilyMemberManager familyManager;
	private CardManager cardManager;
	
// Start constructors
	
	public Player(){
		name = DEFAULT_NAME;
		this.resourceList = new ResourceList();
		this.cardManager = new CardManager();
		this.familyManager = new FamilyMemberManager(this);
	}
	
	public Player( ArrayList<Resource> resources ) {
		
		name = DEFAULT_NAME;
		
		this.resourceList = new ResourceList(resources);
		this.cardManager = new CardManager();
		this.familyManager = new FamilyMemberManager(this);
	}

	
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
	
	public Colors getColor() {
		return color;
	}
	
// End getters
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setColor(Colors color) {
		this.color = color;
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
	public boolean equals(Object obj) {
		//Da decidere se basta solo il colore
		if(obj.getClass() == this.getClass()){
			return(((Player)obj).getColor() == this.getColor());
		}
		return false;
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