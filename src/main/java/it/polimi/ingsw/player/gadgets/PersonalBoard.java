package it.polimi.ingsw.player.gadgets;

import java.util.ArrayList;
import java.util.Arrays;

import it.polimi.cards.*;
import it.polimi.ingsw.resources.*;

public class PersonalBoard {
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
	//usando magari ArrayList e poi mettendo il controllo che questi ArrayList non possano sforare i 6 elementi.
	protected YellowCard[] yellowcard;
	protected ArrayList<BlueCard> bluecard;
	protected ArrayList<PurpleCard> purplecard;
	protected GreenCard[] greencard;
	
	//da istanziare
	protected FamilyMember[] familyMember;
	
	//protected PersonalBoardSlot boardSlot; ancora da capire come implementare
	
	public PersonalBoard(){
		
		militarypoint = new MilitaryPoint();
		victorypoint = new VictoryPoint();
		faithpoint = new FaithPoint();
		
		yellowcard = new YellowCard[DevelopmentCard.MAX_YELLOW_CARDS];
		greencard = new GreenCard[DevelopmentCard.MAX_GREEN_CARDS];
		bluecard = new ArrayList<BlueCard>();
		purplecard = new ArrayList<PurpleCard>();
		
		coin = new Coin();
		wood = new Wood();
		stone = new Stone();
		servant = new Servant();
		
		familyMember = new FamilyMember[FamilyMember.MAX_FAMILY_MEMBERS_PER_PLAYER];
	}
	
	public void addDevelopmentCard(DevelopmentCard card) throws Exception{
		
		//distinguish between different type of cards
		
		if(card instanceof YellowCard) {
			
			if(numberOfYellowCard > DevelopmentCard.MAX_YELLOW_CARDS)
				throw new Exception("HAI RAGGIUNTO IL LIMITE DI CARTE PER IL COLORE GIALLO!");
			
			this.yellowcard[numberOfYellowCard]=new YellowCard();
			this.numberOfYellowCard++;
			
		}
		
		if(card instanceof BlueCard) {
			
			this.bluecard.add(new BlueCard());
		}
		
		if(card instanceof PurpleCard) {
			
			this.purplecard.add(new PurpleCard());
		}
		
		if(card instanceof GreenCard) {
			
			if(numberOfGreenCard > DevelopmentCard.MAX_GREEN_CARDS)
				throw new Exception("HAI RAGGIUNTO IL LIMITE DI CARTE PER IL COLORE VERDE!");
			
			this.greencard[numberOfGreenCard] = new GreenCard();
			this.numberOfGreenCard++;
		}
		
	}//end of addDevelopmentCard()

	@Override
	public String toString() {
		return "PersonalBoard [numberOfYellowCard=" + numberOfYellowCard + ", numberOfGreenCard=" + numberOfGreenCard
				+ ",\n PLAYER RESOURCES: coin=" + coin + ", wood=" + wood + ", stone=" + stone + ", servant=" + servant + ",\n PLAYER POINTS: militarypoint="
				+ militarypoint + ", faithpoint=" + faithpoint + ", victorypoint=" + victorypoint + ",\n yellowcard="
				+ Arrays.toString(yellowcard) + ",\n bluecard=" + bluecard + ",\n purplecard=" + purplecard + ",\n greencard="
				+ Arrays.toString(greencard) + ",\n familyMember=" + Arrays.toString(familyMember) + "]";
	}
	
	
	
	

}
