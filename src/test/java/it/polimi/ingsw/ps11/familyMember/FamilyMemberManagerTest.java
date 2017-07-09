package it.polimi.ingsw.ps11.familyMember;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.ps11.model.dices.Dice;
import it.polimi.ingsw.ps11.model.dices.DiceManager;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMemberManager;
import it.polimi.ingsw.ps11.model.familyMember.list.BlackFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.NeutralFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.OrangeFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.WhiteFamilyMember;

public class FamilyMemberManagerTest {

	OrangeFamilyMember orangeFamilyMember;
	BlackFamilyMember blackFamilyMember;
	WhiteFamilyMember whiteFamilyMember;
	ArrayList<FamilyMember> family;
	FamilyMemberManager familyManager;
	
	@Before
	public void setting(){
		
		orangeFamilyMember = new OrangeFamilyMember(); 
		blackFamilyMember = new BlackFamilyMember();
		whiteFamilyMember = new WhiteFamilyMember();
		
		
		family = new ArrayList<>();
		family.add(orangeFamilyMember);
		family.add(blackFamilyMember);
		family.add(whiteFamilyMember);
		
		familyManager = new FamilyMemberManager(family);
		
	}
	
	@Test
	public void setDicesTest(){
		
		Dice orangeDice = new Dice("Orange");
		Dice blackDice = new Dice("Black");
		Dice whiteDice = new Dice("White");

		ArrayList<Dice> dices = new ArrayList<>();
		dices.add(orangeDice);
		dices.add(blackDice);
		dices.add(whiteDice);
		
		DiceManager diceManager = new DiceManager(dices);
		
		familyManager.setDices(diceManager);
		
		diceManager.rollDices();
		
		assertEquals(diceManager.get("Orange").getValue(), new OrangeFamilyMember().getFrom(familyManager).getValue());		
		assertEquals(diceManager.get("Black").getValue(), new BlackFamilyMember().getFrom(familyManager).getValue());
		assertEquals(diceManager.get("White").getValue(), new WhiteFamilyMember().getFrom(familyManager).getValue());
		
		diceManager.rollDices();
		
		assertEquals(diceManager.get("Orange").getValue(), new OrangeFamilyMember().getFrom(familyManager).getValue());		
		assertEquals(diceManager.get("Black").getValue(), new BlackFamilyMember().getFrom(familyManager).getValue());
		assertEquals(diceManager.get("White").getValue(), new WhiteFamilyMember().getFrom(familyManager).getValue());
		

		Assert.assertFalse(orangeFamilyMember.isUsed());
		orangeFamilyMember.setUsed(true); //test isUsed()
		Assert.assertTrue(orangeFamilyMember.isUsed());
		
		Assert.assertFalse(orangeFamilyMember.isNeutral()); //non deve essere neutrale
		Assert.assertTrue(new NeutralFamilyMember().isNeutral()); //deve essere neutrale

	}
	
}
