package it.polimi.ingsw.ps11.testGenerici;

import org.junit.Assert;
import org.junit.Test;

import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.resources.list.Coin;
import it.polimi.ingsw.ps11.cranio.resources.list.Stone;
import it.polimi.ingsw.ps11.cranio.resources.list.VictoryPoint;
import it.polimi.ingsw.ps11.cranio.resources.list.Wood;

public class ResourceListTest {
	private ResourceList resourceList;
	
	
	public ResourceListTest() {
		resourceList = new ResourceList();
	}
	
	@Test
	public void testAddResource(){
		Assert.assertEquals(0, resourceList.getResources().size());
		resourceList.setResource(new Coin(8));
		
		Assert.assertEquals(1, resourceList.getResources().size());
		Assert.assertEquals(8, resourceList.getResource(Coin.class).getValue());
		Assert.assertTrue(resourceList.getResource(VictoryPoint.class) == null);
	}
	
	@Test
	public void testSum(){
		ResourceList nuova = new ResourceList();
		nuova.setResource(new Stone(5));
		
		resourceList.sum(nuova);
		
		Assert.assertEquals(5, resourceList.getResource(Stone.class).getValue());
		Assert.assertFalse(resourceList.getResource(Wood.class) != null);
	}
	
	@Test
	public void testGreater(){
		resourceList.setResource(new Wood(5));
		ResourceList nuova = new ResourceList();
		
		Assert.assertTrue(resourceList.greaterEquals(nuova));
		
		Assert.assertFalse(nuova.greaterEquals(resourceList));
		
		Assert.assertTrue(resourceList.greaterEquals(resourceList));
		
	}

}
