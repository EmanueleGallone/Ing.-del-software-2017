package pos.bonus;

import pos.cards.Cards;
import pos.events.Event;
import pos.events.EventListener;
import pos.familyMembers.FamilyMember;

public class FamilyMemberBonus extends Bonus<Cards , FamilyMember> implements EventListener<Event<Cards, FamilyMember>>{

	private int modifier;
	
	public FamilyMemberBonus(Cards cardType, int modifier) {
		super(cardType);
		this.modifier = modifier;
	}

	@Override
	public void behavior(FamilyMember familyMember) {
		familyMember.setModifier(modifier);
	}

	@Override
	public void handle(Event<Cards, FamilyMember> event) {
		if(this.subjects == event.getSubject()){
			behavior(event.getParameter());
		}
	}
	
}
