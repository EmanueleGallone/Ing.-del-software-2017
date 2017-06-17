package it.polimi.ingsw.ps11.gab;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.ps11.cranio.familyMember.list.BlackFamilyMember;
import it.polimi.ingsw.ps11.cranio.familyMember.list.NeutralFamilyMember;
import it.polimi.ingsw.ps11.cranio.familyMember.list.OrangeFamilyMember;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.zones.harvestAndProduction.Production;

public class ProductionTest {

	Production production;
	Player player1;
	Player player2;
	BlackFamilyMember f1;
	NeutralFamilyMember f2;
	OrangeFamilyMember f3;

	@Before
	public void setting(){
		production = new Production();
		player1 = new Player();
		player2 = new Player();
		
		f1 = new BlackFamilyMember();
		f2 = new NeutralFamilyMember();
		f3 = new OrangeFamilyMember();
		
	}
	
	@Test
	public void ProductionTest(){
		assertTrue(production.placeFamilyMember(f1, player1));
		//production.getSingleOwner e production.getMultipleOwners da aggiungere
		//ogni volta crea tre nuovi action space??
	}
	
}
