package it.polimi.ingsw.ps11.gab.modelTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.ps11.model.dices.BlackDice;
import it.polimi.ingsw.ps11.model.dices.DiceManager;
import it.polimi.ingsw.ps11.model.dices.OrangeDice;
import it.polimi.ingsw.ps11.model.dices.WhiteDice;

public class DicesPackageTest {
	
	/* 1)SETDICE RIGA 39 DI DICEMANAGERGAB (COPIATA DALLA RESOURCELIST) PUò ESSERE USATA PER SETTARE UN DADO AD UN VALORE IN MODO
	 * ESTERNO ALL ROLLDICE -> RENDERLO PRIVATE
	 */

	private DiceManager diceManager, diceManagerClone;
	
	@Before
	public void setting(){
		
		diceManager = new DiceManager();
		
	}
	
	@Test
	public void RollTest(){
		
		diceManager.rollDices();
		assertTrue(diceManager.getDice(BlackDice.class).getValue()<7 && diceManager.getDice(BlackDice.class).getValue()>0);
		assertTrue(diceManager.getDice(OrangeDice.class).getValue()<7 && diceManager.getDice(OrangeDice.class).getValue()>0);
		assertTrue(diceManager.getDice(WhiteDice.class).getValue()<7 && diceManager.getDice(WhiteDice.class).getValue()>0);
		
		diceManager.setDice(new BlackDice());
		assertEquals(0, diceManager.getDice(BlackDice.class).getValue());
	}
	
	@Test
	public void CloneAndGettersTest(){
		
		assertEquals(0, diceManager.getDice(BlackDice.class).getValue());
		assertEquals(0, diceManager.getDice(OrangeDice.class).getValue());
		assertEquals(0, diceManager.getDice(WhiteDice.class).getValue());
		
		diceManager.rollDices();
		diceManagerClone = diceManager.clone();
		
		assertEquals(diceManagerClone.getDice(BlackDice.class).getValue(), diceManager.getValueOf(BlackDice.class));
		assertEquals(diceManagerClone.getDice(OrangeDice.class).getValue(), diceManager.getValueOf(OrangeDice.class));
		assertEquals(diceManagerClone.getDice(WhiteDice.class).getValue(), diceManager.getValueOf(WhiteDice.class));
				
	}
}
