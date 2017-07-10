package it.polimi.ingsw.ps11.actions.base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.ps11.controller.server.gameServer.PlayerFactory;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.NeutralFamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.GameLogic;
import it.polimi.ingsw.ps11.model.gameLogics.StateHandler;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.DoSeveralTimeAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.resources.DecrementAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.resources.IncrementAction;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.Resource;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;

public class DoSeveralTimesTest {

	private ArrayList<Player> initializePlayers(){
		PlayerFactory factory = new PlayerFactory();
		ArrayList<Player> players = new ArrayList<>();
		for(int i = 0; i < 4; i++)
			players.add(factory.newPlayer(i));
		
		return players;
	}
		
	@Test
	public void isLegalTest(){
		
		ArrayList<Player> players = initializePlayers();
		
		GameLogic gameLogic = new GameLogic(players);
		StateHandler stateHandler = gameLogic.getPlayerStatus().get(0);
		ActionManager aManager = stateHandler.actions();
		
		ResourceList bonus = new ResourceList(new Coin(3));

		IncrementAction actionTest = new IncrementAction(aManager, bonus);
		DoSeveralTimeAction action = new DoSeveralTimeAction(aManager, actionTest, 3);
		assertTrue(action.isLegal());
		
	}
	
	@Test
	public void performTest(){
		
		ArrayList<Player> players = initializePlayers();
		
		ResourceList bonus = new ResourceList(new Coin(3));
		ResourceList cost = new ResourceList(new Coin(4));
		
		GameLogic gameLogic = new GameLogic(players);
		StateHandler stateHandler = gameLogic.getPlayerStatus().get(0);
		Player player = gameLogic.getPlayerStatus().get(0).getPlayer();
		ActionManager aManager = stateHandler.actions();
		
		
		IncrementAction incrementAction = new IncrementAction(aManager, bonus);
		DecrementAction decrementAction = new DecrementAction(aManager, cost);

		DoSeveralTimeAction action = new DoSeveralTimeAction(aManager, incrementAction, 3);
		action.perform();
		assertEquals(17, new Coin().getFrom(aManager.state().getPlayer().getResourceList()).getValue());
		
		action = new DoSeveralTimeAction(aManager, decrementAction, 3);
		action.perform();
		assertEquals(5, new Coin().getFrom(aManager.state().getPlayer().getResourceList()).getValue());	//l'azione viene eseguia solo 2 volte perchè poi non è più legal

	}
}
