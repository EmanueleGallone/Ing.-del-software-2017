package test.main.da.cancellare.poi;

import it.polimi.ingsw.dices.BlackDice;
import it.polimi.ingsw.resources.BlackFamilyMember;
import it.polimi.ingsw.resources.FamilyMember;
import it.polimi.ingsw.resources.Resource;
import it.polimi.ingsw.resources.Stone;

public class Player {
	private String name;
	private Resource stone;
	
	private FamilyMember familyMember;
	
	public Player(){
		name = "Mario";
		stone = new Stone();
		stone.setValue(5);
		familyMember= new BlackFamilyMember();
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", stone=" + stone + "familyMember=" +familyMember + "]\n\n";
	}
	
	public void setFamilyMemberValue(BlackDice d){
		familyMember.setValue(d.getValue());
	}
	
	
}
