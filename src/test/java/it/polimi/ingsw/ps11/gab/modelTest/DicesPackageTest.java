package it.polimi.ingsw.ps11.gab.modelTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.ps11.model.dices.BlackDice;
import it.polimi.ingsw.ps11.model.dices.DiceManagerGab;

public class DicesPackageTest {
	
	/* 1)SETDICE RIGA 39 DI DICEMANAGERGAB (COPIATA DALLA RESOURCELIST) PUò ESSERE USATA PER SETTARE UN DADO AD UN VALORE IN MODO
	 * ESTERNO ALL ROLLDICE -> RENDERLO PRIVATE
	 */

	private DiceManagerGab diceManager, diceManagerClone;
	
	@Before
	public void setting(){
		
		diceManager = new DiceManagerGab();
		
	}
	
	@Test
	public void RollTest(){
		
		diceManager.rollDices();
		assertTrue(diceManager.getBlackDice().getValue()<7 && diceManager.getBlackDice().getValue()>0);
		assertTrue(diceManager.getOrangeDice().getValue()<7 && diceManager.getOrangeDice().getValue()>0);
		assertTrue(diceManager.getWhiteDice().getValue()<7 && diceManager.getWhiteDice().getValue()>0);
		
		diceManager.setDice(new BlackDice());
		assertEquals(0, diceManager.getBlackDice().getValue());
	}
	
	@Test
	public void CloneAndGettersTest(){
		
		assertEquals(0, diceManager.getBlackDice().getValue());
		assertEquals(0, diceManager.getOrangeDice().getValue());
		assertEquals(0, diceManager.getWhiteDice().getValue());
		
		diceManager.rollDices();
		diceManagerClone = diceManager.clone();
		
		assertEquals(diceManagerClone.getBlackDice().getValue(), diceManager.getBlackDice().getValue());
		assertEquals(diceManagerClone.getOrangeDice().getValue(), diceManager.getOrangeDice().getValue());
		assertEquals(diceManagerClone.getWhiteDice().getValue(), diceManager.getWhiteDice().getValue());
		
	}
}
