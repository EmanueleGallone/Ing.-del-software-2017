package it.polimi.ingsw.ps11.cranio.player;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.familyMember.*;
import it.polimi.ingsw.ps11.cranio.resources.*;
import it.polimi.ingsw.ps11.cranio.resources.list.Coin;
import it.polimi.ingsw.ps11.cranio.resources.list.FaithPoint;
import it.polimi.ingsw.ps11.cranio.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.cranio.resources.list.Servant;
import it.polimi.ingsw.ps11.cranio.resources.list.Stone;
import it.polimi.ingsw.ps11.cranio.resources.list.VictoryPoint;
import it.polimi.ingsw.ps11.cranio.resources.list.Wood;
import it.polimi.ingsw.ps11.cranio.cards.*;



public class Player{
	private static final String DEFAULT_NAME = "Predefinito";
		
	//private static int counter = 1; //per instanziare le posizioni dei giocatori
	
	private String name;
	
	private ResourceList resources;
	
	private BlackFamilyMember blackFamilyMember;
	private WhiteFamilyMember whiteFamilyMember;
	private NeutralFamilyMember neutralFamilyMember;
	private OrangeFamilyMember orangeFamilyMember;
	
	//ATTENZIONE: MAX 6 Carte per colore
	// farò più mazzi in base al colore
	private ArrayList<DevelopmentCard> mazzo = new ArrayList<DevelopmentCard>();
	
	
	public Player(){
		name = DEFAULT_NAME;
		
		resources = new ResourceList();		
		
		blackFamilyMember = new BlackFamilyMember(this);
		whiteFamilyMember = new WhiteFamilyMember(this);
		orangeFamilyMember = new OrangeFamilyMember(this);
		neutralFamilyMember = new NeutralFamilyMember(this);
	}
	
	public Player(String name){
		this(); //usa il costruttore sopra definito
		this.name = name;
	}
	
	

	

	public void addCard(DevelopmentCard card){
		this.mazzo.add(card);
		// System.out.println("Carta aggiunta al deck! "+ card); per debug
	}	
	
	
	
	//setters for family Member values
	
	public void setBlackFamilyMemberValue(int value){
		blackFamilyMember.setValue(value);
	}
	
	public void setWhiteFamilyMemberValue(int value){
		whiteFamilyMember.setValue(value);
	}
		
	public void setOrangeFamilyMemberValue(int value){
		orangeFamilyMember.setValue(value);
	}	
			
	public BlackFamilyMember getBlackFamilyMember() {
		return blackFamilyMember;
	}

	public WhiteFamilyMember getWhiteFamilyMember() {
		return whiteFamilyMember;
	}

	public NeutralFamilyMember getNeutralFamilyMember() {
		return neutralFamilyMember;
	}

	public OrangeFamilyMember getOrangeFamilyMember() {
		return orangeFamilyMember;
	}//end of family members setters

	
	//start of Resource setters and getters
	public ResourceList getResources(){
		return resources;
	}
	
	public int getStoneValue() {
		return resources.getStoneValue();
	}

	public int getWoodValue() {
		return resources.getWoodValue();
	}

	public int getCoinValue() {
		return resources.getCoinValue();
	}

	public int getServantValue() {
		return resources.getServantValue();
	}

	public void incrementStone(int value) {
		resources.getStone().increment(value);
	}

	public void incrementWood(int value) {
		resources.getWood().increment(value);
	}

	public void incrementCoin(int value) {
		resources.getCoin().increment(value);
	}

	public void incrementServant(int value) {
		resources.getServant().increment(value);
	}//end of Resource Setters and Getters
		
	//start of Points setters and getters
	public int getMilitaryPointsValue(){
		return resources.getMilitaryPointsValue();
	}
		
	public int getFaithPointsValue(){
		return resources.getFaithPointsValue();
	}
		
	public int getVictoryPointsValue(){
		return resources.getVictoryPointsValue();
	}
	
	public void incrementMilitaryPoints(int value){
		resources.getMilitaryPoint().increment(value);
	}
		
	public void incrementFaithPoints(int value){
		resources.getFaithPoint().increment(value);
	}
		
	public void incrementVictoryPoints(int value){
		resources.getVictoryPoint().increment(value);
	}//end of Points setters and getters
	
	
	public String getPlayerName(){ //TEMPORANEO. lo uso nei familyMember così da conoscere il proprietario. Da migliorare.
		return this.name;
	}
	

	
	
	
}//end of Class
