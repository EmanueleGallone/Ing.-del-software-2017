package pos;

import pos.bonus.ActiveZoneBonus;
import pos.bonus.IncrementBonus;
import pos.cards.Card;
import pos.cards.Cards;
import pos.events.event.FamilyCardCheckEvent;
import pos.familyMembers.Colors;
import pos.familyMembers.FamilyMember;
import pos.players.Player;
import pos.resources.Resources;
import pos.zones.ActivableZone;
import pos.zones.FamilyMemberSpace;
import pos.zones.Floors;

public class mainTest {
	
	public static void main(String[] args){
		
	 Player p1 = new Player();	
	 
	 /*
	 IncrementBonus malus = new IncrementBonus(p1.getResource(Resources.STONE), -1);
	 p1.getResource(Resources.STONE).getIncrementEvent().attach(malus);*/
	
	 /*
	 Floors floors = new Floors(new FamilyMemberSpace(2));
	 floors.setCard(new Card(Cards.VENTURE));
	 FamilyMemberBonus bonus = new FamilyMemberBonus(Cards.VENTURE, 4);
	 Floors.getPreFamilyMemberCheck().attach(bonus);
	 */
	 
	 
	 
	}
	
	
	public static void stampa(Integer testo){
		System.out.println(testo);
	}
	public static void stampa(String testo){
		System.out.println(testo);
	}
}
