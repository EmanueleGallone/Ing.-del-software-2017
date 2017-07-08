package it.polimi.ingsw.ps11.actions.base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.NeutralFamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.GameLogic;
import it.polimi.ingsw.ps11.model.gameLogics.StateHandler;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.DoSeveralTimeAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.resources.DecrementAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.resources.IncrementAction;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;

public class DoSeveralTimesTest {

	Player player;
	
	ArrayList<Player> players;
	
	FamilyMember familyMember;
			
	GameLogic gameLogic;
	DoSeveralTimeAction action;
	StateHandler handler;
	ActionManager aManager;
	
	ResourceList bonus, cost;
	
	@Before
	public void setting(){
		
		player = new Player();
		players = new ArrayList<>();
		players.add(player);
		
		gameLogic = new GameLogic(players);
		handler = new StateHandler(gameLogic, player);
		aManager = handler.actions();
		
		familyMember = new NeutralFamilyMember();
		bonus = new ResourceList(new Coin(3));
		cost = new ResourceList(new Coin(4));

		player.getResourceList().setResource(new Coin(1));
		
	}
	
	@Test
	public void isLegalTest(){
		
		IncrementAction actionTest = new IncrementAction(aManager, bonus);
		action = new DoSeveralTimeAction(aManager, actionTest, 3);
		assertTrue(action.isLegal());
		
	}
	
	@Test
	public void performTest(){
		
		IncrementAction incrementAction = new IncrementAction(aManager, bonus);
		DecrementAction decrementAction = new DecrementAction(aManager, cost);

		action = new DoSeveralTimeAction(aManager, incrementAction, 3);
		action.perform();
		assertEquals(10, new Coin().set(aManager.state().getPlayer().getResourceList()).getValue());
		
		action = new DoSeveralTimeAction(aManager, decrementAction, 3);
		action.perform();
		assertEquals(2, new Coin().set(aManager.state().getPlayer().getResourceList()).getValue());	//l'azione viene eseguia solo 2 volte perchè poi non è più legal

	}
}
