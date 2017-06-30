package it.polimi.ingsw.ps11.model.gameLogics.actions.affecter;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.FamilyInFloorAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.FamilyInSpaceAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.FamilyInTowerAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.GetCardAction;


/**
 * Incrementa di un tot (value) il valore del familyMember se quest'ultimo viene piazzato 
 * in un piano con una carta di un certo colore
 */
public class FamilyInFloorAffecter extends FamilyInFloorAction {
	
	private final boolean FORWARD = true;
	private boolean forward = FORWARD;
	
	private String cardType;
	private int value;
	
	private FamilyInFloorAction action;
	
	public FamilyInFloorAffecter(String cardType, int value) {
		this.cardType = cardType;
		this.value = value;
	}
	
	public FamilyInFloorAffecter(Class<? extends DevelopmentCard> cardType, int value) {
		this(cardType.toString(), value);
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
		DevelopmentCard card = action.getCardAction().getCard();
		if(card.getClass().toString().equals(this.cardType)){
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
	public FamilyInFloorAffecter clone(){
		FamilyInFloorAffecter copy = new FamilyInFloorAffecter(cardType,value);
		copy.aManager = aManager;
		if(action != null)
			copy.action = action.clone();
		return copy;
	}
}
