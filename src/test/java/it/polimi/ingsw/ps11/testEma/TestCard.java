package it.polimi.ingsw.ps11.testEma;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import it.polimi.ingsw.ps11.model.bonus.GainResourceForEveryCardYouHave;
import it.polimi.ingsw.ps11.model.bonus.IncrementResourceBonus;
import it.polimi.ingsw.ps11.model.cards.CardManager;
import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.cards.list.GreenCard;
import it.polimi.ingsw.ps11.model.cards.list.PurpleCard;
import it.polimi.ingsw.ps11.model.cards.list.YellowCard;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.Stone;
import it.polimi.ingsw.ps11.model.resources.list.VictoryPoint;
import it.polimi.ingsw.ps11.model.resources.list.Wood;


public class TestCard {

	@Test
	public void equalsTest() {
		//anche clone
		ResourceList resourceList = new ResourceList();
		
		YellowCard esattoria = new YellowCard();
		esattoria.setActiveValue(5);
		esattoria.setPeriod(1);
		esattoria.setName("Esattoria");
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(3));
		esattoria.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(1));
		esattoria.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource( new VictoryPoint(5));
		esattoria.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(1));
		esattoria.addPermanentBonus(new GainResourceForEveryCardYouHave(GreenCard.class, resourceList.clone()));
		
		YellowCard arcoTrionfo = new YellowCard();
		arcoTrionfo.setActiveValue(6);
		arcoTrionfo.setPeriod(1);
		arcoTrionfo.setName("Arco di Trionfo");
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(2));
		arcoTrionfo.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(2));
		arcoTrionfo.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(6));
		arcoTrionfo.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(1));
		arcoTrionfo.addPermanentBonus(new GainResourceForEveryCardYouHave(PurpleCard.class, resourceList));
		
		Assert.assertFalse(esattoria.equals(arcoTrionfo));
		
		Assert.assertTrue(esattoria.equals(esattoria));
		
		YellowCard clone = esattoria.clone();
		
		Assert.assertTrue("should be true after the clone",esattoria.equals(clone));
		Assert.assertEquals(1, clone.getPeriod());
		
	}
	
	@Test
	public void cardManagerTest(){
		ArrayList<DevelopmentCard> cards = new ArrayList<>();
		GreenCard card1 = new GreenCard();
		card1.setName("TestGreenCard1");
		card1.setPeriod(1);
		cards.add(card1);
		PurpleCard card2 = new PurpleCard();
		card2.setName("TestPurpleCard2");
		card2.setPeriod(3);
		cards.add(card2);
		
		CardManager manager = new CardManager(cards); //gli passo un arraylis
		
		Assert.assertTrue(manager.getCardList(GreenCard.class).get(0).getPeriod() == 1);
		Assert.assertTrue(manager.getCardList(PurpleCard.class).get(0).getPeriod() == 3);
	}

}
