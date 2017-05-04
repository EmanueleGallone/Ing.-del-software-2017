package pos.players;

import pos.Resources.FamilyMember;

public class FamilyMembersManager {
	
	Player owner;
	
	private FamilyMember blackFamilyMember = new FamilyMember(owner);
	private FamilyMember whiteFamilyMember = new FamilyMember(owner);
	private FamilyMember orangeFamilyMember = new FamilyMember(owner);
	private FamilyMember neutralFamilyMember = new FamilyMember(owner);
	
	public FamilyMembersManager(Player owner) {
		this.owner = owner;
	}

}
