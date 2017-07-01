package it.polimi.ingsw.ps11.model.gameLogics.actions.base;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
/** <h3> DoSeveralTimesAction </h3>
 * <p> Classe che rappresenta un <code>action</code> ripetuta un <code>iteration</code> numero di volte.</p>
 * @see Action
 */
public class DoSeveralTimesAction implements Action<DoSeveralTimesAction>{

	private ActionManager aManager;
	private Action<?> action;
	private int iterationNumber;
	
	public DoSeveralTimesAction(ActionManager aManager, Action<?> action, int iterationNumber) {
		this.aManager = aManager;
		this.action = action;
		this.iterationNumber = iterationNumber;
	}
	
	@Override
	public boolean isLegal() {
		return action.isLegal();
	}

	@Override
	public void perform() {
		for(int i = 0; i < iterationNumber; i++){
			action.perform();
		}
	}

	@Override
	public DoSeveralTimesAction decore(DoSeveralTimesAction action) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void attach(ActionManager aManager) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<? extends Action<?>> target() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Action<?> clone() {
		// TODO Auto-generated method stub
		return null;
	}

}
