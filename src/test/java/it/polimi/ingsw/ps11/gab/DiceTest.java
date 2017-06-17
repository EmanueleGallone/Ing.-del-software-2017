package it.polimi.ingsw.ps11.gab;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.ps11.cranio.dices.BlackDice;
import it.polimi.ingsw.ps11.cranio.dices.Dice;
import it.polimi.ingsw.ps11.cranio.dices.DiceManager;
import it.polimi.ingsw.ps11.cranio.dices.DiceManagerGab;

public class DiceTest {
		
	DiceManagerGab dManager;
	@Before
	public void setting(){
		dManager = new DiceManagerGab();
	}
	@Test
	public void rollDiceTest(){
		dManager.rollDices();
		assertTrue(dManager.getBlackDice().getValue()<7 && dManager.getBlackDice().getValue()>0);
		assertTrue(dManager.getOrangeDice().getValue()<7 && dManager.getOrangeDice().getValue()>0);
		assertTrue(dManager.getWhiteDice().getValue()<7 && dManager.getWhiteDice().getValue()>0);
	}

}
