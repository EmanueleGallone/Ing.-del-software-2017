package it.polimi.ingsw.ps11.testEma;

import org.junit.Assert;
import org.junit.Test;

import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.FaithPoint;
import it.polimi.ingsw.ps11.model.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.model.resources.list.Stone;
import it.polimi.ingsw.ps11.model.resources.list.VictoryPoint;
import it.polimi.ingsw.ps11.model.resources.list.Wood;


public class ResourceListTest {

	@Test
	public void greaterEqualTest(){
		ResourceList resourceList = new ResourceList(new Coin(8));
		ResourceList list = new ResourceList();
		list.setResource(new Wood(8));
		list.setResource(new Coin(1));
		
		Assert.assertTrue(resourceList.greaterEquals(list));
		
		list.setResource(new Coin(6));
		list.getResource(Coin.class).setValue(6); 
		Assert.assertFalse(list.canSubtract(resourceList));
		Assert.assertTrue(resourceList.canSubtract(list));
		Assert.assertTrue(resourceList.canSubtract(resourceList));
		
		resourceList.subtract(list);
		
		Assert.assertFalse(resourceList.greaterEquals(list));
		
		Assert.assertFalse(resourceList.greaterEquals(null));
	
		
	}
	
	@Test
	public void equalsTest(){
		ResourceList resourceList = new ResourceList(new Coin(8));
		ResourceList other = new ResourceList(new Wood(8));
		
		Assert.assertFalse(resourceList.equals(other));
		Assert.assertTrue(resourceList.getResource(MilitaryPoint.class) == null);
		
		other = new ResourceList(new Coin(8));
		
		Assert.assertTrue(resourceList.equals(other));
		
		other.setResource(new Wood(8));
		
		Assert.assertFalse(resourceList.equals(other));
		
		resourceList.sum(other);
		
		Assert.assertFalse(resourceList.equals(other));
		
		other = new ResourceList(new Coin(16));
		other.setResource(new Wood(8));
		
		Assert.assertTrue(resourceList.equals(other));
	}
	
	@Test
	public void resourceTest(){
		ResourceList resourceList = new ResourceList();
		Stone stone = new Stone(); //per coprire il set value e il costruttore di default
		stone.setValue(5);
		resourceList.setResource(stone);
		resourceList.getResources().put(Wood.class.toString(), new Wood(8));
		resourceList.setResource(new FaithPoint(10));
		resourceList.setResource(new MilitaryPoint(11));
		resourceList.setResource(new VictoryPoint(12));
		
		Assert.assertTrue(resourceList.getResource(Wood.class).getValue() == 8);
		Assert.assertTrue(resourceList.getResource(Stone.class).getValue() == 5);
		Assert.assertTrue(resourceList.getValueOf(VictoryPoint.class) == 12);
		
		ResourceList other = new ResourceList(new Stone(15)); //per testare i negativi
		resourceList.subtract(other);
		
		Assert.assertTrue(resourceList.getResource(Stone.class).getValue() == 0);
	}

}
