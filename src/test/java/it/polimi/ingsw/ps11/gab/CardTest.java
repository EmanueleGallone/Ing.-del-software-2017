package it.polimi.ingsw.ps11.gab;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.ps11.cranio.cards.CardManager;
import it.polimi.ingsw.ps11.cranio.cards.list.BlueCard;
import it.polimi.ingsw.ps11.cranio.cards.list.GreenCard;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.resources.Resource;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.resources.list.Coin;

public class CardTest {
	
	
	public Player player1;
	public ArrayList<Resource> playerResources1;
	
	public Player player2;
	public ArrayList<Resource> playerResources2;
	
	public ArrayList<ResourceList> cost3coins;
	public ResourceList costs3;
	public BlueCard bCard;
	public GreenCard gCard;

	
	@Before
	public void setting(){
		playerResources1 = new ArrayList<>();
		playerResources1.add(new Coin(4));
		player1 = new Player(playerResources1);	//il player1 ha 4 gold

		
		playerResources2 = new ArrayList<>();
		playerResources2.add(new Coin(30));
		player2 = new Player(playerResources2);	//il player2 ha 21 gold

		
		costs3 = new ResourceList (new Coin(3));
		cost3coins = new ArrayList<>();


		bCard = new BlueCard();
		gCard = new GreenCard();
	}
	
	@Test
	public void addCardTest(){
		
		cost3coins.add(costs3);
		bCard.setCosts(cost3coins);		//la carta 1 costa 3 gold
		gCard.setCosts(cost3coins);
		
		assertTrue(bCard.checkCost(player1.getResourceList(), costs3));
		assertTrue(bCard.take(player1, costs3)); 		//il giocatore può prendere la carta 1 volta, poi non ha più risorse
		assertFalse(bCard.checkCost(player1.getResourceList(), costs3));
		assertFalse(bCard.take(player1, costs3));
		
		assertTrue(bCard.checkCost(player2.getResourceList(), costs3));
		assertTrue(bCard.take(player2, costs3)); 		//il giocatore può prendere la carta 6 volta, poi non ha più spazi
		assertTrue(bCard.take(player2, costs3));
		assertTrue(bCard.take(player2, costs3));
		assertTrue(bCard.take(player2, costs3));
		assertTrue(bCard.take(player2, costs3));
		assertTrue(bCard.take(player2, costs3));
		assertTrue(bCard.checkCost(player2.getResourceList(), costs3));
		assertFalse(bCard.take(player2, costs3));
		assertTrue(gCard.take(player2, costs3));		//può invece prendere una carta verde
		
	}

}
