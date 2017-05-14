package provaGab.cranio;

import provaGab.cranio.cards.PurpleCard;
import provaGab.cranio.familyMember.BlackFamilyMember;
import provaGab.cranio.familyMember.FamilyMember;
import provaGab.cranio.player.Player;
import provaGab.cranio.zones.ActionSpace;
import provaGab.cranio.zones.Floor;

public class Main {
	
	
	public static void main(String[] args) {
		
	Player P1 = new Player();										//giocatore1
	PurpleCard purpleCard = new PurpleCard();						//carta con id = 4
	ActionSpace actionSpace = new ActionSpace(1);					//actionSpace con costo 1
	BlackFamilyMember familyMember = new BlackFamilyMember(P1);		//familiare nero di P1 con valore di base 0
	Floor f1 = new Floor(actionSpace, purpleCard);					//associo carta e actionSpace
	P1.placeMember(familyMember, f1);								//P1 prova a mettere il suo famigliare di valore 0 sull'actionSPace di valore 1, non ci riesce
	P1.setFamilyMemberBonus(4, 2);									//i familiari sulle carte viola hanno valore + 2
	P1.placeMember(familyMember, f1);								//ora ci riesce
	System.out.println("End");
	}
}
