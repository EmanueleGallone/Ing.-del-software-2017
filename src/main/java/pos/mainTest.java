package pos;

import pos.bonus.FamilyMemberBonus;
import pos.cards.Cards;
import pos.dices.Dice;
import pos.familyMembers.Colors;
import pos.familyMembers.FamilyMember;
import pos.games.Player;
import pos.zones.FamilyMemberSpace;
import pos.zones.CardsAttivatorZone;

public class mainTest {
	
	public static void main(String[] args){
		
	 Player p1 = new Player();	
	 Dice dice =  new Dice(Colors.BLACK);
	 FamilyMemberSpace familyMemberSpace = new FamilyMemberSpace(3);
	 
	 dice.rollDice();
	 
	 CardsAttivatorZone harvast = new CardsAttivatorZone(Cards.BUILDING,familyMemberSpace);
	 FamilyMemberBonus bonus = new FamilyMemberBonus(Cards.BUILDING, +3);
	 harvast.getPreFamilyMemberCheck().attach(bonus);
	 FamilyMember familyMember = new FamilyMember(p1,dice);
	 
	 harvast.placeInSingleArea(familyMember);
	 
	 
	}
	
	
	public static void stampa(Integer testo){
		System.out.println(testo);
	}
	public static void stampa(String testo){
		System.out.println(testo);
	}
}
