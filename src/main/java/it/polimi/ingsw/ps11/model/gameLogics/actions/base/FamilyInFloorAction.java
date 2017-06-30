package it.polimi.ingsw.ps11.model.gameLogics.actions.base;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.NeedConfirm;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ResourceListener;
import it.polimi.ingsw.ps11.model.gameLogics.states.WaitConfirm;
import it.polimi.ingsw.ps11.model.modelEvents.ConfirmEvent;
import it.polimi.ingsw.ps11.model.modelEvents.GameUpdateEvent;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.view.viewEvents.ConfirmViewEvent;
/** <h3> FamilyInFloorAction </h3>
 * <p> Classe che rappresenta l'azione di posizionamento di un familiare di un giocatore in un actionspace appartenente
 * ad un Floor di una torre.</p>
 * @see Action
 */
public class FamilyInFloorAction implements Action<FamilyInFloorAction>, NeedConfirm, ResourceListener{
	
	protected ActionManager aManager;
	protected FamilyInTowerAction towerAction;
	protected FamilyInSpaceAction spaceAction;
	protected GetCardAction getCard;
	
	private ConfirmViewEvent confermed;
	
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
		aManager.stateHandler().invoke(new GameUpdateEvent(aManager.stateHandler().getGame()));
	}
	
	@Override
	public boolean isLegal() {
		boolean result = towerAction.isLegal() &&  getCard.isLegal();
		if(confermed == null){
			aManager.changeState(new WaitConfirm(this));
			return false;
		}
		spaceAction.getServantAction().setServant(confermed.getServant());
		ResourceList resource = spaceAction.getSpace().getResources();
		if(resource != null){
			getCard.getCostModifier().subtract(resource); 		// Questo perchè il giocatore può usare le risorse del piano per pagare la carta
		}
		result = result && spaceAction.isLegal();
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
	public void notifyConfirm(ConfirmViewEvent confirm) {
		this.confermed = confirm;
		spaceAction.getServantAction().setServant(confirm.getServant());
		if(isLegal())
			perform();
	}

	@Override
	public ConfirmEvent getConfirm() {
		String tower = towerAction.getTower().getClass().toString();
		Floor floor = new Floor();
		floor.setActionSpace(spaceAction.getSpace());
		floor.setCard(getCard.getCard());
		return new ConfirmEvent(floor, tower);
	}
	
	@Override
	public void update(ResourceList resource) {
		getCard.setCost(resource);
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
