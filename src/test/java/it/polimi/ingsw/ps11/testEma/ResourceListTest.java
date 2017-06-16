package it.polimi.ingsw.ps11.testEma;

import org.junit.Assert;
import org.junit.Test;

import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.resources.list.Coin;
import it.polimi.ingsw.ps11.cranio.resources.list.Wood;

public class ResourceListTest {

	@Test
	public void test(){
		ResourceList resourceList = new ResourceList();
		ResourceList list = new ResourceList();
		resourceList.setResource(new Coin(8));
		list.setResource(new Wood(8));
		list.setResource(new Coin(1));
		
		Assert.assertTrue(resourceList.greaterEquals(list));
		
		list.setResource(new Coin(6));
		resourceList.subtract(list);
		
		Assert.assertFalse(resourceList.greaterEquals(list));
		
	}

}
