package it.polimi.ingsw.ps11.model.gameLogics.actions.affecter;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.family.FamilyInYieldAction;

/** <h3> Nome </h3>
 * <p> Classe che rappresenta il bonus che ha il compito di modificare il valore di un familiare se quest'ultimo viene 
 * posizionato sull'actionSpace di una zona Raccolta o Produzione </p>
 * @see FamilyYieldAction
 */

public class FamilyInYieldAffecter extends FamilyInYieldAction{

	private final boolean FORWARD = true;
	private boolean forward = FORWARD;

	private String cardType;
	private int value;
	private FamilyInYieldAction action;
	
	public FamilyInYieldAffecter(String cardType, int value) {
		this.cardType = cardType;
		this.value = value;
	}
	
	public FamilyInYieldAffecter(Class<? extends DevelopmentCard> cardType, int value) {
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
	public FamilyInYieldAction decore(FamilyInYieldAction action) {
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
	public FamilyInYieldAction clone(){
		FamilyInYieldAffecter copy = new FamilyInYieldAffecter(cardType,value);
		copy.aManager = aManager;
		if(action != null)
			copy.action = action.clone();
		return copy;
	}
}
