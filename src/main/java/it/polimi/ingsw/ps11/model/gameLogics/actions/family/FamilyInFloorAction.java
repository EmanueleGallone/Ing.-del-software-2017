package it.polimi.ingsw.ps11.model.gameLogics.actions.family;


import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.NeedConfirm;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ResourceListener;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.GetCardAction;
import it.polimi.ingsw.ps11.model.gameLogics.states.WaitConfirm;
import it.polimi.ingsw.ps11.model.modelEvents.ConfirmEvent;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.view.viewEvents.ConfirmViewEvent;
/** <h3> FamilyInFloorAction </h3>
 * <p> Classe che rappresenta l'azione di posizionamento di un familiare di un giocatore in un actionspace appartenente
 * ad un Floor di una torre.</p>
 * @see Action
 */
public class FamilyInFloorAction  implements Action, NeedConfirm,ResourceListener{
	
	protected ActionManager aManager;
	protected FamilyInTowerAction towerAction;
	protected FamilyInSpaceAction spaceAction;
	protected GetCardAction getCard;
	
	private ConfirmViewEvent confermed;
	
	public FamilyInFloorAction(ActionManager aManager, FamilyInTowerAction tAction, FamilyInSpaceAction sAction ,GetCardAction getCard) {
		
		this.aManager = aManager;
		this.towerAction = tAction;
		this.spaceAction = sAction;
		this.getCard = getCard;
	}

	
	@Override
	public void perform() {
		towerAction.perform();
		getCard.perform();
		spaceAction.perform();
		//aManager.state().invoke(new GameUpdateEvent(aManager.state().getGame()));
	}
	
	@Override
	public boolean isLegal() {
		boolean result;
		
		//checkFloorBonus();
		result = towerAction.isLegal();
		if(!towerAction.getTower().isFree() && confermed == null && getCard.getCost()==null)
			getCard.addPenality(towerAction.taxIfNotFree);
		if(result && (result = getCard.isLegal()) && confermed == null){
			aManager.state().nextState(new WaitConfirm(this));
			return false;
		}
		
		return result && spaceAction.isLegal();
	}
	
//	private void checkFloorBonus(){
//	//Va fatto prima del getCard.isLegal perchè il giocatore può usare le risorse del piano per pagare la carta
//		ResourceList resource = spaceAction.getSpace().getResources();
//		if(resource != null){
//			getCard.setModifier(resource.clone());	
//		}
//		
//	}
	
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
	public boolean notifyConfirm(ConfirmViewEvent confirm) {
		this.confermed = confirm;
		spaceAction.incrementServant(confirm.getServant());
		if(isLegal()){
			perform();
			return true;
		}
		return false;
	}

	@Override
	public ConfirmEvent getConfirm() {
		String tower = towerAction.getTower().getName();
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
	
//	@Override
//	public FamilyInFloorAction clone() {
//		return new FamilyInFloorAction(aManager, towerAction.clone(), spaceAction.clone(), getCard.clone());
//	}
}
