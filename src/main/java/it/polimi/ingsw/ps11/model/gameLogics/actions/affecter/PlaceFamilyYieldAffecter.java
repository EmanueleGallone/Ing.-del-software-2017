package it.polimi.ingsw.ps11.model.gameLogics.actions.affecter;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.PlaceFamilyYieldAction;

public class PlaceFamilyYieldAffecter extends PlaceFamilyYieldAction{

	private final boolean FORWARD = true;
	private boolean forward = FORWARD;

	private String cardType;
	private int value;
	
	private PlaceFamilyYieldAction action;
	
	public PlaceFamilyYieldAffecter(String cardType, int value) {
		this.cardType = cardType;
		this.value = value;
	}
	
	public PlaceFamilyYieldAffecter(Class<? extends DevelopmentCard> cardType, int value) {
		this(cardType.toString(), value);
	}

	
	@Override
	public boolean isLegal() {
		action.getFamilyMember().setModifier(value);
		return true;
	}
	
	@Override
	public void perform() {
		forward();
	}
	
	@Override
	public FamilyMember getFamilyMember() {
		return action.getFamilyMember();
	}
	
// Method for decorator system ____________	
	
	@Override
	public PlaceFamilyYieldAction decore(PlaceFamilyYieldAction action) {
		if(this.action == null && action != this){
			this.action = action;
			return this;
		}
		else if(this.action != null){
			this.action.decore(action);
			return this;
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
	public PlaceFamilyYieldAction clone(){
		PlaceFamilyYieldAffecter copy = new PlaceFamilyYieldAffecter(cardType,value);
		copy.aManager = aManager;
		if(action != null)
			copy.action = action.clone();
		return copy;
	}
}
