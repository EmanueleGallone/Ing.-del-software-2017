package it.polimi.ingsw.ps11.cranio.player;

import it.polimi.ingsw.ps11.cranio.cards.CardManager;
import it.polimi.ingsw.ps11.cranio.familyMember.BlackFamilyMember;
import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMemberManager;
import it.polimi.ingsw.ps11.cranio.familyMember.NeutralFamilyMember;
import it.polimi.ingsw.ps11.cranio.familyMember.OrangeFamilyMember;
import it.polimi.ingsw.ps11.cranio.familyMember.WhiteFamilyMember;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;



public class Player{
	private static final String DEFAULT_NAME = "Predefinito";
	
	private String name;
	
	private ResourceList resourceList;
	private FamilyMemberManager familyManager;
	private CardManager cardManager;
	
	
// Start constructors
	
	public Player(ResourceList resourceList, CardManager cardManager, FamilyMemberManager familyMemberManager){
		name = DEFAULT_NAME;
		
		this.resourceList = resourceList;
		this.cardManager = cardManager;
		this.familyManager = familyMemberManager;
		
	}

// End constructors
	
// Start logic
	
	public void play(){
		
	}
	
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
	
// End getters
	
	public String getPlayerName(){ //TEMPORANEO. lo uso nei familyMember così da conoscere il proprietario. Da migliorare.
		return this.name;
	}

	
}