package it.polimi.ingsw.ps11.model.gameLogics.states;

import it.polimi.ingsw.ps11.model.excommunications.Excommunication;
import it.polimi.ingsw.ps11.model.gameLogics.StateHandler;
import it.polimi.ingsw.ps11.model.modelEvents.ConfirmEvent;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.zones.Church;
import it.polimi.ingsw.ps11.view.viewEvents.ConfirmViewEvent;

public class VaticanReport extends DefaultState {

	private StateHandler sHandler;
	private Church church;
	
	public VaticanReport(StateHandler stateHandler) {
		this.sHandler = stateHandler;
		church = stateHandler.getGame().getBoard().getChurch();
	}
	
	@Override
	public void handle(ConfirmViewEvent confirmEvent) {
		if(confirmEvent.getConfirm()){
			
		}
	}
	
	
	private boolean checkFaithPoints() {
		Excommunication e = getExcomunication();
		ResourceList playerResource = sHandler.getPlayer().getResourceList();
		
		if(e != null && playerResource.canSubtract(e.getRequirement()))
			return true;
		return false;
	}
	
	private Excommunication getExcomunication(){
		int period = sHandler.getGame().getRoundManager().currentPeriod()-1;
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
		e.getEffect().attach(sHandler.actions());
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
