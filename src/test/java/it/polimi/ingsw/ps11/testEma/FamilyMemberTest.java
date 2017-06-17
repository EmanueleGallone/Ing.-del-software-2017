package it.polimi.ingsw.ps11.testEma;

import org.junit.Assert;
import org.junit.Test;

import it.polimi.ingsw.ps11.cranio.dices.DiceManager;
import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMemberManager;
import it.polimi.ingsw.ps11.cranio.familyMember.list.BlackFamilyMember;
import it.polimi.ingsw.ps11.cranio.familyMember.list.NeutralFamilyMember;
import it.polimi.ingsw.ps11.cranio.familyMember.list.OrangeFamilyMember;
import it.polimi.ingsw.ps11.cranio.familyMember.list.WhiteFamilyMember;
import junit.framework.TestCase;

public class FamilyMemberTest {

	@Test
	public void test() {
		FamilyMemberManager manager = new FamilyMemberManager();
		
		BlackFamilyMember black = manager.getFamilyMember(BlackFamilyMember.class);
		WhiteFamilyMember white = manager.getFamilyMember(WhiteFamilyMember.class);
		OrangeFamilyMember orange = manager.getFamilyMember(OrangeFamilyMember.class);
		NeutralFamilyMember neutral = manager.getFamilyMember(NeutralFamilyMember.class);
		
		Assert.assertNotNull(manager.getFamilyMember(black.getClass()));
		
		Assert.assertTrue(black.getValue() == 0);
		Assert.assertTrue(white.getValue() == 0);
		Assert.assertTrue(orange.getValue() == 0);
		Assert.assertTrue(neutral.getValue() == 0);
		
		DiceManager dice = new DiceManager();
		dice.rollDices();
		
		black.setValue(dice.getBlackDice().getValue());
		white.setValue(dice.getWhiteDice().getValue());
		orange.setValue(dice.getOrangeDice().getValue());
		
		Assert.assertFalse(black.getValue() == 0);
		Assert.assertTrue(white.getValue() > 0 && white.getValue() <= 6);
		Assert.assertTrue(orange.getValue() > 0 && orange.getValue() <= 6);
		Assert.assertTrue(black.getValue() > 0 && black.getValue() <= 6);
	}
	
	@Test
	public void modifierTest(){
		FamilyMemberManager manager = new FamilyMemberManager();
		
		BlackFamilyMember black = manager.getFamilyMember(BlackFamilyMember.class);
		WhiteFamilyMember white = manager.getFamilyMember(WhiteFamilyMember.class);
		OrangeFamilyMember orange = manager.getFamilyMember(OrangeFamilyMember.class);
		NeutralFamilyMember neutral = manager.getFamilyMember(NeutralFamilyMember.class);
		
		black.setModifier(8);
		
		Assert.assertTrue(black.getValue() == 8);
		
		black.resetModifier();
		
		Assert.assertTrue(black.getValue() == 0);
		
		white.setModifier(1);
		
		Assert.assertTrue(white.getValue() == 1);
		
		white.resetModifier();
		
		Assert.assertTrue(white.getValue() == 0);
		
		
	}

}
