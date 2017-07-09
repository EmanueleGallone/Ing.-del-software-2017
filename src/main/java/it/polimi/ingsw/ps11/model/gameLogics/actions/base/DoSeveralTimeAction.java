package it.polimi.ingsw.ps11.model.gameLogics.actions.base;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
/** <h3> DoSeveralTimesAction </h3>
 * <p> Azione che permette di ripetere un' <code>action</code> un certo numero di volte.</p>
 * @see Action
 */
public class DoSeveralTimeAction implements Action{

	private ActionManager aManager;
	private Action action;
	private int iterationNumber;
	
	public DoSeveralTimeAction(ActionManager aManager, Action action, int iterationNumber) {
		this.aManager = aManager;
		this.action = action;
		this.iterationNumber = iterationNumber;
	}
	
	
	@Override
	public boolean isLegal() {
		return true;
	}

	@Override
	public void perform() {
		for(int i = 0; i < iterationNumber; i++){
			if(action.isLegal())
				action.perform();
		}
	}

//	@Override
//	public DoSeveralTimeAction clone() {
//		return new DoSeveralTimeAction(aManager, action.clone(), iterationNumber);
//	}

}
