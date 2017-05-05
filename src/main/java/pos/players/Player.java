package pos.players;

import pos.cards.CartsManager;
import pos.familyMembers.FamilyMembersManager;

public class Player {

	private static final String NOME_PREDEFINITO = "Unknown";
	
	String name;
	
	ResourceList resourceList;
	CartsManager cartsManager = new CartsManager();
	FamilyMembersManager familyMembersManager;
	
	public Player() {
		this(NOME_PREDEFINITO);
	}
	
	public Player(String name) {
		this.name = name;
		resourceList = new ResourceList();
	}
	
	
	public ResourceList getResourceList() {
		return resourceList;
	}
	
	public CartsManager getCartsManager() {
		return cartsManager;
	}
	
}
