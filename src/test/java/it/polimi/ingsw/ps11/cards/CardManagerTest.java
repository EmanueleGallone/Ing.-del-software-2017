package it.polimi.ingsw.ps11.cards;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.ps11.controller.server.gameServer.PlayerFactory;
import it.polimi.ingsw.ps11.model.cards.CardManager;
import it.polimi.ingsw.ps11.model.cards.leaderCards.LeaderCard;
import it.polimi.ingsw.ps11.model.cards.list.BlueCard;
import it.polimi.ingsw.ps11.model.cards.list.GreenCard;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.Resource;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.Servant;
import it.polimi.ingsw.ps11.model.resources.list.Stone;
import it.polimi.ingsw.ps11.model.resources.list.Wood;

public class CardManagerTest {

	private ArrayList<ResourceList> arrayListResourceList1;
	private ArrayList<Resource> arrayListResource1;
	private ResourceList resourceList1;

	private Coin coin1, coin7;
	private Servant servant;
	private Stone stone;
	private Wood wood;

	private BlueCard bCard;
	
	private Player player;
	private ArrayList<Resource> arrayListResourcePlayer;
	
	@Before
	public void setting(){
		
		coin1 = new Coin(1); coin7 = new Coin(7);
		servant = new Servant();
		stone = new Stone();
		wood = new Wood();

		arrayListResourceList1 = new ArrayList<>();
		arrayListResource1 = new ArrayList<>();
		resourceList1 = new ResourceList();

		arrayListResourcePlayer = new ArrayList<>();
		arrayListResourcePlayer.add(coin7);
		arrayListResourcePlayer.add(servant);
		arrayListResourcePlayer.add(stone);
		arrayListResourcePlayer.add(wood);
		
		bCard = new BlueCard();

		//player = new Player(arrayListResourcePlayer);
		
	}
	@Test
	public void canAddAndAddTest(){
		
		arrayListResource1.add(coin1);
		arrayListResourceList1.add(resourceList1);
		
		bCard.setCosts(arrayListResourceList1);
		PlayerFactory factory = new PlayerFactory();
		player = factory.newPlayer(0);
		
		for(int i = 0; i<6; i++){
			assertTrue(player.getCardManager().canAdd(bCard));			//player ha 7 coin, la carta costa 1 coin, può prendere la carta		
			assertTrue(player.getCardManager().addCard(bCard));			//solo 6 volte, poi finisce lo spazio
		}
		assertFalse(player.getCardManager().canAdd(bCard));
		assertFalse(player.getCardManager().addCard(bCard));			//il player ha ancora risorse ma non spazi
		
		assertTrue(player.getCardManager().isLimited());				//infattiisLimited
		
		
	}
	
	@Test
	public void cloneTest(){
		PlayerFactory factory = new PlayerFactory();
		player = factory.newPlayer(0);
		
		player.getCardManager().addCard(new LeaderCard("LeaderCard"));
		player.getCardManager().addCard(new BlueCard("Bluecard"));
		
		CardManager cardManager = new CardManager(false);
		Assert.assertFalse(cardManager.isLimited()); //non deve essere limitato (cioe' deve poter contenere un numero di carte illimitato)
		Assert.assertEquals(0 , cardManager.getCardList(new GreenCard().getId()).size()); //deve ritornare un arraylist vuoto
		
		CardManager clone = player.getCardManager().clone();
		Assert.assertEquals(1, clone.getAllCards().size()); //c'è un solo arrayList di carte, ovvero le blu
		Assert.assertEquals(1, clone.getCardList(bCard.getId()).size()); //c'e' una sola carta blu
		
		String toString = player.getCardManager().toString();
		Assert.assertEquals(toString, clone.toString());
		
	}
}
