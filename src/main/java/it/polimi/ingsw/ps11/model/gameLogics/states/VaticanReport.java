package it.polimi.ingsw.ps11.model.gameLogics.states;

import it.polimi.ingsw.ps11.model.excommunications.Excommunication;
import it.polimi.ingsw.ps11.model.gameLogics.StateHandler;
import it.polimi.ingsw.ps11.model.gameLogics.actions.resources.IncrementAction;
import it.polimi.ingsw.ps11.model.modelEvents.ConfirmEvent;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.FaithPoint;
import it.polimi.ingsw.ps11.model.zones.Church;
import it.polimi.ingsw.ps11.view.viewEvents.ConfirmViewEvent;

public class VaticanReport extends DefaultState {

	private StateHandler sHandler;
	private Church church;
	private int period;
	
	public VaticanReport(StateHandler stateHandler) {
		this.sHandler = stateHandler;
		church = stateHandler.getGame().getBoard().getChurch();
		period = stateHandler.getGame().getRoundManager().currentPeriod()-1;
	}
	
	@Override
	public void handle(ConfirmViewEvent confirmEvent) {
		if(confirmEvent.getConfirm()){
			ResourceList playerResource = sHandler.getPlayer().getResourceList();
			ResourceList reward = church.getReward(playerResource.get(FaithPoint.class).getValue());
			IncrementAction action = new IncrementAction(sHandler.actions(), reward);
			action = sHandler.actions().affect(action);
			if(action.isLegal())
				action.perform();
			completePhases();
			return;
		}
		addExcomunication();
	}
	
	
	private boolean checkFaithPoints() {
		ResourceList playerResource = sHandler.getPlayer().getResourceList();
		return playerResource.canSubtract(church.getRequirements(period));
	}
	
	private Excommunication getExcomunication(){
		try {
			Excommunication e = church.getExcomunications(period);
			return e;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void addExcomunication(){
		Excommunication e = getExcomunication();
		if(e != null)
			e.getEffect().attach(sHandler.actions());
		completePhases();
	}
	
	private void completePhases(){
		
	}
	
	@Override
	public void notifyToClient() {
		if(checkFaithPoints())
			sHandler.invoke(new ConfirmEvent("Vuoi mostrare il tuo sostegno alla chiesa?"));
		else {
			addExcomunication();
		}
	}
	
}
