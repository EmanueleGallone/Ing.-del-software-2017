package it.polimi.ingsw.ps11.gab;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.ps11.model.resources.Resource;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.CouncilPrivilege;
import it.polimi.ingsw.ps11.model.resources.list.FaithPoint;
import it.polimi.ingsw.ps11.model.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.model.resources.list.Servant;
import it.polimi.ingsw.ps11.model.resources.list.Stone;
import it.polimi.ingsw.ps11.model.resources.list.VictoryPoint;
import it.polimi.ingsw.ps11.model.resources.list.Wood;

public class ResourcesPackageTest {

	ResourceList emptyResourceList;
	ResourceList resourceListCoin;
	ResourceList resourceListServant;
	ResourceList resourceListStone;
	ResourceList resourceListWood;
	
	ResourceList mixed1, mixed2;
	
	Coin coin;
	Servant servant;
	Stone stone;
	Wood wood;

	CouncilPrivilege councilPrivilege;
	FaithPoint faithPoint;
	MilitaryPoint militaryPoint;
	VictoryPoint victoryPoint;

	@Before
	public void setting(){
		
		coin = new Coin(1);
		servant = new Servant(1);
		stone = new Stone(1);
		wood = new Wood(1);
		
		ArrayList<Resource> mixedResources1 = new ArrayList<>();
		ArrayList<Resource> mixedResources2 = new ArrayList<>();
		mixedResources1.add(coin);
		mixedResources1.add(wood);
		mixedResources2.add(coin);
		mixedResources2.add(stone);
		
		emptyResourceList = new ResourceList();
		resourceListCoin = new ResourceList(coin);
		resourceListServant = new ResourceList(servant);
		resourceListStone = new ResourceList(stone);
		resourceListWood = new ResourceList(wood);
		
		mixed1 = new ResourceList(mixedResources1);		//UNA COIN E UN WOOD
		mixed2 = new ResourceList(mixedResources2);		//UNA COIN E UNA STONE

		councilPrivilege = new CouncilPrivilege(1);
		faithPoint = new FaithPoint(1);
		militaryPoint = new MilitaryPoint(1);
		victoryPoint = new VictoryPoint(1);
		
	}
	
	@Test
	public void ResourceTest(){
		
		int increment = 1;
		coin.increment(increment);
		servant.increment(increment);
		stone.increment(increment);
		wood.increment(increment);
		
		Coin coinTest = new Coin();
		Servant servantTest = new Servant();
		Stone stoneTest = new Stone();
		Wood woodTest = new Wood();
		
		assertEquals(2, coin.getValue());
		assertEquals(2, servant.getValue());
		assertEquals(2, stone.getValue());
		assertEquals(2, wood.getValue());
		
		assertTrue(coin.equals(coin.clone()));
		assertTrue(servant.equals(servant.clone()));
		assertTrue(stone.equals(stone.clone()));
		assertTrue(wood.equals(wood.clone()));
		
		assertFalse(coin.equals(wood));
		assertFalse(servant.equals(coin));
		assertFalse(stone.equals(servant));
		assertFalse(wood.equals(stone));
		
		assertFalse(coin.equals(coinTest));
		assertFalse(servant.equals(servantTest));
		assertFalse(stone.equals(stoneTest));
		assertFalse(wood.equals(woodTest));
		
		coinTest.setValue(2);
		servantTest.setValue(2);
		stoneTest.setValue(2);
		woodTest.setValue(2);
		
		assertTrue(coin.equals(coinTest));
		assertTrue(servant.equals(servantTest));
		assertTrue(stone.equals(stoneTest));
		assertTrue(wood.equals(woodTest));

	}
	
	@Test
	public void GreaterEqualsTest(){
		
		ResourceList resourceListCoinTest = new ResourceList(new Coin(2));
		
		assertFalse(resourceListCoin.greaterEquals(resourceListCoinTest));	//RESOURCE LIST CON RESOURCE DELLO STESSO TIPO GUARDANO AL VALORE
		assertTrue(resourceListCoinTest.greaterEquals(resourceListCoin));

		assertFalse(emptyResourceList.greaterEquals(resourceListCoin));		//OGNI RESOURCE LIST E' >= DI QUELLA VUOTA
		assertTrue(resourceListCoin.greaterEquals(emptyResourceList));
		
		assertTrue(resourceListCoin.greaterEquals(resourceListWood));		//RESOURCELIST CON RESOURCES DIVERSE SONO UNA >= DELL'ATLRA
		assertTrue(resourceListWood.greaterEquals(resourceListCoin));
		assertTrue(mixed1.greaterEquals(mixed2));
		assertTrue(mixed2.greaterEquals(mixed1));
		
		assertTrue(resourceListCoin.greaterEquals(resourceListCoin));		//OGNI RESOURCELIST è >= A SE STESSA
		assertTrue(emptyResourceList.greaterEquals(emptyResourceList));
		assertTrue(resourceListCoin.greaterEquals(resourceListCoin.clone()));

	}
	
	@Test
	public void SumTest(){
		
		resourceListCoin.sum(resourceListCoin);
		assertEquals(2, resourceListCoin.getValueOf(Coin.class));			//SOMMA DI RESOURCES UGUALI SOMMA I VALORI
		
		resourceListCoin.sum(resourceListServant);							//SOMMA DI RESOURCES DIVERSE COPIA IL VALORE IN QUELLO NULLO
		assertEquals(1, resourceListCoin.getValueOf(Servant.class));
		
		ResourceList resourceListClone = resourceListCoin.clone();		
		resourceListClone.sum(emptyResourceList);
		assertEquals(resourceListCoin, resourceListClone);
		
	}
	
	@Test
	public void canSubstractTest(){
		
		ResourceList test = new ResourceList(new Coin(2));
		assertFalse(resourceListCoin.canSubtract(test));				//STESSA RISORSA, VALORI DIVERSI
		assertTrue(test.canSubtract(resourceListCoin));
		
		assertFalse(emptyResourceList.canSubtract(resourceListCoin));	//RESOURCELIST VUOTA
		assertTrue(resourceListCoin.canSubtract(emptyResourceList));
		
		assertTrue(resourceListCoin.canSubtract(resourceListCoin));		//OGNI RESOURCELIST CANSUBSTRACT SE STESSA
		assertFalse(resourceListCoin.canSubtract(resourceListServant));	//RESOURCES DIVERSE CANTSUBSTRACT
		assertFalse(mixed1.canSubtract(mixed2));
		
	}
	
	@Test
	public void SubstractTest(){
		
		Coin coinTest = new Coin(2);
		ResourceList test = new ResourceList(coinTest);
		test.subtract(resourceListCoin);								//SOTTRAZIONE TRA STESSE RESOURCES SOTTRAZIONE TRA VALORI
		assertEquals(1, test.getValueOf(Coin.class));
		
		test.setResource(coinTest);										//1-2=0 0 MINIMO VALORE
		resourceListCoin.subtract(test);
		assertEquals(0, resourceListCoin.getValueOf(Coin.class));
		
		test.subtract(mixed1);											//RISORSE DIVERSE, TEST HA 0 WOOD, MIXED 1, TEST RESTA CON 0 WOOD
		assertEquals(1, test.getValueOf(Coin.class));
		assertEquals(0, test.getValueOf(Wood.class));	
		
		resourceListCoin.setResource(test.getResource(Coin.class));	
		test.subtract(emptyResourceList);
		assertEquals(resourceListCoin, test);
	}
	
	@Test
	public void CloneAndEqualsTest(){
		
		ResourceList test = emptyResourceList.clone();
		assertTrue(test.equals(emptyResourceList));
		
		test = resourceListCoin.clone();
		assertTrue(test.equals(resourceListCoin));
		
		test = mixed1.clone();
		assertTrue(test.equals(mixed1));
		
		emptyResourceList.sum(resourceListCoin);
		emptyResourceList.sum(resourceListWood);
		assertTrue(emptyResourceList.equals(mixed1));

	}
}
