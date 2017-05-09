package pos.familyMembers;

import java.util.HashMap;
import java.util.Map;

import pos.dices.DicesManager;
import pos.players.Player;

public class FamilyMembersManager {
	
	Player owner;

	private Map<Colors, FamilyMember> familyList = new HashMap<>();

//Start Constructors
	
	public FamilyMembersManager(Player owner,DicesManager dices) {
		this.owner = owner;
		for(Colors color: Colors.values()){
			familyList.put(color, new FamilyMember(owner,dices.getDice(color)));
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
