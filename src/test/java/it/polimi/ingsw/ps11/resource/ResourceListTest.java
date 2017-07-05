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
import it.polimi.ingsw.ps11.model.resources.list.Servant;
import it.polimi.ingsw.ps11.model.resources.list.Stone;
import it.polimi.ingsw.ps11.model.resources.list.VictoryPoint;
import it.polimi.ingsw.ps11.model.resources.list.Wood;

public class ResourceListTest {

	ArrayList<Resource> arrayListResource1, arrayListResource2;
	ResourceList resourceList1, resourceList2;
	Coin coin1, coin3;
	Wood wood1, wood3;
	Stone stone1, stone3;
	Servant servant1, servant3;
	VictoryPoint victory1, victory3;
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setting(){
		
		coin1 = new Coin(1); coin3 = new Coin(3);
		wood1 = new Wood(1); wood3 = new Wood(3);
		stone1 = new Stone(1); stone3 = new Stone(3);
		servant1 = new Servant(1); servant3 = new Servant(3);
		victory1 = new VictoryPoint(1); victory3 = new VictoryPoint(3);
		
		arrayListResource1 = new ArrayList<>();
		arrayListResource2 = new ArrayList<>();
		
		arrayListResource1.add(coin3);
		arrayListResource1.add(wood3);
		arrayListResource1.add(victory1);
		
		arrayListResource2.add(coin1);
		arrayListResource2.add(servant1);
		arrayListResource2.add(victory3);
		
		resourceList1 = new ResourceList(arrayListResource1);
		resourceList2 = new ResourceList(arrayListResource2);
		
	}
	
	@Test
	public void sumTest(){
		
		resourceList1.sum(resourceList2);
		assertEquals(resourceList1.get(Coin.class).getValue(), 4);			//somma tra risorsa presente in entrambi
		assertEquals(resourceList1.get(Wood.class).getValue(), 3);			//somma tra risorsa presente solo nella chiamante
		assertEquals(resourceList1.get(Servant.class).getValue(), 1);		//somma tra risorsa presente solo nella chiamata
		exception.expect(NullPointerException.class);
		assertNull(resourceList1.get(Stone.class).getValue());				//somma tra risorsa presente in nessuna

	}
	
	@Test
	public void subtractTest(){
		
		resourceList1.subtract(resourceList2);
		assertEquals(resourceList1.get(Coin.class).getValue(), 2);			//differenza tra risorsa presente in entrambi, con chiamante > chiamata
		assertEquals(resourceList1.get(VictoryPoint.class).getValue(), -2);	//differenza tra risorsa presente in entrambi, con chiamata > chiamante
		assertEquals(resourceList1.get(Wood.class).getValue(), 3);			//differenza tra risorsa presente solo nella chiamante
		exception.expect(NullPointerException.class);
		assertNull(resourceList1.get(Servant.class).getValue());			//differenza tra risorsa presente solo nella chiamata
		exception.expect(NullPointerException.class);
		assertNull(resourceList1.get(Stone.class).getValue());				//differenza tra risorsa presente in nessuna
	}
	
	@Test
	public void canSubtractTest(){
		
	}
	
	@Test
	public void equals(){
		
	}
	
	@Test
	public void getTest(){
		
	}
	
	@Test
	public void getResourceTest(){
		
	}
	
	@Test
	public void getValueOfTest(){
		
	}
}
