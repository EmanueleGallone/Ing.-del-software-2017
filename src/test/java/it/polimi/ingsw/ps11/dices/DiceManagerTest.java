package it.polimi.ingsw.ps11.dices;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.ps11.model.dices.Dice;
import it.polimi.ingsw.ps11.model.dices.DiceManager;

public class DiceManagerTest {

	DiceManager diceManager;
	Dice orangeDice, orangeDice2, blackDice, whiteDice;
	ArrayList<Dice> dices;
	
	@Before
	public void setting(){
		
		orangeDice = new Dice("Orange"); orangeDice2 = new Dice("Orange"); blackDice = new Dice("Black"); whiteDice = new Dice("White");
		
		dices = new ArrayList<>();
		dices.add(orangeDice);
		dices.add(orangeDice2);
		dices.add(blackDice);
		dices.add(whiteDice);
		diceManager = new DiceManager(dices);
		
	}
	
	@Test
	public void RollTest(){
		
		diceManager.rollDices();
		assertTrue(diceManager.get("Orange").getValue()<7 && diceManager.get("Orange").getValue()>0);
		assertTrue(diceManager.get("White").getValue()<7 && diceManager.get("White").getValue()>0);
		assertTrue(diceManager.get("Black").getValue()<7 && diceManager.get("Black").getValue()>0);
		System.out.println(diceManager.toString());
		
	}
}
