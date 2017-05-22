package it.polimi.ingsw.ps11.cranio.player;

import it.polimi.ingsw.ps11.cranio.cards.CardManager;
import it.polimi.ingsw.ps11.cranio.familyMember.BlackFamilyMember;
import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMemberManager;
import it.polimi.ingsw.ps11.cranio.familyMember.NeutralFamilyMember;
import it.polimi.ingsw.ps11.cranio.familyMember.OrangeFamilyMember;
import it.polimi.ingsw.ps11.cranio.familyMember.WhiteFamilyMember;
import it.polimi.ingsw.ps11.cranio.game.loaders.ResourceLoader;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;



public class Player{
	private static final String DEFAULT_NAME = "Predefinito";
	
	private String name;
	
	private ResourceList resourceList;
	private FamilyMemberManager familyManager;
	private CardManager cardManager;
	
	private ResourceLoader loader; //per caricare direttamente da file!
	
	//private int position; //io farei in modo che il player ha come stato la sua posizione. in modo tale da poter fare
							//ordinamento tramite comparator ad esempio
	
	
// Start constructors
	
	public Player(ResourceList resourceList, CardManager cardManager, FamilyMemberManager familyMemberManager){
		name = DEFAULT_NAME;
		
		this.resourceList = resourceList;
		this.cardManager = cardManager;
		this.familyManager = familyMemberManager;
		
	}
	
	public Player(ResourceList resourceList) {
		name = DEFAULT_NAME;
		
		this.resourceList = resourceList;
		this.cardManager = new CardManager(); //nessuna carta!
		this.familyManager = new FamilyMemberManager(this);
	}
	
	public Player(){
		//costruttore di default
		
		name = DEFAULT_NAME;
		//this.resourceList = new ResourceList();
		//this.resourceList.setAllToZeroValue();
		
		this.cardManager = new CardManager();
		this.familyManager = new FamilyMemberManager(this);
		
		this.loader = new ResourceLoader();
		this.resourceList = this.loader.load(); 
		
		
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
	public String toString() {
		return "Player [name=" + name 
				+"\n resourceList=" + resourceList +"\n"
				+"\n familyManager=" + familyManager +"\n"
				+ "\n cardManager=" + cardManager + "\n" 
				+ "]";
	}
	
	

	
}