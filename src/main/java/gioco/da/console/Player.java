package gioco.da.console;

import java.util.ArrayList;

import it.polimi.cards.DevelopmentCard;
import it.polimi.ingsw.dices.BlackDice;
import it.polimi.ingsw.dices.WhiteDice;
import it.polimi.ingsw.dices.YellowDice;
import it.polimi.ingsw.resources.BlackFamilyMember;
import it.polimi.ingsw.resources.Coin;
import it.polimi.ingsw.resources.NeutralFamilyMember;
import it.polimi.ingsw.resources.OrangeFamilyMember;
import it.polimi.ingsw.resources.Resource;
import it.polimi.ingsw.resources.Servant;
import it.polimi.ingsw.resources.Stone;
import it.polimi.ingsw.resources.WhiteFamilyMember;
import it.polimi.ingsw.resources.Wood;

public class Player{
	
	private String name;
	
	private Resource stone;
	private Resource wood;
	private Resource coin;
	private Resource servant;
	
	private int position;
	
	private BlackFamilyMember blackFamilyMember;
	private WhiteFamilyMember whiteFamilyMember;
	private NeutralFamilyMember neutralFamilyMember;
	private OrangeFamilyMember orangeFamilyMember;
	
	private ArrayList<DevelopmentCard> mazzo = new ArrayList<>();
	
	
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
		
		//i coin vanno scelti in base alla posizione
		
		
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
		
		stone.setValue(50); //per distinguere il constructor
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
				+ servant + ", position=" + position + ",\nblackFamilyMember=" + blackFamilyMember
				+ "\nwhiteFamilyMember=" + whiteFamilyMember + "\nneutralFamilyMember=" + neutralFamilyMember
				+ "\norangeFamilyMember=" + orangeFamilyMember + ",\nmazzo=" + mazzo + "}";
	}

	//setters for family Member values
	public void setBlackFamilyMemberValue(BlackDice d){
		blackFamilyMember.setValue(d.getValue());
	}
	
	public void setBlackFamilyMemberValue(int value){
		blackFamilyMember.setValue(value);
	}
	
	public void setWhiteFamilyMemberValue(WhiteDice d){
		whiteFamilyMember.setValue(d.getValue());
	}
	
	public void setWhiteFamilyMemberValue(int value){
		whiteFamilyMember.setValue(value);
	}
	
	public void setOrangeFamilyMemberValue(YellowDice d){
		orangeFamilyMember.setValue(d.getValue());
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

	public void addCard(DevelopmentCard card){
		this.mazzo.add(card);
		System.out.println("Carta aggiunta al deck! "+ card);
	}
	
	private void subResource(Resource type, int value) throws Exception{
		String error = "Errore! valori negativi non possibili";
		
		if(type instanceof Stone){
			if(this.stone.getValue() < value)
				throw new Exception (error);
			else
			this.stone.setValue(this.stone.getValue() - value);
		}
		
		if(type instanceof Wood){
			if(this.wood.getValue() < value)
				throw new Exception (error);
			else
			this.wood.setValue(this.wood.getValue() - value);
		}
		
		if(type instanceof Coin){
			if(this.coin.getValue() < value)
				throw new Exception (error);
			else
			this.coin.setValue(this.coin.getValue() - value);
		}
		
		if(type instanceof Servant){
			if(this.servant.getValue() < value)
				throw new Exception (error);
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
	

	
	
	
}
