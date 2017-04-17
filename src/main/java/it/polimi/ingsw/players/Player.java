package it.polimi.ingsw.players;

import java.util.ArrayList;

import it.polimi.cards.*;
import it.polimi.ingsw.player.gadgets.PersonalBoard;
import it.polimi.ingsw.resources.*;

public abstract class Player {

	protected int position; //indicates the starting position between players when a new turn arrives. devo ancora capire come implementare
	protected PersonalBoard personalboard;
	
	public Player(){
		personalboard = new PersonalBoard();
	}
	
	public abstract PersonalBoard getPersonalBoard();
	
	
	
	
	
	//vecchia implementazione. Le risorse le assegnavo al giocatore. Molto piu semplice dal mio punto di vista.
	//visto che alla fine la personal board serve solo in veste "grafica". Pensavo che sulla GUI si potesse creare una personal board e poi
	//mostrare gli oggetti che il giocatore ha semplicemente passando il riferimento a quel determinato oggetto.
	//metto in commento perche provo ad attenermi al modello UML.
	/*protected Resource coin;
	protected Resource wood;
	protected Resource stone;
	protected Resource servant;
	
	protected MilitaryPoint militarypoint;
	protected FaithPoint faithpoint;
	protected VictoryPoint victorypoint;
	
	protected YellowCard[] yellowcard;
	protected ArrayList<BlueCard> bluecard;
	protected ArrayList<PurpleCard> purplecard;
	protected GreenCard[] greencard;
	
	protected FamilyMember[] familyMember;
	
	//the super constructor for every new player
	protected Player(){
		
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
	
	


	public abstract String toString();
	public abstract void addDevelopmentCard(DevelopmentCard card) throws Exception;
	public abstract void removeDevelopmentCard() throws Exception; */
}
