package it.polimi.ingsw.ps11.cranio.game.actions;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.zones.actionSpace.ActionSpace;

public class PlaceFamilyMember implements Action {

	private FamilyMember familyMember;
	private ActionSpace actionSpace;
	
	public PlaceFamilyMember(FamilyMember familyMember, ActionSpace actionSpace) {
		this.familyMember = familyMember;
		this.actionSpace = actionSpace;
	}
	
	@Override
	public void perform() {
		
		actionSpace.addFamilyMember(familyMember);
		Player owner = familyMember.getOwner();
		owner.getResourceList().sum(actionSpace.getResources());
		
		//resetta il modificatore del familiare
		
	}

	@Override
	public boolean isLegal() {
		return familyMember.getValue() < actionSpace.getActionCost();
	}

	@Override
	public void accept(ActionVisitor visitor) {
		visitor.visit(this);
	}
}
