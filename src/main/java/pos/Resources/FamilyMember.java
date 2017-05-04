package pos.Resources;

import pos.players.Player;

public class FamilyMember extends Resource{
	
	private Player owner;
	
	public FamilyMember(Player player) {
		super();
		this.owner = player;
	}
	
}
