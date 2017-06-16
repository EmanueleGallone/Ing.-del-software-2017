package it.polimi.ingsw.ps11.testEma;

import org.junit.Assert;
import org.junit.Test;

import it.polimi.ingsw.ps11.cranio.bonus.GainResourceForEveryCardYouHave;
import it.polimi.ingsw.ps11.cranio.bonus.IncrementResourceBonus;
import it.polimi.ingsw.ps11.cranio.cards.list.GreenCard;
import it.polimi.ingsw.ps11.cranio.cards.list.PurpleCard;
import it.polimi.ingsw.ps11.cranio.cards.list.YellowCard;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.resources.list.Coin;
import it.polimi.ingsw.ps11.cranio.resources.list.Stone;
import it.polimi.ingsw.ps11.cranio.resources.list.VictoryPoint;
import it.polimi.ingsw.ps11.cranio.resources.list.Wood;

public class TestEqualsCard {

	@Test
	public void test() {
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
		
		Assert.assertTrue(esattoria.equals(clone));
	}

}
