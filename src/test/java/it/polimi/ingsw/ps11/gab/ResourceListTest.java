package it.polimi.ingsw.ps11.gab;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;

public class ResourceListTest {
	
	public ResourceList r;
	public ResourceList p;
	public ResourceList m;
	
	@Before
	public void setting(){
		r = new ResourceList (new Coin(3));
		p = new ResourceList (new Coin(5));
		m = new ResourceList (new Coin (5));

	}
	
	
	@Test
	public void substractTest(){		
		assertTrue(p.canSubtract(r));			
		p.subtract(r);
		assertEquals(2, p.getValueOf(Coin.class));
		assertEquals(3, r.getValueOf(Coin.class));	
		assertFalse(p.greaterEquals(r));	
	}
	
	@Test
	public void EqualsTest(){
		System.out.println(p.getResource(Coin.class));
		p.getResource(Coin.class);
		
		assertTrue(p.greaterEquals(r));
		assertTrue(p.equals(m));
	}
	
	
}