package it.polimi.ingsw.ps11.cards;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.ps11.model.cards.list.BlueCard;
import it.polimi.ingsw.ps11.model.cards.list.GreenCard;
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
		
	}
}