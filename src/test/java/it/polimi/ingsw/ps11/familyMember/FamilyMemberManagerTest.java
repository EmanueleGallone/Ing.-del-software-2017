package it.polimi.ingsw.ps11.familyMember;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.ps11.model.dices.Dice;
import it.polimi.ingsw.ps11.model.dices.DiceManager;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMemberManager;
import it.polimi.ingsw.ps11.model.familyMember.list.BlackFamilyMember;
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
		
		orangeFamilyMember = new OrangeFamilyMember("Orange"); blackFamilyMember = new BlackFamilyMember("Black");
		whiteFamilyMember = new WhiteFamilyMember("White");
		
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
		familyManager.getFamilyMember("Orange");

		diceManager.rollDices();
		
//		assertEquals(diceManager.get("Orange").getValue(),familyManager.getFamilyMember("Orange").getValue());		
//		assertEquals(diceManager.get("Black").getValue(),familyManager.getFamilyMember("Black").getValue());
//		assertEquals(diceManager.get("White").getValue(),familyManager.getFamilyMember("White").getValue());
		
		diceManager.rollDices();
		
//		assertEquals(diceManager.get("Orange").getValue(),familyManager.getFamilyMember("Orange").getValue());		
//		assertEquals(diceManager.get("Black").getValue(),familyManager.getFamilyMember("Black").getValue());
//		assertEquals(diceManager.get("White").getValue(),familyManager.getFamilyMember("White").getValue());

	}
	
}
