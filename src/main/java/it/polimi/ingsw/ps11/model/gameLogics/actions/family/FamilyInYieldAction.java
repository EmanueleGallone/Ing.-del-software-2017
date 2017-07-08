package it.polimi.ingsw.ps11.model.gameLogics.actions.family;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.NeedConfirm;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.ActiveYieldAction;
import it.polimi.ingsw.ps11.model.modelEvents.ConfirmEvent;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
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
		
		if(yield.search(aManager.state().getPlayer())){
			aManager.state().invoke("Non puoi piazzare un'altro familiare in questa zona");
			return false;
		}
		
		FamilyInSpaceAction action = aManager.affect(spaceAction);
		return action.isLegal();
	}
	

	@Override
	public void perform() {
		FamilyInSpaceAction action = aManager.affect(spaceAction);
		action.perform();
		int activationValue = spaceAction.getFamilyMember().getValue();
		ActiveYieldAction activeYield = new ActiveYieldAction(aManager, yield.getActiveCard(), activationValue );
		activeYield = aManager.affect(activeYield);
		activeYield.perform();
	}

	@Override
	public void notifyConfirm(ConfirmViewEvent confirm) {
		spaceAction.incrementServant(confirm.getServant());
		if(isLegal())
			perform();
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
	
	@Override
	public FamilyInYieldAction clone() {
		return new FamilyInYieldAction(aManager, yield, spaceAction.getFamilyMember());
	}
}
