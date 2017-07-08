package it.polimi.ingsw.ps11.actions.base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.ps11.model.gameLogics.GameLogic;
import it.polimi.ingsw.ps11.model.gameLogics.StateHandler;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.ExchangeAction;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.Wood;

public class ExchangeTest {
	
	Player player;
	
	ArrayList<Player> players;
				
	GameLogic gameLogic;
	ExchangeAction action;
	StateHandler handler;
	ActionManager aManager;
			
	ResourceList resourceListCoin, resourceListWood;
	HashMap<ResourceList, ResourceList> exchangelist;
	
	@Before
	public void setting(){
		
		player = new Player();
		players = new ArrayList<>();
		players.add(player);
		
		gameLogic = new GameLogic(players);
		handler = new StateHandler(gameLogic, player);
		aManager = handler.actions();
				
		resourceListCoin = new ResourceList(new Coin(3));
		resourceListWood = new ResourceList(new Wood(3));
		
		player.getResourceList().setResource(new Coin(3), new Wood(3));
		
		exchangelist = new HashMap<>();
	}
	
	@Test
	public void isLegalTest(){
		exchangelist.put(resourceListCoin, resourceListWood);
		action = new ExchangeAction(aManager, exchangelist);
		assertTrue(action.isLegal());
	}
	
	@Test
	public void performTest(){
		exchangelist.put(resourceListCoin, resourceListWood);
		action = new ExchangeAction(aManager, exchangelist);
		action.perform();
		
	}
	
	@Test
	public void updateTest(){
		
		exchangelist.put(resourceListCoin, resourceListWood);
		action = new ExchangeAction(aManager, exchangelist);
		action.update(resourceListCoin);
		assertEquals(0, new Coin().getFrom(aManager.state().getPlayer().getResourceList()).getValue());
		assertEquals(6, new Wood().getFrom(aManager.state().getPlayer().getResourceList()).getValue());
		
	}
}
