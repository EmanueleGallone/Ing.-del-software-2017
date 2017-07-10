package it.polimi.ingsw.ps11.resource;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.Servant;
import it.polimi.ingsw.ps11.model.resources.list.Stone;
import it.polimi.ingsw.ps11.model.resources.list.VictoryPoint;
import it.polimi.ingsw.ps11.model.resources.list.Wood;

public class ResourceTest {

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
		
	}
	
	@Test
	public void incrementTest(){
		
		coin1.increment(1);
		assertEquals(coin1.getValue(), 2);		//somma con valore positivo
		coin1.increment(-1);
		assertEquals(coin1.getValue(), 1);		//somma con valore negativo
		coin1.increment(-coin3.getValue());
		assertEquals(coin1.getValue(), 0);		//la somma darebbe un risultato negativo ma la increment setta a zero
		//coin1.increment(null);				non ammesso
		
	}
	
	@Test
	public void equalsTest(){
		
		assertFalse(coin1.equals(coin3));		//stessa risorsa, valore diverso
		assertFalse(coin1.equals(wood1));		//risorsa diversa, stesso valore
		assertFalse(coin1.equals(null));		//null
		
		coin1.increment(2);
		assertTrue(coin1.equals(coin3));		//stessa risorsa, stesso valore
	}
}
