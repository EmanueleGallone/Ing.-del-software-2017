package it.polimi.ingsw.ps11.model.gameLogics.newActions.family;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.newActions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.newActions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.newActions.NeedConfirm;
import it.polimi.ingsw.ps11.model.gameLogics.newActions.base.ActiveYieldAction;
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
	private FamilyMember familyMember;
	private FamilyInSpaceAction spaceAction;
		
	public FamilyInYieldAction() {
	
	}
	
	public FamilyInYieldAction(ActionManager aManager, Yield yield, FamilyMember familyMember) {
		this.aManager = aManager;
		this.yield = yield;
		this.familyMember = familyMember;
		spaceAction = new FamilyInSpaceAction(aManager,familyMember, yield.getFreeSpace());
	}
	
	@Override
	public boolean isLegal() {
		FamilyInSpaceAction action = aManager.affect(spaceAction);
		return action.isLegal();
	}

	@Override
	public void perform() {
		FamilyInSpaceAction action = aManager.affect(spaceAction);
		action.perform();
		ActiveYieldAction activeYield = new ActiveYieldAction(aManager, yield.getActiveCard(), familyMember.getValue());
		activeYield = aManager.affect(activeYield);
		activeYield.perform();
	}

	@Override
	public void notifyConfirm(ConfirmViewEvent confirm) {
		spaceAction.setServant(confirm.getServant());
		if(isLegal())
			perform();
	}

	@Override
	public ConfirmEvent getConfirm() {
		return new ConfirmEvent(spaceAction.getSpace());
	}
	
	public FamilyMember getFamilyMember() {
		return familyMember;
	}
	
	public Yield getYield() {
		return yield;
	}
	
	@Override
	public FamilyInYieldAction clone() {
		return new FamilyInYieldAction(aManager, yield.clone(), familyMember.clone());
	}
}
