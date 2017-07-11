package it.polimi.ingsw.ps11.model.gameLogics.actions.family;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.NeedConfirm;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.ActiveYieldAction;
import it.polimi.ingsw.ps11.model.modelEvents.ConfirmEvent;
import it.polimi.ingsw.ps11.model.zones.yield.Yield;
import it.polimi.ingsw.ps11.view.viewEvents.ConfirmViewEvent;
/** <h3> PlaceFamilyYieldAction </h3>
 * <p> Classe che rappresenta l'azione di posizionamento di un familiare di un giocatore in un actionspace appartenente
 * ad una zona di Raccolta o Produzione.</p>
 * @see Action
 */
public class FamilyInYieldAction implements Action, NeedConfirm {

	private ActionManager aManager;
	private Yield yield;
	private FamilyInSpaceAction spaceAction;
		
	public FamilyInYieldAction() {
	
	}
	
	public FamilyInYieldAction(ActionManager aManager, Yield yield, FamilyMember familyMember) {
		this.aManager = aManager;
		this.yield = yield;
		spaceAction = new FamilyInSpaceAction(aManager,familyMember, yield.getFreeSpace());
	}
	
	@Override
	public boolean isLegal() {
		if(!spaceAction.getFamilyMember().isNeutral() && yield.search(aManager.state().getPlayer())){
			aManager.state().invoke("Cannot place in this zonee another family member of same player that is not a Neutral family member.");
			return false;
		}
		
		FamilyInSpaceAction action = aManager.affect(spaceAction);
		return action.isLegal();
	}
	

	@Override
	public void perform() {
		FamilyInSpaceAction action = aManager.affect(spaceAction);
		action.perform();
		int activeValue = spaceAction.getFamilyValue() - spaceAction.getSpace().getPenality();
		ActiveYieldAction activeYield = new ActiveYieldAction(aManager, yield.getActiveCard(), activeValue);
		activeYield = aManager.affect(activeYield);
		activeYield.perform();
	}

	@Override
	public boolean notifyConfirm(ConfirmViewEvent confirm) {
		spaceAction.incrementServant(confirm.getServant());
		if(isLegal()){
			perform();
			return true;
		}
		return false;
	}
	
	public FamilyInSpaceAction getSpaceAction() {
		return spaceAction;
	}

	@Override
	public ConfirmEvent getConfirm() {
		return new ConfirmEvent(spaceAction.getSpace());
	}
	
	public Yield getYield() {
		return yield;
	}
	
//	@Override
//	public FamilyInYieldAction clone() {
//		return new FamilyInYieldAction(aManager, yield, spaceAction.getFamilyMember());
//	}
}
