package it.polimi.ingsw.ps11.model.gameLogics.actions.base;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.NeedConfirm;
import it.polimi.ingsw.ps11.model.gameLogics.states.WaitConfirm;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.view.viewEvents.ConfirmEvent;

public class FamilyInFloorAction implements Action<FamilyInFloorAction>, NeedConfirm{
	
	protected ActionManager aManager;
	protected FamilyInTowerAction towerAction;
	protected FamilyInSpaceAction spaceAction;
	protected GetCardAction getCard;
	
	private ConfirmEvent confermed;
	
	public FamilyInFloorAction() {
		
	}
	
	public FamilyInFloorAction(ActionManager aManager, FamilyInTowerAction tAction, FamilyInSpaceAction sAction ,GetCardAction getCard) {
		this.aManager = aManager;
		this.towerAction = tAction;
		this.spaceAction = sAction;
		this.getCard = getCard;
	}

	
	@Override
	public void perform() {
		towerAction.perform();
		spaceAction.perform();
		getCard.perform();
	}
	
	@Override
	public boolean isLegal() {
		
		if(confermed == null){
			aManager.changeState(new WaitConfirm(this));
			return false;
		}
		
		boolean result = towerAction.isLegal() && spaceAction.isLegal();
		ResourceList resource = spaceAction.getSpace().getResources();
		if(resource != null){
			// Questo perchè il giocatore può usare le risorse del piano per pagare la carta
			getCard.getCostModifier().subtract(resource);
		}
		result = result && getCard.isLegal();
		return result;
	}

	public FamilyInTowerAction getTowerAction() {
		return towerAction;
	}
	public FamilyInSpaceAction getSpaceAction() {
		return spaceAction;
	}
	public GetCardAction getCardAction() {
		return getCard;
	}

	@Override
	public void notifyConfirm(ConfirmEvent confirm) {
		this.confermed = confirm;
		spaceAction.getServantAction().setServant(confirm.getServant());
		if(isLegal())
			perform();
	}

	// _________________________ Method for action system ________________________
	
	@Override
	public void attach(ActionManager aManager) {
		FamilyInFloorAction increment = aManager.get(target());
		if(increment == null){
			increment = this;
		}
		aManager.add(increment.decore(this));
	}

	@Override
	public Class<FamilyInFloorAction> target() {
		return FamilyInFloorAction.class;
	}

	@Override
	public FamilyInFloorAction decore(FamilyInFloorAction action) {
		if(action != this){
			return action.decore(this);
		}
		return this;
	}
// _________________________________________________
	
	@Override
	public FamilyInFloorAction clone() {
		FamilyInFloorAction copy = new FamilyInFloorAction(aManager,towerAction.clone(), spaceAction.clone(), getCard.clone());
		return copy;
	}
}
