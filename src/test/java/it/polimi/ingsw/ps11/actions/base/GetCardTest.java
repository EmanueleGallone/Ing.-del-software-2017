package it.polimi.ingsw.ps11.actions.base;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.ps11.model.cards.effects.AddResourceEffect;
import it.polimi.ingsw.ps11.model.cards.list.GreenCard;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.NeutralFamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.GameLogic;
import it.polimi.ingsw.ps11.model.gameLogics.StateHandler;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.ActiveYieldAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.GetCardAction;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.Servant;
import it.polimi.ingsw.ps11.model.resources.list.Stone;
import it.polimi.ingsw.ps11.model.resources.list.Wood;
import it.polimi.ingsw.ps11.model.zones.Floor;

public class GetCardTest {

	
	Player player;
	
	ArrayList<Player> players;
	
	FamilyMember familyMember;
			
	GameLogic gameLogic;
	GetCardAction action;
	StateHandler handler;
	ActionManager aManager;
	
	GreenCard card1, card2;
	ResourceList cost1, cost2;
	ArrayList<ResourceList> allCosts1, allCosts2;
	
	Floor floor1, floor2, emptyFloor;
	
	@Before
	public void setting(){
		
		player = new Player();
		players = new ArrayList<>();
		players.add(player);
		
		gameLogic = new GameLogic(players);
		handler = new StateHandler(gameLogic, player);
		aManager = handler.actions();
		
		familyMember = new NeutralFamilyMember();
		cost1 = new ResourceList(new Coin(3));
		cost2 = new ResourceList(new Coin(3), new Wood(3));
		
		allCosts1 = new ArrayList<>();
		allCosts1.add(cost1);
		card1 = new GreenCard();
		card1.setCosts(allCosts1);
		card1.addInstantEffect(new AddResourceEffect(new ResourceList(new Servant(1))));
		
		allCosts2 = new ArrayList<>();
		allCosts2.add(cost1);
		allCosts2.add(cost2);
		card2 = new GreenCard();
		card2.setCosts(allCosts2);
		
		player.getResourceList().setResource(new Coin(3), new Wood(2));
		
		floor1 = new Floor(card1);
		floor2 = new Floor(card2);
		emptyFloor = new Floor();
		
	}
	
	@Test
	public void isLegalTest(){
	
		action = new GetCardAction(aManager, floor2.getCard(), null);
		assertFalse(floor2.getCard().isMonoCost());
		assertFalse(action.isLegal());									//false per riga 43, is MultipleCost
		
		action = new GetCardAction(aManager, floor1.getCard(), floor1.getCard().getFirstCost());
		assertTrue(action.isLegal());									//true, la carta ha un solo costo fattibile
		
		action = new GetCardAction(aManager, floor2.getCard(), floor2.getCard().getCosts().get(0));
		assertTrue(action.isLegal());									//true, la carta ha due costi, il primo è fattibile
		
		action = new GetCardAction(aManager, floor2.getCard(), floor2.getCard().getCosts().get(1));
		assertFalse(action.isLegal());									//true, la carta ha due costi, il secondo non è fattibile
		
		player.getResourceList().setResource(new Coin(21));
		
		for(int i=0; i<6; i++){
			action = new GetCardAction(aManager, floor1.getCard(), floor1.getCard().getFirstCost());
			action.perform();
		}
		assertFalse(action.isLegal());									//false, ha risorse, ma non ha più spazio
		
	}
	
	@Test
	public void performTest(){
		
		action = new GetCardAction(aManager, floor1.getCard(), floor1.getCard().getFirstCost());
		assertTrue(action.isLegal());
		action.perform();
		assertEquals(0, new Coin().set(player.getResourceList()).getValue());
		assertEquals(2, new Wood().set(player.getResourceList()).getValue());
		assertEquals(1, new Servant().set(player.getResourceList()).getValue());
		
		assertEquals(card1 ,player.getCardManager().getCardList(GreenCard.class).get(0));

	}
	
}





























