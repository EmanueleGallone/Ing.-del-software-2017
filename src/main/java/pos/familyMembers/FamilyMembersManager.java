package pos.familyMembers;

import java.util.HashMap;
import java.util.Map;

import pos.players.Player;

public class FamilyMembersManager {
	
	Player owner;

	private Map<Colors, FamilyMember> familyList = new HashMap<>();

//Start Constructors
	
	public FamilyMembersManager(Player owner) {
		this.owner = owner;
		for(Colors color: Colors.values()){
			familyList.put(color, new FamilyMember(owner,color));
		}
	}
	
//End Constructors
//Start Logics
//End logics
//Start getters
	public FamilyMember getFamiliMember(Colors color){
		return familyList.get(color);
	}
//End getters
//Start setters

//End setter

}
