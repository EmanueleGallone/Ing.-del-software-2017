package it.polimi.ingsw.ps11.old.posTest;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.Servant;
import it.polimi.ingsw.ps11.model.resources.list.Stone;
import it.polimi.ingsw.ps11.model.resources.list.Wood;

public class ResourceListTest {

	
	@Test
	public void equalsTest(){
		//Negative case
		ResourceList r1 = new ResourceList();
		r1.setResource(new Wood(5));
		r1.setResource(new Stone(2));
		
		ResourceList r2 = new ResourceList();
		r2.setResource(new Coin(5));
		r2.setResource(new Servant(2));
		r2.setResource(new Wood(5));
		
		assertFalse("should be false but is: ",r1.equals(r2));
		
		//Positive case
		ResourceList r11 = new ResourceList();
		r11.setResource(new Wood(5));
		r11.setResource(new Stone(2));
		
		ResourceList r12 = new ResourceList();
		r12.setResource(new Wood(5));
		r12.setResource(new Stone(2));
		
		assertTrue("should be true but is: ",r11.equals(r12));
		
		ResourceList r111 = new ResourceList();
		ResourceList r112 = new ResourceList();
 
		assertTrue("should be true but is: ",r11.equals(r12));
	}
	
	
	@Test
	public void greaterEqualsTest(){
		
		//Positive case
		ResourceList r1 = new ResourceList();
		r1.setResource(new Wood(5));
		r1.setResource(new Stone(2));
		
		ResourceList r2 = new ResourceList();
		r2.setResource(new Coin(5));
		r2.setResource(new Servant(2));
		r2.setResource(new Wood(5));
		
		assertTrue("should be true but is: ",r1.greaterEquals(r2));
		
		ResourceList r11 = new ResourceList();
		r11.setResource(new Wood(5));
		r11.setResource(new Stone(2));
		
		ResourceList r22 = new ResourceList();
		r22.setResource(new Coin(5));
		r22.setResource(new Servant(2));
		r22.setResource(new Wood(5));
		
		assertTrue("should be true but is: ",r22.greaterEquals(r11));
		
		
		//Negative case
		ResourceList r111 = new ResourceList();
		r111.setResource(new Wood(5));
		r111.setResource(new Stone(2));
		
		ResourceList r222 = new ResourceList();
		r222.setResource(new Coin(5));
		r222.setResource(new Servant(2));
		r222.setResource(new Stone(3));
		r222.setResource(new Wood(5));
		
		assertFalse("should be false but is: ",r111.greaterEquals(r222));
		
	}
	
	@Test
	public void resourceEqualsTest(){
		
		//Negative case
		Wood w = new Wood(5);
		Stone s = new Stone(5);
		
		assertFalse("should be false but is: ", w.equals(s));
		
		//Positive case
		Wood wa = new Wood(5);
		Wood wa2 = new Wood(5);
		
		assertTrue("should be true but is: ", wa.equals(wa2));
	}
	
}
