package it.polimi.ingsw.ps11.actions.base;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import it.polimi.ingsw.ps11.controller.server.gameServer.PlayerFactory;
import it.polimi.ingsw.ps11.model.gameLogics.GameLogic;
import it.polimi.ingsw.ps11.model.gameLogics.StateHandler;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.ChangeStateAction;
import it.polimi.ingsw.ps11.model.gameLogics.states.DefaultState;
import it.polimi.ingsw.ps11.model.player.Player;

public class ChangeStateTest {

	@Test
	public void test(){
		PlayerFactory playerFactory = new PlayerFactory();
		ArrayList<Player> players = playerFactory.takeAll();
		
		GameLogic gameLogic = new GameLogic(players);
		StateHandler stateHandler = gameLogic.getPlayerStatus().get(0);
		ActionManager aManager = stateHandler.actions();
		DefaultState state = new DefaultState();
		ChangeStateAction action = new ChangeStateAction(aManager, state);
		assertTrue(action.isLegal());
		action.perform();
	}
	
}
