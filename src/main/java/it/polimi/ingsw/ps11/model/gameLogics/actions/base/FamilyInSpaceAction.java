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
	protected UseServantAction servantAction;
	
	
	public FamilyInSpaceAction() {
	
	}
	
	public FamilyInSpaceAction(ActionManager aManager, FamilyMember fMember, ActionSpace space) {
		this.aManager = aManager;
		this.familyMember = fMember.clone();
		this.space = space;
	}
	
	public FamilyInSpaceAction(ActionManager aManager, FamilyMember fMember, ActionSpace space, UseServantAction servantAction) {
		this(aManager,fMember,space);
		this.servantAction = servantAction;
	}
	
	@Override
	public boolean isLegal() {
		int mod = 0;
		if(servantAction != null)
			mod = servantAction.getServant().getValue();
		if(space.isFree() && servantAction.isLegal()){
			return space.getActionCost() <= (familyMember.getValue() + mod);
		}
		return false;
	}

	@Override
	public void perform() {
		servantAction.perform();
		space.placeFamilyMember(familyMember, aManager.getSubject());
		if(space.getResources()!=null){
			IncrementAction increment = aManager.newIncrementAction(space.getResources());
			increment.perform();
		}
	}
	
	public ActionSpace getSpace() {
		return space;
	}
	
	public FamilyMember getFamilyMember() {
		return familyMember;
	}
	

	// _________________________ Method for action system ________________________
	
	
	@Override
	public void attach(ActionManager aManager) {
		FamilyInSpaceAction act = aManager.get(target());
		if(act == null){
			act = this;
		}
		aManager.add(act.decore(this));
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
		FamilyInSpaceAction copy = new FamilyInSpaceAction(aManager, familyMember.clone(), space.clone());
		return copy;
	}

}
