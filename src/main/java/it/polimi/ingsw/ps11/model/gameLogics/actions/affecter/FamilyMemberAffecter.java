package it.polimi.ingsw.ps11.model.gameLogics.actions.affecter;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.FamilyInFloorAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.FamilyInSpaceAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.FamilyInTowerAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.GetCardAction;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;

public class FamilyMemberAffecter extends FamilyInFloorAction {

	private final boolean FORWARD = true;
	private boolean forward = FORWARD;
	
	private String tower;
	private int value;
	
	private FamilyInFloorAction action;
	
	public FamilyMemberAffecter(String tower, int value) {
		this.tower = tower;
		this.value = value;
	}
	
	public FamilyMemberAffecter(Class<? extends Tower> tower, int value) {
		this(tower.toString(), value);
	}
	
	
	@Override
	public GetCardAction getCardAction() {
		return action.getCardAction();
	}
	
	@Override
	public FamilyInSpaceAction getSpaceAction() {
		return action.getSpaceAction();
	}
	
	@Override
	public FamilyInTowerAction getTowerAction() {
		return action.getTowerAction();
	}
	
	@Override
	public boolean isLegal() {
		FamilyMember familyMember = action.getSpaceAction().getFamilyMember();
		Tower tower = action.getTowerAction().getTower();
		if(tower.getClass().toString().equals(this.tower)){
			familyMember.setModifier(value);
		}
		return action.isLegal();
	}
	
	@Override
	public void perform() {
		forward();
	}
	
// Method for decorator system ____________	
	
	@Override
	public FamilyInFloorAction decore(FamilyInFloorAction action) {
		if(this.action == null && action != this){
			this.action = action;
			return this;
		}
		else if(this.action != null){
			return this.action.decore(action);	
		}
		return this;
	}

	public void forward(){
		if (action!= null)
			action.perform(forward && FORWARD);
		this.forward = FORWARD;
	}
	
	@Override
	public void perform(boolean forward) {
		this.forward = forward;
		perform();
	}
	
// __________________________
	
	@Override
	public FamilyMemberAffecter clone(){
		FamilyMemberAffecter copy = new FamilyMemberAffecter(tower,value);
		copy.aManager = aManager;
		if(action != null)
			copy.action = action.clone();
		return copy;
	}
}
