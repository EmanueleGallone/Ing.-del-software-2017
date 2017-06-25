package it.polimi.ingsw.ps11.model.gameLogics.actions.decorator.baseAction;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.actions.decorator.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.decorator.ActionDecorator;
import it.polimi.ingsw.ps11.model.gameLogics.actions.decorator.ActionManager;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;

public class PlaceFamilyInSpace implements Action {

	private Player player;
	private FamilyMember familyMember;
	private ActionSpace actionSpace;
	
	public PlaceFamilyInSpace(Player player, FamilyMember familyMember, ActionSpace actionSpace) {
		this.player = player;
		this.familyMember = familyMember;
		this.actionSpace = actionSpace;
	}

	public FamilyMember getFamilyMember() {
		return familyMember;
	}
	
	@Override
	public Player getSource() {
		return player;
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
	public ActionDecorator<PlaceFamilyInSpace> enable(ActionManager aManager) {
		ActionDecorator<PlaceFamilyInSpace> decorator = aManager.get(PlaceFamilyInSpace.class);
		return decorator.decore(this);
	}

}
