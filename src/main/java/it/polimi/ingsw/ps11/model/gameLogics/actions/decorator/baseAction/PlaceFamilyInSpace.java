package it.polimi.ingsw.ps11.model.gameLogics.actions.decorator.baseAction;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.actions.decorator.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.decorator.ActionDecorator;
import it.polimi.ingsw.ps11.model.gameLogics.actions.decorator.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.decorator.PlayerAction;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;

public class PlaceFamilyInSpace extends PlayerAction {

	private FamilyMember familyMember;
	private ActionSpace actionSpace;
	
	public PlaceFamilyInSpace(Player player, FamilyMember familyMember, ActionSpace actionSpace) {
		super(player);
		this.familyMember = familyMember;
		this.actionSpace = actionSpace;
	}

	public FamilyMember getFamilyMember() {
		return familyMember;
	}
	
	@Override
	public void perform() {
		actionSpace.placeFamilyMember(familyMember, getSource());
	}

	@Override
	public boolean isLegal() {
		return (familyMember.getValue() >= actionSpace.getActionCost());
	}

	@Override
	public void enable(ActionManager aManager) {
		ActionDecorator<PlaceFamilyInSpace> decorator = aManager.get(PlaceFamilyInSpace.class);
		Action action = decorator.decore(this);
		if(action.isLegal())
			action.perform();
	}

}
