package it.polimi.ingsw.ps11.actions.base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.ps11.model.cards.effects.AddResourceEffect;
import it.polimi.ingsw.ps11.model.cards.list.BlueCard;
import it.polimi.ingsw.ps11.model.cards.list.GreenCard;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.NeutralFamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.GameLogic;
import it.polimi.ingsw.ps11.model.gameLogics.StateHandler;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.ActiveYieldAction;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.Wood;
import it.polimi.ingsw.ps11.model.zones.yield.Yield;

public class ActiveYieldTest {

	Player player;
	
	ArrayList<Player> players;
	
	FamilyMember familyMember;
			
	GameLogic gameLogic;
	ActiveYieldAction action;
	StateHandler handler;
	ActionManager aManager;
		
	Yield harvest;
	GreenCard card1, card2;
	BlueCard card3;
	
	ResourceList resourceListCoin, resourceListWood;
	
	@Before
	public void setting(){
		
		player = new Player();
		players = new ArrayList<>();
		players.add(player);
		
		gameLogic = new GameLogic(players);
		handler = new StateHandler(gameLogic, player);
		aManager = handler.actions();
		
		familyMember = new NeutralFamilyMember();
		
		//harvest = new Yield(GreenCard.class);
		resourceListCoin = new ResourceList(new Coin(3));
		resourceListWood = new ResourceList(new Wood(3));
		
		card3 = new BlueCard();
		card3.addPermanentEffect(new AddResourceEffect(resourceListCoin));
		player.getCardManager().addCard(card3);
		
		card1 = new GreenCard();
		card1.addPermanentEffect(new AddResourceEffect(resourceListCoin));
		card1.setActiveValue(2);
		player.getCardManager().addCard(card1);
		
		card2 = new GreenCard();
		card2.addPermanentEffect(new AddResourceEffect(resourceListWood));
		card2.setActiveValue(4);
		player.getCardManager().addCard(card2);
		
		player.getResourceList().setResource(new Coin(1), new Wood(1));
	}
	
	@Test
	public void isLegalTest(){
		
		action = new ActiveYieldAction(aManager, "GreenCard", 0);
		assertTrue(action.isLegal());							//sempre true
	}
	
	@Test
	public void performTest(){
		
		action = new ActiveYieldAction(aManager, GreenCard.class.toString(), 3);
		action.perform();

		assertEquals(4, new Coin().getFrom(player.getResourceList()).getValue());
		assertEquals(1, new Wood().getFrom(player.getResourceList()).getValue());

	}	
	@Test
	public void activeTest(){
		//incluso  nel performTest
	}
	
}
