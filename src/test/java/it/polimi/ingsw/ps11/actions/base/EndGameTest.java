package it.polimi.ingsw.ps11.actions.base;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.NeutralFamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.GameLogic;
import it.polimi.ingsw.ps11.model.gameLogics.StateHandler;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.EndGameAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.resources.DecrementAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.resources.IncrementAction;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.Stone;
import it.polimi.ingsw.ps11.model.resources.list.Wood;

public class EndGameTest {

	Player player;
	
	ArrayList<Player> players;
	
	FamilyMember familyMember;
			
	GameLogic gameLogic;
	EndGameAction action;
	StateHandler handler;
	ActionManager aManager;
	
	ResourceList cost1, cost2;
	
	@Before
	public void setting(){
		
		player = new Player();
		players = new ArrayList<>();
		players.add(player);
		
		gameLogic = new GameLogic(players);
		handler = new StateHandler(gameLogic, player);
		aManager = handler.actions();
		
		familyMember = new NeutralFamilyMember("Neutral");
		cost1 = new ResourceList(new Coin(3));
		cost2 = new ResourceList(new Stone(3), new Wood(3));

		player.getResourceList().setResource(new Coin(3), new Wood(4), new Stone(4));
		
	}
	
	@Test
	public void isLegalTest(){
		
		action = new EndGameAction(aManager);
		assertTrue(action.isLegal());
		
	}
	
	@Test
	public void performTest(){
		
		IncrementAction action1 = new IncrementAction(aManager, cost1);
		DecrementAction action2 = new DecrementAction(aManager, cost2);
		DecrementAction action3 = new DecrementAction(aManager, cost2);

		assertEquals(3, player.getResourceList().get(Coin.class).getValue());
		assertEquals(4, player.getResourceList().get(Wood.class).getValue());
		assertEquals(4, player.getResourceList().get(Stone.class).getValue());
		
		action = new EndGameAction(aManager);
		action.add(action1);		//viene eseguita
		action.add(action2);		//viene eseguita
		action.add(action3);		//non viene eseguita
		
		action.perform();
		
		assertEquals(6, player.getResourceList().get(Coin.class).getValue());
		assertEquals(1, player.getResourceList().get(Wood.class).getValue());
		assertEquals(1, player.getResourceList().get(Stone.class).getValue());
		
	}
	
}
