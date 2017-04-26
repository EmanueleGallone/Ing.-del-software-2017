package gioco.da.console;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

import it.polimi.cards.DevelopmentCard;
import it.polimi.ingsw.resources.BlackFamilyMember;
import it.polimi.ingsw.resources.Coin;
import it.polimi.ingsw.resources.FaithPoint;
import it.polimi.ingsw.resources.FamilyMember;
import it.polimi.ingsw.resources.MilitaryPoint;
import it.polimi.ingsw.resources.NeutralFamilyMember;
import it.polimi.ingsw.resources.OrangeFamilyMember;
import it.polimi.ingsw.resources.Resource;
import it.polimi.ingsw.resources.Servant;
import it.polimi.ingsw.resources.Stone;
import it.polimi.ingsw.resources.VictoryPoint;
import it.polimi.ingsw.resources.WhiteFamilyMember;
import it.polimi.ingsw.resources.Wood;

public class Player implements Comparator<Player>, Comparable<Player>{
	
	private static int counter = 1; //per instanziare le posizioni dei giocatori
	
	private String name;
	
	private Resource stone;
	private Resource wood;
	private Resource coin;
	private Resource servant;
	
	private VictoryPoint victoryPoint;
	private MilitaryPoint militaryPoint;
	private FaithPoint faithPoint;
	
	private int position = 1;
	
	private BlackFamilyMember blackFamilyMember;
	private WhiteFamilyMember whiteFamilyMember;
	private NeutralFamilyMember neutralFamilyMember;
	private OrangeFamilyMember orangeFamilyMember;
	
	private ArrayList<DevelopmentCard> mazzo = new ArrayList<DevelopmentCard>();
	
	
	public Player(){
		name = "MarioRossi";
		stone = new Stone();
		wood = new Wood();
		coin = new Coin();
		servant = new Servant();
		
		stone.setValue(5);
		wood.setValue(5);
		servant.setValue(5);
		coin.setValue(5);
		
		position = manageCounter();
		
		militaryPoint.setValue(0);
		victoryPoint.setValue(0);
		faithPoint.setValue(0);
		
		//i coin vanno scelti in base alla posizione. potrei aggiungerli successivamente oppure fare un check sulla posizione.		
		
		blackFamilyMember = new BlackFamilyMember();
		whiteFamilyMember = new WhiteFamilyMember();
		orangeFamilyMember = new OrangeFamilyMember();
		neutralFamilyMember = new NeutralFamilyMember();
	}
	
	public Player(String name){
		this.name = name;
		stone = new Stone();
		wood = new Wood();
		coin = new Coin();
		servant = new Servant();
		
		position = manageCounter();
		
		stone.setValue(5);
		wood.setValue(5);
		servant.setValue(5);
		coin.setValue(5);
		
		//i coin vanno scelti in base alla posizione
		
		blackFamilyMember = new BlackFamilyMember();
		whiteFamilyMember = new WhiteFamilyMember();
		orangeFamilyMember = new OrangeFamilyMember();
		neutralFamilyMember = new NeutralFamilyMember();
	}
	
	@Override
	public String toString() {
		return "Player {name=" + name + "\nstone=" + stone + "\nwood=" + wood + "\ncoin=" + coin + "\nservant="
				+ servant + "\nposition=" + position + ",\nblackFamilyMember=" + blackFamilyMember
				+ "\nwhiteFamilyMember=" + whiteFamilyMember + "\nneutralFamilyMember=" + neutralFamilyMember
				+ "\norangeFamilyMember=" + orangeFamilyMember + ",\nmazzo=" + mazzo + "}";
	}

	

	public void addCard(DevelopmentCard card){
		this.mazzo.add(card);
		// System.out.println("Carta aggiunta al deck! "+ card); //non so se serva realmente.
	}
	
	private void subResource(Resource type, int value) throws IllegalArgumentException{
		String error = "Errore! valori negativi non possibili";
		
		if(type instanceof Stone){
			if(this.stone.getValue() < value)
				throw new IllegalArgumentException (error);
			else
			this.stone.setValue(this.stone.getValue() - value);
		}
		
		if(type instanceof Wood){
			if(this.wood.getValue() < value)
				throw new IllegalArgumentException (error);
			else
			this.wood.setValue(this.wood.getValue() - value);
		}
		
		if(type instanceof Coin){
			if(this.coin.getValue() < value)
				throw new IllegalArgumentException (error);
			else
			this.coin.setValue(this.coin.getValue() - value);
		}
		
		if(type instanceof Servant){
			if(this.servant.getValue() < value)
				throw new IllegalArgumentException (error);
			else
			this.servant.setValue(this.servant.getValue() - value);
		}
	}//end of subResource
		
	private void addResource(Resource type, int value){
		
		if(type instanceof Stone){
			this.stone.setValue(this.stone.getValue() + value);
		}
		
		if(type instanceof Wood){
			this.wood.setValue(this.wood.getValue() + value);
		}
		
		if(type instanceof Coin){
			this.coin.setValue(this.coin.getValue() + value);
		}
		
		if(type instanceof Servant){
			this.servant.setValue(this.servant.getValue() + value);
		}
			
	}//end of addResource()
	
	public void changeResourceValue(Resource type, int value){
		if(value <= 0)
			try {
				subResource(type,value);
			} catch (Exception e) {
				e.getMessage();
				e.printStackTrace();
			}
		
		if(value > 0){
			addResource(type,value);
		}
		
	}
	
	public void printDeck(){
		System.out.println("stampa mazzo completo: " + mazzo.toString());
	}
	
	//use servant for increasing value of family Member
	public void useServant(int value) throws IllegalArgumentException{
		if(value > this.servant.getValue())
			throw new IllegalArgumentException ("Hai superato il numero consentito di servitori!");
		else
			this.servant.setValue(this.servant.getValue() - value);
	}

	@Override
	public int compareTo(Player o) { //dovuto a Comparator
		return this.position - o.position;
	}

	@Override
	public int compare(Player o1, Player o2) { //dovuto a Comparable
		//inutilizzato al momento. ho intenzione di usarlo magari nella verifica finale di chi ha vinto
		return 0;
	}
	
	private int manageCounter(){
		if ( counter == 4)
			counter = 1;
		
		return counter++;
	}
	
	public boolean allFamilyisUsed(){

		int countIsUsed = 0;

		if(blackFamilyMember.IsUsed())
			countIsUsed++;
		
		if(whiteFamilyMember.IsUsed())
			countIsUsed++;
		
		if(neutralFamilyMember.IsUsed())
			countIsUsed++;
		
		if(orangeFamilyMember.IsUsed())
			countIsUsed++;		
		
		if(countIsUsed == 4)
			return true;
		
		
		return false;
		
	}// end of allFamilyisUsed
	
	public FamilyMember familiarChoice(){
		
		FamilyMember familyChoice = new BlackFamilyMember(); //inizializzo per problemi del compiler
		Scanner in;
		int temp = 1;
		boolean retry = true;
		String alert = "Attenzione! familiare già usato!";
		
		while (retry){
			boolean checkExc = false;
			
			while(!checkExc){ // scelta familiare
				
				System.out.println("Quale familiare vuoi usare?");
				System.out.println("1. Nero (Valore: " + this.blackFamilyMember.getValue() + ")");
				System.out.println("2. Arancione (Valore: " + this.orangeFamilyMember.getValue() + ")");
				System.out.println("3. Neutro (Valore 0)");
				System.out.println("4. Bianco (Valore: " + this.whiteFamilyMember.getValue() + ")");
				
				try {
					in = new Scanner(System.in);
					temp = in.nextInt();
					checkExc = true;
					
				} catch (InputMismatchException e) {
					System.err.println("Errore nella selezione! riprova\n");
				}
				
			}
			
			switch (temp) {
			
			case 1:
				
				familyChoice = new BlackFamilyMember();
				familyChoice.setValue(this.blackFamilyMember.getValue());
				familyChoice.setIsUsed(this.blackFamilyMember.IsUsed());
				
				if(familyChoice.IsUsed())
					System.err.println(alert);
				
				this.blackFamilyMember.setIsUsed(true); //dico che il familiare del giocatore è stato usato
				
				break;
				
			case 2:
				familyChoice = new OrangeFamilyMember();
				familyChoice.setValue(this.orangeFamilyMember.getValue());
				familyChoice.setIsUsed(this.orangeFamilyMember.IsUsed());
				
				if(familyChoice.IsUsed())
					System.err.println(alert);
				
				this.orangeFamilyMember.setIsUsed(true);
				
				break;
				
			case 3:
				familyChoice = new NeutralFamilyMember();
				familyChoice.setValue(this.neutralFamilyMember.getValue());
				familyChoice.setIsUsed(this.neutralFamilyMember.IsUsed());
				
				if(familyChoice.IsUsed())
					System.err.println(alert);
				
				this.neutralFamilyMember.setIsUsed(true);
				
				break;
				
			case 4:
				familyChoice = new WhiteFamilyMember();
				familyChoice.setValue(this.whiteFamilyMember.getValue());
				familyChoice.setIsUsed(this.whiteFamilyMember.IsUsed());
				
				if(familyChoice.IsUsed())
					System.err.println(alert);
				
				this.whiteFamilyMember.setIsUsed(true);
				
				break;

			default:
				System.err.println("Qualcosa è andato storto nella scelta del familiare!");
				break;
			} //fine statement per scelta familiare
			
			if((temp <= 4) && (temp >= 1) && !familyChoice.IsUsed()) //check condition per l'uscita dal ciclo
				retry = false;				
			
		}// end of while(retry)
		
		return familyChoice; //ritorno una copia del familiare del giocatore! vorrei usare una clone all'interno di questo metodo così da smaltire codice
		
	}//end of familiarChoice()
	
	
	
	
	
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

		public int getPosition(){
			return this.position;
		}
		
		public void setPosition(int position){
			this.position = position;
		}	
		//start of Resource setters and getters
		public int getStone() {
			return stone.getValue();
		}

		public int getWood() {
			return wood.getValue();
		}

		public int getCoin() {
			return coin.getValue();
		}

		public int getServant() {
			return servant.getValue();
		}

		public void setStone(int value) {
			this.stone.setValue(value);
		}

		public void setWood(int value) {
			this.wood.setValue(value);
		}

		public void setCoin(int value) {
			this.coin.setValue(value);
		}

		public void setServant(int value) {
			this.servant.setValue(value);
		}//end of Resource Setters and Getters
	

	
	
	
}
