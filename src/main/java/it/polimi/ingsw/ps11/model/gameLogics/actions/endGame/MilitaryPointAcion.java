package it.polimi.ingsw.ps11.model.gameLogics.actions.endGame;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.Resource;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.model.resources.list.VictoryPoint;
/**
 * <h3>MilitaryPointAction</h3>
 * <p> Classe che rappresenta l'azione che aggiunge punti vittoria a fine partita in base alla classifica dei punti militari.</p>
 * @version 1.0
 */
public class MilitaryPointAcion implements Action {

	private ActionManager aManager;
	private ResourceList bonus = new ResourceList(new VictoryPoint(5));
	
	public MilitaryPointAcion(ActionManager aManager) {
		this.aManager = aManager;
	}
	
	@Override
	public boolean isLegal() {
		return true;
	}

	@Override
	public void perform() {
		//Da rivedere
		Game game = aManager.state().getGame();
		ArrayList<Player> players = game.getRoundManager().getCurrentOrder();
		
		Player first = getMax(players, MilitaryPoint.class.toString());
		players.remove(first);
		Player second = getMax(players, MilitaryPoint.class.toString());
		
		//Incompleto, bisogna gestre i casi di parimerito al primo e al secondo posto
		first.getResourceList().sum(new ResourceList(new VictoryPoint(5)));
		second.getResourceList().sum(new ResourceList(new VictoryPoint(2)));

	}

	private Player getMax(ArrayList<Player> list, String parameter){
		
		Player max = getFirstPlayer(list, parameter);
		if(max == null)
			return max;
		
		for(Player player : list){
			Resource maxResource = max.getResourceList().get(parameter);
			Resource r = player.getResourceList().get(parameter);
			if(r!= null &&  r.getValue() > maxResource.getValue()){
				max = player;
			}
		}
		return max;
	}
	
	
	private Player getFirstPlayer(ArrayList<Player> list, String parameter){
		for(Player player : list){
			Resource r = player.getResourceList().get(parameter);
			if(r!= null){
				return player;
			}
		}
		return null;
	}
	
	@Override
	public MilitaryPointAcion clone() {
		return new MilitaryPointAcion(aManager);
	}

}
