package provaGab.cranio.player;

import java.lang.reflect.Modifier;

import provaGab.cranio.cards.BlueCard;
import provaGab.cranio.cards.CardManager;
import provaGab.cranio.cards.Deck;
import provaGab.cranio.cards.GreenCard;
import provaGab.cranio.cards.PurpleCard;
import provaGab.cranio.cards.YellowCard;
import provaGab.cranio.familyMember.BlackFamilyMember;
import provaGab.cranio.familyMember.FamilyMember;
import provaGab.cranio.familyMember.FamilyMemberManager;
import provaGab.cranio.familyMember.NeutralFamilyMember;
import provaGab.cranio.familyMember.OrangeFamilyMember;
import provaGab.cranio.familyMember.WhiteFamilyMember;
import provaGab.cranio.resources.ResourceList;
import provaGab.cranio.zones.Floor;

public class Player{
	private static final String DEFAULT_NAME = "Predefinito";
	
	private String name;
	
	private ResourceList resourceList;
	private FamilyMemberManager familyManager;
	private CardManager cardManager;
	private int[] familyMemberBonusList = {0, 0, 0, 0}; 
	
	
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
	
//getter for family Member
	
	public int getFamilyMemberBonus(int i){			//1=green, 2=yellow, 3=blue, 4=purple, ritorna il bonus sul tipo di carta
		return familyMemberBonusList[i-1];
	}
	
	public void setFamilyMemberBonus(int i, int j){		//setta il bonus sul tipo di carta (quale tipo di carta, di quanto)
		familyMemberBonusList[i-1] = j;
	}
	
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
	
	public void placeMember(FamilyMember familyMember, Floor floor){
		int modifier = familyMemberBonusList[floor.getCard().getId()- 1];
		floor.placeFamilyMember(familyMember, modifier);
	}
	
	
	
}//end of Class
