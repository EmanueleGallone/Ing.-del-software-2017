package it.polimi.ingsw.ps11.model.gameLogics.actions.base.family;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.NeedConfirm;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.ActiveYieldAction;
import it.polimi.ingsw.ps11.model.modelEvents.ConfirmEvent;
import it.polimi.ingsw.ps11.model.modelEvents.GameUpdateEvent;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.yield.Yield;
import it.polimi.ingsw.ps11.view.viewEvents.ConfirmViewEvent;
/** <h3> PlaceFamilyYieldAction </h3>
 * <p> Classe che rappresenta l'azione di posizionamento di un familiare di un giocatore in un actionspace appartenente
 * ad una zona di Raccolta o Produzione.</p>
 * @see Action
 */

public class FamilyInYieldAction implements Action<FamilyInYieldAction>,NeedConfirm {

	protected ActionManager aManager;
	private Yield yield;
	private FamilyMember familyMember;
	private FamilyInSpaceAction spaceAction;
	
	private ConfirmViewEvent confermed;
	
	public FamilyInYieldAction() {
	
	}
	
	public FamilyInYieldAction(ActionManager aManager, Yield yield, FamilyMember familyMember) {
		this.aManager = aManager;
		this.yield = yield;
		this.familyMember = familyMember;
		spaceAction = aManager.newFamilyInSpace(familyMember, yield.getFreeSpace());
	}
	
	@Override
	public boolean isLegal() {
		if(confermed != null)
			spaceAction.getUseServantAction().setServant(confermed.getServant());
		return spaceAction.isLegal();
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
	
	@Override
	public void notifyConfirm(ConfirmViewEvent confirm) {
		this.confermed = confirm;
		spaceAction.getUseServantAction().setServant(confirm.getServant());
		if(isLegal())
			perform();
	}

	@Override
	public ConfirmEvent getConfirm() {
		return new ConfirmEvent(spaceAction.getSpace());
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
