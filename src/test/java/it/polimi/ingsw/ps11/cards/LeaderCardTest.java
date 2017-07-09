package it.polimi.ingsw.ps11.cards;

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
import it.polimi.ingsw.ps11.model.cards.list.PurpleCard;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
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
	}
}
