package it.polimi.ingsw.ps11.model.gameLogics.actions.base;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Affecter;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;

public class FamilyInSpaceAction implements Action, Affecter<FamilyInSpaceAction>{
	
	protected ActionManager aManager;
	protected FamilyMember familyMember;
	protected ActionSpace space;
	
	public FamilyInSpaceAction(ActionManager aManager, FamilyMember fMember, ActionSpace space) {
		this.aManager = aManager;
		this.familyMember = fMember.clone();
		this.space = space;
	}
	
	@Override
	public boolean isLegal() {
		if(space.isFree() && space.getActionCost() <= familyMember.getValue()){
			return true;
		}
		return false;
	}

	@Override
	public void perform() {
		space.placeFamilyMember(familyMember, aManager.getSubject());
		if(space.getResources()!=null){
			IncrementAction increment = aManager.newIncrementAction(space.getResources());
			increment.perform();
		}
	}
	
	public ActionSpace getSpace() {
		return space;
	}

// Method for decorator pattern _____________________________
	
	@Override
	public void attach(ActionManager aManager) {
		FamilyInSpaceAction increment = aManager.get(target());
		if(increment == null){
			increment = this;
		}
		aManager.add(increment.decore(this));
	}

	@Override
	public Class<FamilyInSpaceAction> target() {
		return FamilyInSpaceAction.class;
	}
	
	@Override
	public FamilyInSpaceAction decore(FamilyInSpaceAction action) {
		if(action != this){
			return action.decore(this);
		}
		return this;
	}
	
// ____________________________________________
	
	@Override
	public FamilyInSpaceAction clone() {
		// TODO Auto-generated method stub
		return null;
	}

}
