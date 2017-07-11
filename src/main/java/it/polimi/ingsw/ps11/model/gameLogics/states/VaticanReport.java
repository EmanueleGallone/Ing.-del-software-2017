package it.polimi.ingsw.ps11.model.gameLogics.states;

import java.util.Timer;
import java.util.TimerTask;

import it.polimi.ingsw.ps11.model.cards.effects.Effect;
import it.polimi.ingsw.ps11.model.excommunications.Excommunication;
import it.polimi.ingsw.ps11.model.gameLogics.StateHandler;
import it.polimi.ingsw.ps11.model.gameLogics.actions.resources.IncrementAction;
import it.polimi.ingsw.ps11.model.modelEvents.ConfirmEvent;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.FaithPoint;
import it.polimi.ingsw.ps11.model.zones.Church;
import it.polimi.ingsw.ps11.view.viewEvents.ConfirmViewEvent;
/**
 * <h3> VaticanReport </h3>
 * <p> Classe che rappresenta lo stato a fine turno in cui la Chiesa esegue le azioni.</p>
 * @see 
 */
public class VaticanReport extends DefaultState {

	private transient Timer timer;
	private int delay = 60000;
	
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
			ResourceList reward = church.getReward(new FaithPoint().getFrom(playerResource).getValue());
			IncrementAction action = new IncrementAction(sHandler.actions(), reward);
			playerResource.setResource(new FaithPoint());
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
		Excommunication excommunication = getExcomunication();
		for(Effect e : excommunication){
			e.get(sHandler.actions());
		}
		sHandler.invoke("You got an excommunication from the Church.");
		completePhases();
	}
	
	private void completePhases(){
		stopTimer();
		sHandler.getGameLogic().notifyVaticanReportConclusion(sHandler);
	}
	
	@Override
	public void notifyToClient() {
		if(checkFaithPoints()){
			sHandler.invoke(new ConfirmEvent("Would you like to support the Church?"));
			startTimer();
		}
		else {
			addExcomunication();
		}
	}
	
	
	private void startTimer(){
		stopTimer();
		timer = new Timer();
		TimerTask task = new StartingMatch();
		timer.schedule(task, delay);
		System.out.println("\nTimer for excomunication choice started, next turn in : " + delay/1000 + " seconds\n");
	}
	
	private class StartingMatch extends TimerTask{

		@Override
		public void run() {
			completePhases();
		}
	}
	
	private void stopTimer(){
		if(timer!= null){
			timer.cancel();
			timer.purge();
		}
	}
	
}
