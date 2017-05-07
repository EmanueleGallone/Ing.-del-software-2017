package pos.bonus;

import pos.events.EventListener;
import pos.events.event.FamilyZoneCheckEvent;
import pos.familyMembers.FamilyMember;
import pos.zones.ActivableZones;

public class FamilyMemberZoneBonus extends Bonus<ActivableZones, FamilyMember> implements EventListener<FamilyZoneCheckEvent> {

	private int value;
	public FamilyMemberZoneBonus(ActivableZones subject,int value) {
		super(subject);
		this.value = value;
	}
	
	@Override
	public void behavior(FamilyMember familyMember) {
		familyMember.setModifier(value);
	}
	
	@Override
	public void handle(FamilyZoneCheckEvent event) {
		if (event.getZone() == this.subjects){
			behavior(event.getFamilyMember());
		}
	}

}
