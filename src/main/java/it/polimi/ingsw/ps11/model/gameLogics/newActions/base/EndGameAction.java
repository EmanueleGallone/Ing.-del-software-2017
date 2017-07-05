package it.polimi.ingsw.ps11.model.gameLogics.newActions.base;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.gameLogics.newActions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.newActions.ActionManager;
/** <h3> EndGameAction </h3>
 * <p> E' l'azione da compiere per terminare il Game. Al suo interno contiene una serie di azioni da fare alla fine della partita.</p>
 * @see Action
 */
public class EndGameAction implements Action {

	private ActionManager aManager;
	private ArrayList<Action> doAtTheEnd = new ArrayList<>();
	
	public EndGameAction(ActionManager actionManager) {
		this.aManager = actionManager;
	}
	
	public EndGameAction(ActionManager aManager, ArrayList<Action> doAtTheEnd) {
		this.doAtTheEnd = doAtTheEnd;
	}
	
	@Override
	public boolean isLegal() {
		return true;
	}

	@Override
	public void perform() {
		for(Action action : doAtTheEnd){
			Action a = aManager.affect(action);
			if(action.isLegal())
				action.perform();
		}
	}
	
	public void add(Action action){
		this.doAtTheEnd.add(action);
	}

	@Override
	public Action clone() {
		return new EndGameAction(aManager, doAtTheEnd);
	}

}
