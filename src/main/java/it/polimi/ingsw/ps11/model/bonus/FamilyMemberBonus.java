package it.polimi.ingsw.ps11.model.bonus;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.game.actionsEma.PlaceFamilyTowerAction;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;

public class FamilyMemberBonus extends PlayerBonus {

	private Tower tower;
	private int value;
	private FamilyMember familyMember;
	
	public FamilyMemberBonus(Tower tower, int value) {
		this.tower= tower;
		this.value = value;
	}
	
	public void setFamilyMember(FamilyMember familyMember) {
		this.familyMember = familyMember;
	}
	
	@Override
	public void behavior() {
		new PlaceFamilyTowerAction().perform(this);
	}
	
	public Tower getTower() {
		return tower;
	}
	
	public int getValue() {
		return value;
	}
	
}
