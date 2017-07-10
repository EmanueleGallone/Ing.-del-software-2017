package it.polimi.ingsw.ps11.cards;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.ps11.controller.server.gameServer.PlayerFactory;
import it.polimi.ingsw.ps11.model.cards.effects.AddResourceEffect;
import it.polimi.ingsw.ps11.model.cards.effects.Effect;
import it.polimi.ingsw.ps11.model.cards.leaderCards.LeaderCard;
import it.polimi.ingsw.ps11.model.cards.leaderCards.requires.CardNumberRequirement;
import it.polimi.ingsw.ps11.model.cards.leaderCards.requires.Requirement;
import it.polimi.ingsw.ps11.model.cards.leaderCards.requires.ResourceRequirement;
import it.polimi.ingsw.ps11.model.cards.list.GreenCard;
import it.polimi.ingsw.ps11.model.cards.list.PurpleCard;
import it.polimi.ingsw.ps11.model.cards.list.YellowCard;
import it.polimi.ingsw.ps11.model.gameLogics.GameLogic;
import it.polimi.ingsw.ps11.model.gameLogics.StateHandler;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.model.resources.list.VictoryPoint;
import it.polimi.ingsw.ps11.model.resources.list.Wood;

public class LeaderCardTest {
	
	@Test
	public void Test(){
		LeaderCard card = new LeaderCard("LeaderCard");
		Effect effect = new AddResourceEffect(new ResourceList(new Wood(1)));
		card.addEffect(effect);
		
		Assert.assertEquals(1, card.getEffects().size());
		Assert.assertEquals(effect, card.getEffects().get(0));
		
		Assert.assertFalse(card.equals(null));
		
	}
	
	@Test
	public void isSatisfiedTet(){
		PlayerFactory factory = new PlayerFactory();
		Player player = factory.newPlayer(0); //il giocatore creato ha 5 coin
		
		LeaderCard card = new LeaderCard("LeaderCard");
		Requirement requirement = new ResourceRequirement(new ResourceList(new Coin(5)));
		
		Assert.assertTrue(card.isSatisfied(player)); //la card non ha requirements
		
		card.addRequirement(requirement); //aggiungo i requirements
		Assert.assertTrue(card.isSatisfied(player));
		
		LeaderCard clone = card.clone();
		HashMap<String, Integer> numberofCards = new HashMap<>();
		numberofCards.put(new PurpleCard().getId(), 1);
		clone.addRequirement(new CardNumberRequirement(numberofCards));
		
		player.getCardManager().addCard(new PurpleCard("PurpleCard"));
		Assert.assertTrue(clone.isSatisfied(player)); //la leaderCard puo' essere attivata
		
		clone.addRequirement(new ResourceRequirement(new ResourceList(new VictoryPoint(1))));
		Assert.assertTrue(clone.isSatisfied(player)); //i requisiti della carta non sono piu' soddisfatti ma siccome era già stata soddisfatta allora rimane tale
		
		Assert.assertTrue(clone.equals(card));
		
		LeaderCard anotherCard = new LeaderCard("anotherCard");
		anotherCard.addRequirement(new ResourceRequirement(new ResourceList(new MilitaryPoint(1))));
		Assert.assertFalse(anotherCard.isSatisfied(player));
		
		LeaderCard card2 = new LeaderCard("card2");
		card2.addRequirement(new CardNumberRequirement("PurpleCard", 8));
		Assert.assertFalse(card2.isSatisfied(player));
		
		anotherCard = new LeaderCard("newLeader");
		anotherCard.addRequirement(new ResourceRequirement(new ResourceList(new Coin(1))));
		Assert.assertTrue(anotherCard.isSatisfied(player));
		
		
	}
	
	@Test
	public void RequirementsTest(){
		PlayerFactory factory = new PlayerFactory();
		Player player = factory.newPlayer(0); //il giocatore creato ha 5 coin
		
		HashMap<String, Integer> numberofCards = new HashMap<>();
		numberofCards.put(new PurpleCard().getId(), 1);
		numberofCards.put(new YellowCard().getId(), 1);		
		
		LeaderCard card = new LeaderCard("leader");
		card.addRequirement(new CardNumberRequirement(numberofCards));
		Assert.assertFalse(card.isActivated());
		Assert.assertFalse(card.isSatisfied(player));
		
		Player player2 = factory.newPlayer(1);
		card = new LeaderCard("anotherCArd");
		player2.getCardManager().addCard(new PurpleCard());
		player2.getCardManager().addCard(new YellowCard()); //aggiungo le due carte per soddisfare i requirements
		card.addRequirement(new CardNumberRequirement(numberofCards));
		Assert.assertTrue(card.isSatisfied(player2)); //i requirements devono essere soddisfatti
	}
	
	@Test
	public void activeTest(){
		
		ArrayList<Player> players = initializePlayers();
		
		GameLogic gameLogic = new GameLogic(players);
		StateHandler stateHandler = gameLogic.getPlayerStatus().get(0);
		Player player = stateHandler.getPlayer();
		ActionManager aManager = stateHandler.actions();
		
		LeaderCard card = new LeaderCard("LeaderCard");
		card.addEffect(new AddResourceEffect(new ResourceList(new VictoryPoint(10))));
		card.active(aManager);
		
		Assert.assertEquals(10, player.getResourceList().get(new VictoryPoint().getId()).getValue());
	}
	
	private ArrayList<Player> initializePlayers(){
		PlayerFactory factory = new PlayerFactory();
		ArrayList<Player> players = new ArrayList<>();
		for(int i = 0; i < 4; i++)
			players.add(factory.newPlayer(i));
		
		return players;
	}
}
