package pos.events.event;

import pos.familyMembers.FamilyMember;
import pos.zones.ActivableZones;

public class FamilyZoneCheckEvent {
	private ActivableZones zone;
	private FamilyMember familyMember;
	
	public FamilyZoneCheckEvent(ActivableZones zone, FamilyMember familyMember) {
		this.zone = zone;
		this.familyMember = familyMember;
	}
	
	public ActivableZones getZone() {
		return zone;
	}
	public FamilyMember getFamilyMember() {
		return familyMember;
	}
}
