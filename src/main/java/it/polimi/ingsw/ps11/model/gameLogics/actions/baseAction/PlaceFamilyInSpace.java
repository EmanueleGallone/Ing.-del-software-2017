package it.polimi.ingsw.ps11.model.gameLogics.actions.baseAction;

import java.util.Optional;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionDecorator;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
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
	public Action enable(ActionManager aManager) {
		Optional<ActionDecorator<PlaceFamilyInSpace>> optional = aManager.get(PlaceFamilyInSpace.class);
		if(optional.isPresent())
			return optional.get().decore(this);
		return this;
	}

}
