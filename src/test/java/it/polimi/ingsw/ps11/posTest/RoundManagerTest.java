package it.polimi.ingsw.ps11.posTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import it.polimi.ingsw.ps11.cranio.game.RoundManager;

public class RoundManagerTest {

	
	@Test
	public void getPeriodTest(){
		RoundManager roundManager = new RoundManager(new ArrayList<>());
		
		/*assertEquals("should be 1 but is: ",1,roundManager.getPeriod());
		roundManager.nextRound();
		assertEquals("should be 1 but is: ",1,roundManager.getPeriod());
		roundManager.nextRound();
		assertEquals("should be 2 but is: ",2,roundManager.getPeriod());
		roundManager.nextRound();
		assertEquals("should be 2 but is: ",2,roundManager.getPeriod());
		roundManager.nextRound();
		assertEquals("should be 3 but is: ",3,roundManager.getPeriod());
		roundManager.nextRound();
		assertEquals("should be 3 but is: ",3,roundManager.getPeriod());
		roundManager.nextRound();
		assertEquals("should be 3 but is: ",3,roundManager.getPeriod());
		*/
	}
}
