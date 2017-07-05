package it.polimi.ingsw.ps11.model.gameLogics.newActions.family;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.IncrementAction;
import it.polimi.ingsw.ps11.model.gameLogics.newActions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.newActions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.newActions.resources.DecrementAction;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Servant;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;

public class FamilyInSpaceAction implements Action{

	
	private ActionManager aManager;
	private FamilyMember familyMember;
	private ActionSpace space;
	private int servant;
	
	public FamilyInSpaceAction(ActionManager aManager, FamilyMember fMember, ActionSpace space) {
		this.aManager = aManager;
		this.familyMember = fMember;
		this.space = space;
		this.servant = 0;
	}
	
	public FamilyInSpaceAction(ActionManager aManager, FamilyMember fMember, ActionSpace space, int servant) {
		this(aManager,fMember,space);
		this.servant = servant;
	}
	
	@Override
	public boolean isLegal() {
		
		DecrementAction servantAction = new DecrementAction(aManager, new ResourceList(new Servant(servant)));
		servantAction = aManager.affect(servantAction);
		if(space.isFree() && servantAction.isLegal()){
			return checkActionCost(servant);
		}
		return false;
	}

	public boolean checkActionCost(int modifier){
		if(space.getActionCost() > (familyMember.getValue() + modifier)){
			aManager.send("Il familiare non ha un valore sufficiente");
			return false;
		}
		return true;
	}
	
	@Override
	public void perform() {
		if(useServantAction!= null)
			useServantAction.perform();
		space.placeFamilyMember(familyMember, aManager.getSubject());
		familyMember.setUsed(true);
		if(space.getResources()!=null){
			IncrementAction increment = aManager.newIncrementAction(space.getResources());
			increment.perform();
		}
	}

	@Override
	public Action clone() {
		// TODO Auto-generated method stub
		return null;
	}

}
