package it.polimi.ingsw.ps11.zones;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import it.polimi.ingsw.ps11.controller.server.gameServer.PlayerFactory;
import it.polimi.ingsw.ps11.model.cards.list.GreenCard;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.BlackFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.NeutralFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.OrangeFamilyMember;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.yield.Yield;

public class YieldTest {
	
	@Test
	public void test(){
		
		PlayerFactory playerFactory = new PlayerFactory();
		Player player1 = playerFactory.newPlayer(0);
		Player player2 = playerFactory.newPlayer(1);
		FamilyMember orangeFamilyMember = new OrangeFamilyMember().getFrom(player1.getFamilyManager());
		FamilyMember neutralFamilyMember = new NeutralFamilyMember().getFrom(player1.getFamilyManager());
		FamilyMember blackFamilyMember = new BlackFamilyMember().getFrom(player2.getFamilyManager());
		
		Yield harvest = new Yield(new GreenCard().getId());
		
		assertEquals(new GreenCard().getId(), harvest.getActiveCard());
		
		assertTrue(harvest.getSingleActionSpace().isFree());
		assertFalse(harvest.getMultipleActionSpace().contains(player1));

		harvest.getFreeSpace().placeFamilyMember(orangeFamilyMember, player1);
		harvest.getFreeSpace().placeFamilyMember(neutralFamilyMember, player1);
		harvest.getFreeSpace().placeFamilyMember(blackFamilyMember, player2);
		
		assertTrue(harvest.search(player1));
		assertFalse(harvest.getSingleActionSpace().isFree());
		assertEquals(orangeFamilyMember, harvest.getSingleActionSpace().getFamilyMember());
		assertTrue(harvest.getMultipleActionSpace().contains(player1));
		assertTrue(harvest.getMultipleActionSpace().contains(player2));
		
		Yield clone = harvest.clone();		
		//MANCANO CLONE E ITERATOR
		assertEquals(harvest.getSingleActionSpace(), clone.getSingleActionSpace());
		assertEquals(harvest.getMultipleActionSpace(), clone.getMultipleActionSpace());
		
		harvest.resetFamilyMember();
		for (ActionSpace actionSpace : harvest) {
			assertTrue(actionSpace.isFree());
		}
	}

}
