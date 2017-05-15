package it.polimi.ingsw.ps11.cranio.player;

import it.polimi.ingsw.ps11.cranio.cards.BlueCard;
import it.polimi.ingsw.ps11.cranio.cards.CardManager;
import it.polimi.ingsw.ps11.cranio.cards.Deck;
import it.polimi.ingsw.ps11.cranio.cards.GreenCard;
import it.polimi.ingsw.ps11.cranio.cards.PurpleCard;
import it.polimi.ingsw.ps11.cranio.cards.YellowCard;
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
	
	public Player(){
		name = DEFAULT_NAME;
		
		resourceList = new ResourceList();	
		familyManager = new FamilyMemberManager(this);
		cardManager = new CardManager();
		
	}
	
	public Player(String name){
		this(); //usa il costruttore sopra definito
		this.name = name;
	}

// End constructors
	
// Start logic
	
	public void play(){
		
	}
	
// End logic
	
//getter for family Member
	public BlackFamilyMember getBlackFamilyMember() {
		return familyManager.getBlackFamilyMember();
	}

	public WhiteFamilyMember getWhiteFamilyMember() {
		return familyManager.getWhiteFamilyMember();
	}

	public NeutralFamilyMember getNeutralFamilyMember() {
		return familyManager.getNeutralFamilyMember();
	}

	public OrangeFamilyMember getOrangeFamilyMember() {
		return familyManager.getOrangeFamilyMember();
	}
//end of family members getters

	
//start of Resource setters and getters
	public ResourceList getResources(){
		return resourceList;
	}
	
	public int getStoneValue() {
		return resourceList.getStoneValue();
	}

	public int getWoodValue() {
		return resourceList.getWoodValue();
	}

	public int getCoinValue() {
		return resourceList.getCoinValue();
	}

	public int getServantValue() {
		return resourceList.getServantValue();
	}

	public void incrementStone(int value) {
		resourceList.getStone().increment(value);
	}

	public void incrementWood(int value) {
		resourceList.getWood().increment(value);
	}

	public void incrementCoin(int value) {
		resourceList.getCoin().increment(value);
	}

	public void incrementServant(int value) {
		resourceList.getServant().increment(value);
	}
//end of Resource Setters and Getters
		
//start of Points setters and getters
	public int getMilitaryPointsValue(){
		return resourceList.getMilitaryPointsValue();
	}
		
	public int getFaithPointsValue(){
		return resourceList.getFaithPointsValue();
	}
		
	public int getVictoryPointsValue(){
		return resourceList.getVictoryPointsValue();
	}
	
	public void incrementMilitaryPoints(int value){
		resourceList.getMilitaryPoint().increment(value);
	}
		
	public void incrementFaithPoints(int value){
		resourceList.getFaithPoint().increment(value);
	}
		
	public void incrementVictoryPoints(int value){
		resourceList.getVictoryPoint().increment(value);
	}
//end of Points setters and getters
	
//start of decks getters
	public CardManager getCardManager() {
		return cardManager;
	}
	
	public Deck<PurpleCard> getPurpleDeck() {
		return cardManager.getPurpleDeck();
	}
	
	public Deck<GreenCard> getGreenDeck() {
		return cardManager.getGreenDeck();
	}
	
	public Deck<YellowCard> getYellowDeck() {
		return cardManager.getYellowDeck();
	}
	
	public Deck<BlueCard> getBlueDeck() {
		return cardManager.getBlueDeck();
	}
//end of decks getters
	
	
	public String getPlayerName(){ //TEMPORANEO. lo uso nei familyMember così da conoscere il proprietario. Da migliorare.
		return this.name;
	}
	

	
	
	
}//end of Class
