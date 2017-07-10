package it.polimi.ingsw.ps11.model.gameLogics.actions.endGame;

import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.reflect.TypeToken;

import it.polimi.ingsw.ps11.model.FileRegistry;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.NeedManager;
import it.polimi.ingsw.ps11.model.loaders.Loader;
/** <h3> EndGameAction </h3>
 * <p> Azione da compiere per terminare il Game. Al suo interno può contenere una serie di azioni da fare alla fine della partita.</p>
 * @see Action
 */
public class EndGameAction implements Action {

	private ActionManager aManager;
	private ArrayList<Action> doAtTheEnd = new ArrayList<>();
	
	public EndGameAction(ActionManager actionManager) {
		this.aManager = actionManager;
		loadDefaultAction();
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
			if(a.isLegal())
				a.perform();
		}
	}
	
	public void add(Action action){
		this.doAtTheEnd.add(action);
	}
	

	private void loadDefaultAction(){
		try {
			
			Type type = new TypeToken<ArrayList<NeedManager>>(){}.getType();
			ArrayList<NeedManager> defaultDoAtTheEnd = new Loader(FileRegistry.endActions).load(type);
			
			for(NeedManager endAction : defaultDoAtTheEnd){
				endAction.setManager(aManager);
			}
			
			doAtTheEnd.addAll(defaultDoAtTheEnd);
			
		} catch (FileNotFoundException | ClassCastException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public Action clone() {
		return new EndGameAction(aManager, doAtTheEnd);
	}

}
