package it.polimi.ingsw.ps11.gab;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMemberManagerGab;
import it.polimi.ingsw.ps11.model.familyMember.list.BlackFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.NeutralFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.OrangeFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.WhiteFamilyMember;


public class FamilyMemberPackageTest {
	
	/* I GETTERS NEL FAMILTYMEMBERMANAGER SONO INUTILIZZABILI, BISOGNA PASSARGLI UN FAMILTYMEMBER PER OTTENERNE UNO?
	 * I FAMILY MEMBER POSSONO AVERE VALORI NEGATIVI, MENTRE I DADI NO -> METTERE CONTROLLO
	 */
	
	private FamilyMemberManagerGab fMManager;
	
	@Before
	
	public void setting(){
		
		fMManager = new FamilyMemberManagerGab();
		
	}
	
	@Test
	public void ModifiersTest(){
		
		fMManager.getBlackFamilyMember().setValue(2);
		fMManager.getBlackFamilyMember().setModifier(1);
		assertEquals(3, fMManager.getBlackFamilyMember().getValue());
		fMManager.getBlackFamilyMember().resetModifier();
		assertEquals(2, fMManager.getBlackFamilyMember().getValue());
		
		fMManager.getOrangeFamilyMember().setValue(2);
		fMManager.getOrangeFamilyMember().setModifier(1);
		assertEquals(3, fMManager.getOrangeFamilyMember().getValue());
		fMManager.getOrangeFamilyMember().resetModifier();
		assertEquals(2, fMManager.getOrangeFamilyMember().getValue());
		
		fMManager.getWhiteFamilyMember().setValue(2);
		fMManager.getWhiteFamilyMember().setModifier(1);
		assertEquals(3, fMManager.getWhiteFamilyMember().getValue());
		fMManager.getWhiteFamilyMember().resetModifier();
		assertEquals(2, fMManager.getWhiteFamilyMember().getValue());
		
		fMManager.getNeutralFamilyMember().setValue(2);
		assertEquals(0, fMManager.getNeutralFamilyMember().getValue());
		fMManager.getNeutralFamilyMember().setModifier(1);
		assertEquals(1, fMManager.getNeutralFamilyMember().getValue());
		fMManager.getNeutralFamilyMember().resetModifier();
		assertEquals(0, fMManager.getNeutralFamilyMember().getValue());

	}
	
	@Test
	public void CloneTest(){
		
		fMManager.getBlackFamilyMember().setValue(2);
		fMManager.getBlackFamilyMember().setModifier(1);
		BlackFamilyMember bFMclone = fMManager.getBlackFamilyMember().clone();
		assertEquals(fMManager.getBlackFamilyMember().getValue(), bFMclone.getValue());
		//assertEquals(fMManager.getBlackFamilyMember().getModifier(), bFMclone.getValue());	MANCA UNA GET MODIFIER
		
		fMManager.getOrangeFamilyMember().setValue(2);
		fMManager.getOrangeFamilyMember().setModifier(1);
		OrangeFamilyMember oFMclone = fMManager.getOrangeFamilyMember().clone();
		assertEquals(fMManager.getOrangeFamilyMember().getValue(), oFMclone.getValue());
		//assertEquals(fMManager.getOrangeFamilyMember().getModifier(), oFMclone.getValue());	MANCA UNA GET MODIFIER
		
		fMManager.getWhiteFamilyMember().setValue(2);
		fMManager.getWhiteFamilyMember().setModifier(1);
		WhiteFamilyMember wFMclone = fMManager.getWhiteFamilyMember().clone();
		assertEquals(fMManager.getWhiteFamilyMember().getValue(), wFMclone.getValue());
		//assertEquals(fMManager.getWhiteFamilyMember().getModifier(), wFMclone.getValue());	MANCA UNA GET MODIFIER
		
		fMManager.getNeutralFamilyMember().setValue(2);
		fMManager.getNeutralFamilyMember().setModifier(1);
		NeutralFamilyMember nFMclone = fMManager.getNeutralFamilyMember().clone();
		assertEquals(fMManager.getNeutralFamilyMember().getValue(), nFMclone.getValue());
		//assertEquals(fMManager.getNeutralFamilyMember().getModifier(), nFMclone.getValue());	MANCA UNA GET MODIFIER

	}
}
