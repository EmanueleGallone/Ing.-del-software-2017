package it.polimi.ingsw.ps11.cards;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.ps11.model.cards.effects.AddResourceEffect;
import it.polimi.ingsw.ps11.model.cards.effects.Effect;
import it.polimi.ingsw.ps11.model.cards.list.BlueCard;
import it.polimi.ingsw.ps11.model.cards.list.GreenCard;
import it.polimi.ingsw.ps11.model.cards.list.PurpleCard;
import it.polimi.ingsw.ps11.model.loaders.InitializeCards;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.Resource;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.Stone;
import it.polimi.ingsw.ps11.model.resources.list.Wood;

public class DevelopmentCardTest {

	private ArrayList<Resource> arrayListResource1, arrayListResource2;
	private ResourceList resourceList2;

	private Coin coin;
	private Stone stone;
	private Wood wood;

	private BlueCard bCard1, bCard2;
	private GreenCard gCard;
	
	@Before
	public void setting(){
		
		coin = new Coin(1);
		stone = new Stone(1);
		wood = new Wood(1);

		arrayListResource1 = new ArrayList<>();
		arrayListResource2 = new ArrayList<>();
		resourceList2 = new ResourceList();
		
	}
	
	@Test
	public void isMonoCostTest(){
		
		arrayListResource1.add(coin);
		arrayListResource2.add(wood);
		arrayListResource2.add(stone);
		
		resourceList2 = new ResourceList(arrayListResource2);
		
		bCard1 = new BlueCard();
		assertTrue(bCard1.isMonoCost());					//la carta non ha resourcelist costo
		bCard1.addCost(resourceList2);	
		assertTrue(bCard1.isMonoCost());					//la carta ha una resourceList con più tipi di risorse come costo
		bCard1.addCost(resourceList2);
		assertFalse(bCard1.isMonoCost());
		
		Assert.assertEquals(resourceList2, bCard1.getFirstCost());
		
	}
	
	
	@Test
	public void equalsTest(){
		
		bCard1 = new BlueCard("1");
		bCard2 = new BlueCard("2");
		gCard = new GreenCard("1");
		assertFalse(bCard1.equals(bCard2));					//stesso tipo, nome diverso
		assertFalse(bCard1.equals(gCard));					//stesso nome, tipo diverso
		bCard2 = new BlueCard("1");
		assertTrue(bCard1.equals(bCard2));					//stesso nome e stesso tipo	
		
		PurpleCard card = new PurpleCard("PurpleCard");
		card.addCost(new ResourceList(new Stone(1)));
		
		Assert.assertFalse(card.equals(new PurpleCard("otherPurple")));
		
		GreenCard card2 = new GreenCard("GreenCard");
		Assert.assertFalse(card2.equals(null));
		Assert.assertFalse(card2.equals(new GreenCard()));
		
	}
	
	@Test
	public void effectTest(){
		Effect effect = new AddResourceEffect(new ResourceList(new Coin(1),new Stone(1)));
		
		BlueCard blueCard = new BlueCard("blueCard");
		blueCard.addInstantEffect(effect);
		
		Assert.assertEquals(new ResourceList(), blueCard.getFirstCost()); //deve essere una resourceList vuota
		
		Assert.assertEquals(0, blueCard.getPeriod()); //periodo non settato
		blueCard.setPeriod(1);
		Assert.assertEquals(1, blueCard.getPeriod()); //periodo settato
		
		Assert.assertEquals(effect, blueCard.getInstantEffect().get(0)); //test dell'effetto
		Assert.assertEquals(0, blueCard.getActiveValue()); //test sull'activeValue
		Assert.assertEquals(0, blueCard.getCosts().size()); // non deve avere risorse all'interno
		
		ResourceList resourceList = new ResourceList(new Stone(1));
		
		blueCard.addCost(resourceList.clone());
		Assert.assertEquals(1, blueCard.getCosts().size()); // deve avere un costo
		
		blueCard.addPermanentEffect(effect); //per coprire il metodo addPermanentEffect
		Assert.assertEquals(effect, blueCard.getPermanentEffect().get(0));
		
		String toString = blueCard.toString();
		BlueCard clone = blueCard.clone();
		Assert.assertEquals(toString, blueCard.toString());
		
	}
	
	@Test
	public void cloneTest(){
		PurpleCard card = new PurpleCard("PurpleCard");
		card.addCost(new ResourceList(new Stone(1)));
		PurpleCard clone = card.clone();
		card.setActiveValue(1);
		
		Assert.assertEquals(card, clone); //devono essere uguali (avere nomi uguali)
		Assert.assertFalse(card.equals(null));
		
		GreenCard card2 = new GreenCard("GreenCard");
		GreenCard cloneGreenCard = card2.clone();
		
		Assert.assertFalse(card.equals(card2));
		Assert.assertTrue(card2.equals(cloneGreenCard));
	}
}