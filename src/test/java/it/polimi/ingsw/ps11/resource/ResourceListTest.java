package it.polimi.ingsw.ps11.resource;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import it.polimi.ingsw.ps11.model.resources.Resource;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.FaithPoint;
import it.polimi.ingsw.ps11.model.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.model.resources.list.Servant;
import it.polimi.ingsw.ps11.model.resources.list.Stone;
import it.polimi.ingsw.ps11.model.resources.list.VictoryPoint;
import it.polimi.ingsw.ps11.model.resources.list.Wood;

public class ResourceListTest {

	ArrayList<Resource> arrayListResource1, arrayListResource2;
	ResourceList resourceList1, resourceList2, resourceListNegative;
	Coin coin1, coin3, coinNegative;
	Wood wood1, wood3;
	Stone stone1, stone3;
	Servant servant1, servant3;
	VictoryPoint victory1, victory3;
	
	@Before
	public void setting(){
		
		coin1 = new Coin(1); coin3 = new Coin(3); coinNegative = new Coin(-1);
		wood1 = new Wood(1); wood3 = new Wood(3);
		stone1 = new Stone(1); stone3 = new Stone(3);
		servant1 = new Servant(1); servant3 = new Servant(3);
		victory1 = new VictoryPoint(1); victory3 = new VictoryPoint(3);
		
		arrayListResource1 = new ArrayList<>();
		arrayListResource2 = new ArrayList<>();
		
		resourceListNegative = new ResourceList(coinNegative);
		
	}
	
	@Test
	public void sumTest(){
		
		arrayListResource1.add(coin3);
		arrayListResource1.add(wood3);
		arrayListResource1.add(victory1);
		
		arrayListResource2.add(coin1);
		arrayListResource2.add(servant1);
		arrayListResource2.add(victory3);
		
		resourceList1 = new ResourceList(arrayListResource1);
		resourceList2 = new ResourceList(arrayListResource2);
		
		resourceList1.sum(resourceList2);
		assertEquals(new Coin().getFrom(resourceList1).getValue(), 4);			//somma tra risorsa presente in entrambi
		assertEquals(new Wood().getFrom(resourceList1).getValue(), 3);			//somma tra risorsa presente solo nella chiamante
		assertEquals(new Servant().getFrom(resourceList1).getValue(), 1);		//somma tra risorsa presente solo nella chiamata
		
		assertEquals(0,new Stone().getFrom(resourceList1).getValue());				//somma tra risorsa presente in nessuna
		
		assertEquals(new Coin().getFrom(resourceList1).getValue(), 4);			//somma tra risorsa e null
		
		resourceList1.sum(resourceListNegative);
		

		assertEquals(new Coin().getFrom(resourceList1).getValue(), 3);			//somma tra risorsa presente in entrambi, chiamata negativa
		resourceListNegative.sum(resourceList1);
		assertEquals(new Coin().getFrom(resourceList1).getValue(), 3);			//somma tra risorsa presente in entrambi, chiamata negativa
	}
	
	@Test
	public void subtractTest(){
		
		arrayListResource1.add(coin3);
		arrayListResource1.add(wood3);
		arrayListResource1.add(victory1);
		
		arrayListResource2.add(coin1);
		arrayListResource2.add(servant1);
		arrayListResource2.add(victory3);
		
		resourceList1 = new ResourceList(arrayListResource1);
		resourceList2 = new ResourceList(arrayListResource2);
		
		resourceList1.subtract(resourceList2);
		assertEquals(new Coin().getFrom(resourceList1).getValue(), 2);			//differenza tra risorsa presente in entrambi, con chiamante > chiamata
		assertEquals(new VictoryPoint().getFrom(resourceList1).getValue(), 0);	//differenza tra risorsa presente in entrambi, con chiamata > chiamante
		assertEquals(new Wood().getFrom(resourceList1).getValue(), 3);			//differenza tra risorsa presente solo nella chiamante
		
		assertEquals(0, new Servant().getFrom(resourceList1).getValue());			//differenza tra risorsa presente solo nella chiamata
		assertEquals(0, new Stone().getFrom(resourceList1).getValue());				//differenza tra risorsa presente in nessuna
		
		try {
			resourceList1.subtract(null);
		} catch (NullPointerException e) {
		}
		
		assertEquals(new Coin().getFrom(resourceList1).getValue(), 2);						//differenza tra risorsa e null
		
		resourceList1.subtract(resourceListNegative);
		assertEquals(new Coin().getFrom(resourceList1).getValue(), 3);						//differenza tra risorsa presente in entrambi, chiamata negativa
	
		resourceListNegative.subtract(resourceList1);
		assertEquals(new Coin().getFrom(resourceList1).getValue(), 3);				//differenza tra risorsa presente in entrambi, chiamante negativa

		
		resourceList1 = new ResourceList(new Coin(8));
		Coin coin = new Coin().getFrom(resourceList1);
		assertEquals(8, coin.getValue());
		resourceList1 = new ResourceList();
		assertEquals(0, new VictoryPoint().getFrom(resourceList1).getValue());
		
		resourceList1 = new ResourceList(new MilitaryPoint(1));
		MilitaryPoint militaryPoint = new MilitaryPoint().getFrom(resourceList1);
		assertEquals(1, militaryPoint.getValue());
		assertEquals(0, new VictoryPoint().getFrom(resourceList1).getValue());
		assertEquals(0, new Stone().getFrom(resourceList1).getValue());
		
	}
	
	@Test
	public void canSubtractTest(){
		
		ResourceList resourceListCoin1 = new ResourceList(coin1);
		ResourceList resourceListCoin3 = new ResourceList(coin3);
		ResourceList resourceListWood1 = new ResourceList(wood1);
		
		assertTrue(resourceListCoin3.canSubtract(resourceListCoin1));		//differenza tra risorsa presente in entrambi, con chiamante > chiamata
		assertTrue(resourceListCoin1.canSubtract(resourceListCoin1));		//differenza tra risorsa presente in entrambi, con stesso valore
		assertFalse(resourceListCoin1.canSubtract(resourceListCoin3));		//differenza tra risorsa presente in entrambi, con chiamata > chiamante
		assertFalse(resourceListCoin1.canSubtract(resourceListWood1));		//differenza tra risorse diverse
		
		try {
			assertTrue(resourceListCoin1.canSubtract(null)); //differenza tra risorsa e null
		} catch (NullPointerException e) {
			
		}						
		
		assertTrue(resourceListCoin1.canSubtract(resourceListNegative));	//differenza tra risorsa presente in entrambi, chiamata negativa
		assertFalse(resourceListNegative.canSubtract(resourceListCoin1));	//differenza tra risorsa presente in entrambi, chiamante negativa

	}
	
	@Test
	public void equals(){
		
		ResourceList resourceListCoin1 = new ResourceList(coin1);
		ResourceList resourceListCoin2 = new ResourceList(coin1);
		ResourceList resourceListCoin3 = new ResourceList(coin3);
		ResourceList resourceListWood1 = new ResourceList(wood1);
		
		assertTrue(resourceListCoin1.equals(resourceListCoin2));			//confronto tra stessa risorsa, stesso valore
		assertFalse(resourceListCoin1.equals(resourceListCoin3));			//confronto tra stessa risorsa valore diverso
		assertFalse(resourceListCoin1.equals(resourceListWood1));			//confronto tra diversa risorsa
		
		assertFalse(resourceListCoin1.equals(resourceListNegative));		//confronto tra risorsa positiva e risorsa negativa
	}
}
