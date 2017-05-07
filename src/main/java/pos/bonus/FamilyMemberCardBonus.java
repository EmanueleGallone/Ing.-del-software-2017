package pos.bonus;

import pos.cards.Cards;
import pos.events.EventListener;
import pos.events.event.FamilyCardCheckEvent;
import pos.familyMembers.FamilyMember;

public class FamilyMemberCardBonus extends Bonus<Cards , FamilyMember> implements EventListener<FamilyCardCheckEvent>{

	private int value;
	
	public FamilyMemberCardBonus(Cards cardType, int value) {
		super(cardType);
		this.value = value;
	}

	@Override
	public void behavior(FamilyMember familyMember) {
		familyMember.setModifier(value);
	}

	@Override
	public void handle(FamilyCardCheckEvent event) {
		if(this.subjects == event.getCard().getType()){
			behavior(event.getFamilyMember());
		}
	}
	
}
