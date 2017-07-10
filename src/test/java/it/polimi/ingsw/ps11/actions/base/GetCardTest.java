package it.polimi.ingsw.ps11.actions.base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import it.polimi.ingsw.ps11.controller.server.gameServer.PlayerFactory;
import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.cards.effects.AddResourceEffect;
import it.polimi.ingsw.ps11.model.cards.list.GreenCard;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.gameLogics.GameLogic;
import it.polimi.ingsw.ps11.model.gameLogics.StateHandler;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.GetCardAction;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.Servant;
import it.polimi.ingsw.ps11.model.resources.list.Wood;
import it.polimi.ingsw.ps11.model.zones.Floor;

public class GetCardTest {

	private ArrayList<Player> initializePlayers(){
		PlayerFactory factory = new PlayerFactory();
		ArrayList<Player> players = new ArrayList<>();
		for(int i = 0; i < 4; i++)
			players.add(factory.newPlayer(i));
		
		return players;
	}
	
	@Test
	public void isLegalTest(){
		
		ResourceList cost1 = new ResourceList(new Coin(3));
		ResourceList cost2 = new ResourceList(new Coin(3), new Wood(3));
		
		ArrayList<ResourceList> allCosts1 = new ArrayList<>();
		allCosts1.add(cost1);
		DevelopmentCard card1 = new GreenCard();
		card1.setCosts(allCosts1);
		card1.addInstantEffect(new AddResourceEffect(new ResourceList(new Servant(1))));
		
		ArrayList<ResourceList> allCosts2 = new ArrayList<>();
		allCosts2.add(cost1);
		allCosts2.add(cost2);
		DevelopmentCard card2 = new GreenCard();
		card2.setCosts(allCosts2);
		
		Floor floor1 = new Floor();
		Floor floor2 = new Floor();
		floor1.setCard(card1);
		floor2.setCard(card2);
		
		ArrayList<Player> players = initializePlayers();
		
		GameLogic gameLogic = new GameLogic(players);
		StateHandler stateHandler = gameLogic.getPlayerStatus().get(0);
		ActionManager aManager = stateHandler.actions();
		Player player = gameLogic.getPlayerStatus().get(0).getPlayer();
	
		GetCardAction action = new GetCardAction(aManager, floor2.getCard(), null);
		assertFalse(floor2.getCard().isMonoCost());
		assertFalse(action.isLegal());									//false per riga 43, is MultipleCost		
		
		GetCardAction action2 = new GetCardAction(aManager, floor1, cost1);
		
		action = new GetCardAction(aManager, floor1.getCard(), floor1.getCard().getFirstCost());
		assertTrue(action.isLegal());									//true, la carta ha un solo costo fattibile
		
		assertEquals(card1, action.getCard());
		assertEquals(cost1, action.getCost());
		action.addDiscount(cost1);
		action.setCost(cost1);
				
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
		
		Floor floor = new Floor();
		action = new GetCardAction(aManager, floor.getCard(), cost1);
		assertFalse(action.isLegal());
	}
	
	@Test
	public void performTest(){
		
		ArrayList<Player> players = initializePlayers();
		
		GameLogic gameLogic = new GameLogic(players);
		StateHandler stateHandler = gameLogic.getPlayerStatus().get(0);
		Player player = gameLogic.getPlayerStatus().get(0).getPlayer();
		ActionManager aManager = stateHandler.actions();
		
		ResourceList cost1 = new ResourceList(new Coin(3));
		
		ArrayList<ResourceList> allCosts1 = new ArrayList<>();
		allCosts1.add(cost1);
		DevelopmentCard card1 = new GreenCard();
		card1.setCosts(allCosts1);
		card1.addInstantEffect(new AddResourceEffect(new ResourceList(new Servant(1))));
		
		player.getResourceList().setResource(new Coin(3), new Wood(2));
		
		Floor floor1 = new Floor();
		floor1.setCard(card1);
		
		GetCardAction action = new GetCardAction(aManager, floor1.getCard(), floor1.getCard().getFirstCost());
		assertTrue(action.isLegal());
		action.perform();
		assertEquals(0, new Coin().getFrom(player.getResourceList()).getValue());
		assertEquals(2, new Wood().getFrom(player.getResourceList()).getValue());
		assertEquals(4, new Servant().getFrom(player.getResourceList()).getValue());
		
		assertEquals(card1 ,player.getCardManager().getCardList(new GreenCard().getId()).get(0));
		
	}
	
}





























