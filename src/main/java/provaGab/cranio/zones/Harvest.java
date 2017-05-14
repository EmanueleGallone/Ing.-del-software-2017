package provaGab.cranio.zones;

import provaGab.cranio.familyMember.FamilyMember;

public class Harvest {
	
	private ActionSpace soloSpace;
	private ActionSpace spaces[];
	
	public boolean placeFamilyMember(FamilyMember familyMember, int modifier){
		if(soloSpace.isEmpty()){
		if(soloSpace.placeFamilyMember(familyMember, modifier)){
			soloSpace.activateHarvest(familyMember);
			return true;
		}
		return false;
		} else if(spaces[0].placeFamilyMember(familyMember, modifier)){			//da cambiare spaces[0]
			soloSpace.activateHarvest(familyMember);
			return true;
		}
		return false;
	}
	
	
}
