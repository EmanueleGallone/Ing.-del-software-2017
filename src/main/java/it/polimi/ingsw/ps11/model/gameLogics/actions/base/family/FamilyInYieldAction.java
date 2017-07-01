package it.polimi.ingsw.ps11.model.gameLogics.actions.base.family;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.ActiveYieldAction;
import it.polimi.ingsw.ps11.model.zones.yield.Yield;

public class FamilyInYieldAction implements Action<FamilyInYieldAction> {

	protected ActionManager aManager;
	private Yield yield;
	private FamilyMember familyMember;
	
	public FamilyInYieldAction() {
	
	}
	
	public FamilyInYieldAction(ActionManager aManager, Yield yield, FamilyMember familyMember) {
		this.aManager = aManager;
		this.yield = yield;
		this.familyMember = familyMember;
	}
	
	@Override
	public boolean isLegal() {
		FamilyInSpaceAction s = aManager.newFamilyInSpace(familyMember, yield.getFreeSpace());
		return s.isLegal();
	}

	@Override
	public void perform() {
		FamilyInSpaceAction s = aManager.newFamilyInSpace(familyMember, yield.getFreeSpace());
		s.perform();
		ActiveYieldAction activeYield = aManager.newActiveYield(yield.getActiveCard(), familyMember.getValue());
		activeYield.perform();
	}

	public FamilyMember getFamilyMember() {
		return familyMember;
	}
	
// _________________________ Method for action system ________________________


	@Override
	public FamilyInYieldAction decore(FamilyInYieldAction action) {
		if(action != this){
			return action.decore(this);
		}
		return this;
	}
	
	@Override
	public void attach(ActionManager aManager){
		FamilyInYieldAction action = aManager.get(target());
		if(action == null){
			action = this;
		}
		aManager.add(action.decore(this));
	}

	@Override
	public Class<FamilyInYieldAction> target() {
		return FamilyInYieldAction.class;
	}
	
// ___________________________________________________
	
	@Override
	public FamilyInYieldAction clone(){
		FamilyInYieldAction copy = new FamilyInYieldAction(aManager, yield.clone(), familyMember.clone());
		return copy;
	}

}
