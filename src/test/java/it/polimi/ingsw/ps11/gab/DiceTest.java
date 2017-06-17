package it.polimi.ingsw.ps11.gab;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.ps11.model.dices.BlackDice;
import it.polimi.ingsw.ps11.model.dices.Dice;
import it.polimi.ingsw.ps11.model.dices.DiceManager;
import it.polimi.ingsw.ps11.model.dices.DiceManagerGab;

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
