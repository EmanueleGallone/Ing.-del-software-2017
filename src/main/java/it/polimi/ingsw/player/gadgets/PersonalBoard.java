package it.polimi.ingsw.player.gadgets;

import java.util.ArrayList;
import java.util.Arrays;

import it.polimi.cards.*;
import it.polimi.ingsw.resources.*;

public class PersonalBoard {
	protected static final int MAX_YELLOW_CARDS=6;
	protected static final int MAX_GREEN_CARDS=6;
	protected static final int MAX_FAMILY_MEMBERS_PER_PLAYER = 4;
	private int numberOfYellowCard;
	private int numberOfGreenCard;
	
	protected Resource coin;
	protected Resource wood;
	protected Resource stone;
	protected Resource servant;
	
	protected MilitaryPoint militarypoint;
	protected FaithPoint faithpoint;
	protected VictoryPoint victorypoint;
	
	//per le carte gialle e verdi uso un Array normale visto che ne possiamo avere al max 6; pensavo di modificare e rendere tutto uniforme
	//usando magari ArrayList e poi mettendo il controllo che questi ArrayList non possano sforare i 6 elementi. Lo farò dopo nel caso. ema
	protected YellowCard[] yellowcard;
	protected ArrayList<BlueCard> bluecard;
	protected ArrayList<PurpleCard> purplecard;
	protected GreenCard[] greencard;
	
	protected FamilyMember[] familyMember;
	
	//protected PersonalBoardSlot boardSlot; ancora da capire come implementare. ema
	
	public PersonalBoard(){
		
		militarypoint = new MilitaryPoint();
		victorypoint = new VictoryPoint();
		faithpoint = new FaithPoint();
		
		yellowcard = new YellowCard[MAX_YELLOW_CARDS];
		greencard = new GreenCard[MAX_GREEN_CARDS];
		bluecard = new ArrayList<>();
		purplecard = new ArrayList<>();
		
		coin = new Coin();
		wood = new Wood();
		stone = new Stone();
		servant = new Servant();
		
		// non son convinto che sia una buona soluzione l'array di familiari. Però per ora vado avanti così. ema
		familyMember = new FamilyMember[MAX_FAMILY_MEMBERS_PER_PLAYER];
		familyMember[0] = new BlackFamilyMember();
		familyMember[1] = new WhiteFamilyMember();
		familyMember[2] = new OrangeFamilyMember();
		familyMember[3] = new NeutralFamilyMember();
	}
	
	public void addDevelopmentCard(DevelopmentCard card) throws Exception{
		//sarebbe meglio cambiare Exception e mettere una eccezione più specifica (più generica di così, si muore). ema
		
		//distinguish between different type of cards
		
		if(card instanceof YellowCard) {
			
			if(numberOfYellowCard > MAX_YELLOW_CARDS)
				throw new Exception("HAI RAGGIUNTO IL LIMITE DI CARTE PER IL COLORE GIALLO!");
			
			this.yellowcard[numberOfYellowCard]=(YellowCard)card;
			this.numberOfYellowCard++;
			
		}
		
		if(card instanceof BlueCard) {
			
			this.bluecard.add((BlueCard)card);
		}
		
		if(card instanceof PurpleCard) {
			
			this.purplecard.add((PurpleCard)card);
		}
		
		if(card instanceof GreenCard) {
			
			if(numberOfGreenCard > MAX_GREEN_CARDS)
				throw new Exception("HAI RAGGIUNTO IL LIMITE DI CARTE PER IL COLORE VERDE!");
			
			this.greencard[numberOfGreenCard] = (GreenCard)card;
			this.numberOfGreenCard++;
		}
		
	}//end of addDevelopmentCard()
	
	//change the wished type of resource (increment and decrement, depends on value!)
	public void changeResource(Resource resource,int value){
		int temp = 0;
		
		if(resource instanceof Coin){
			temp = this.coin.getValue();
			this.coin.setValue(value + temp);
		}
		
		if(resource instanceof Wood){
			temp = this.wood.getValue();
			this.wood.setValue(value+temp);
		}
		
		if(resource instanceof Stone){
			temp = this.stone.getValue();
			this.stone.setValue(value + temp);
		}
		
		if(resource instanceof Servant){
			temp = this.servant.getValue();
			this.servant.setValue(value + temp);
		}
		
	}// end of changeResource
	
	
	/* //method needed to update the values of the family members when a new turn arrives
	public void updateFamilyMemberValues(){
		for(int i = 0; i<FamilyMember.MAX_FAMILY_MEMBERS_PER_PLAYER;i++)
			 familyMember[i].setValue(); //va scelto con cautela se mettere i dadi static in modo che siano leggibili a tutti
											//o come fare per implementare l'update (magari da server, non so). ema
		
		//ATTENZIONE: sto provando ad implementare un metodo per ogni family member "updateValue" così sposto il problema a loro
		//e poi mi basta fare un semplice familyMember[i].updateValue() ;) ema
		
	}// end updateFamilyMemberValues */
	
	
	@Override
	public String toString() {
		return "PersonalBoard [numberOfYellowCard=" + numberOfYellowCard + ", numberOfGreenCard=" + numberOfGreenCard
				+ ",\n PLAYER RESOURCES: coin=" + coin + ", wood=" + wood + ", stone=" + stone + ", servant=" + servant + ",\n PLAYER POINTS: militarypoint="
				+ militarypoint + ", faithpoint=" + faithpoint + ", victorypoint=" + victorypoint + ",\n yellowcard="
				+ Arrays.toString(yellowcard) + ",\n bluecard=" + bluecard + ",\n purplecard=" + purplecard + ",\n greencard="
				+ Arrays.toString(greencard) + ",\n familyMember=" + Arrays.toString(familyMember) + "]";
	}
	
	
	
	
	

}