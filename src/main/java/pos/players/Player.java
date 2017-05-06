package pos.players;

import java.util.ArrayList;

import pos.cards.Card;
import pos.cards.Cards;
import pos.cards.CardsManager;
import pos.familyMembers.FamilyMembersManager;
import pos.resources.Resource;
import pos.resources.ResourceList;
import pos.resources.Resources;

public class Player {

	private static final String NOME_PREDEFINITO = "Unknown";
	
	String name;
	
	ResourceList resourceList;
	CardsManager cartsManager = new CardsManager();
	FamilyMembersManager familyMembersManager;
	
//Start constructor
	
	public Player() {
		this(NOME_PREDEFINITO);
	}
	
	public Player(String name) {
		this.name = name;
		resourceList = new ResourceList();
	}
	
//End constructor
//Start getters
	public String getName() {
		return name;
	}
	public ResourceList getResourceList() {
		return resourceList;
	}
	
	public CardsManager getCartsManager() {
		return cartsManager;
	}
	public FamilyMembersManager getFamilyMembersManager() {
		return familyMembersManager;
	}
	
	//Start getter di supporto: Sono getter non necessari ma utili per abbreviare il percorso
	
	public ArrayList<Card> getCardsByType(Cards type) {
		return cartsManager.getCardsByType(type);
	}
	public Card getCardByName(String name){
		return cartsManager.getCardByName(name);
	}
	public Resource getResource(Resources whichResource){
		return	this.resourceList.getResource(whichResource);
	}
	public int getValueOf(Resources whichResource){
		return resourceList.getValueOf(whichResource);
	}
	
	//End getter di supporto
//End getters
//Start setters
	public void setName(String name) {
		this.name = name;
	}
	
	//Start setters di supporto: Sono setter non necessari ma utili per abbreviare il percorso
	
	public boolean addCard(Card card){
		return cartsManager.addCard(card);
	}
	
	public void incrementResource(Resources whichResource,int value){
		this.resourceList.getResource(whichResource).increment(value);
	}
	
	//End setters di supporto
//End setters

	
}
