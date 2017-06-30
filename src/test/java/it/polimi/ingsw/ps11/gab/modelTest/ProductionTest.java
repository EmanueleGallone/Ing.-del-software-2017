package it.polimi.ingsw.ps11.gab.modelTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.ps11.model.cards.list.YellowCard;
import it.polimi.ingsw.ps11.model.familyMember.list.BlackFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.NeutralFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.OrangeFamilyMember;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.zones.yield.Yield;

public class ProductionTest {

	Yield production;
	Player player1;
	Player player2;
	BlackFamilyMember f1;
	NeutralFamilyMember f2;
	OrangeFamilyMember f3;

	@Before
	public void setting(){
		production = new Yield(YellowCard.class);
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
