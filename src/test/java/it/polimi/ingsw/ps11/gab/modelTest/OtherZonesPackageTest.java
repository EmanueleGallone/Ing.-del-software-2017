package it.polimi.ingsw.ps11.gab.modelTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.ps11.model.familyMember.list.BlackFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.NeutralFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.OrangeFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.WhiteFamilyMember;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.zones.CouncilPalace;
import it.polimi.ingsw.ps11.model.zones.Market;
import it.polimi.ingsw.ps11.model.zones.yield.Yield;

public class OtherZonesPackageTest {
	
	/* 1)LA PRODUCTION ZONE PUò CONTENERE DUE FAMILIARI DELLO STESSO GIOCATORE, SE UNO DI QUESTI è QUELLO NEUTRALE
	 * 2)LA CONTAINS IN MULTIPLE ACTIONSPACE DICE CHE UN GIOCATORE è RESENTE QUANDO INVECE NON LO è, 
	 * DATO CHE REUTRN TRUE E RETURN FALSE SONO SCAMBIATI
	 * 3)MARKET è PIù UN ARRAYLIST DI SINGLE ACTIONSPACE CHE UN MULTIPLE, PUOI METTERE UN FAMILIARE SU PIù ZONE MERCATO,
	 * SONO UNA INDIPENDENTE DALLE ALTRE, DIMENSIONE = 2 SE CI SONO 2 O 3 GIOCATORI, = 4 SE CI SONO 4 GIOCATORI
	 */
	
	ArrayList<Player> players;
	ArrayList<Player> order;
	Player player1, player2, player3, player4;
	
	CouncilPalace councilPalace;
	Market market;
	Yield production;
	
	@Before
	public void setting(){
		
		players= new ArrayList<>();
		order = new ArrayList<>();
				
		player1 = new Player();
		player2 = new Player();
		player3 = new Player();
		player4 = new Player();	
		
		player1.setName("Player1");
		player2.setName("Player2");
		player3.setName("Player3");
		player4.setName("Player4");
		
		players.add(player1);
		players.add(player2);
		players.add(player3);
		players.add(player4);
				
		councilPalace = new CouncilPalace();
		market = new Market(players.size());
		production = new Yield();
		
	}
	
	@Test
	public void CouncilPalaceTest(){
		
		councilPalace.placeFamilyMember(player1.getFamilyManager().getFamilyMember(BlackFamilyMember.class), player1);
		councilPalace.placeFamilyMember(player2.getFamilyManager().getFamilyMember(OrangeFamilyMember.class), player2);
		councilPalace.placeFamilyMember(player3.getFamilyManager().getFamilyMember(WhiteFamilyMember.class), player3);
		councilPalace.placeFamilyMember(player4.getFamilyManager().getFamilyMember(NeutralFamilyMember.class), player4);
		
		councilPalace.getNewOrder();			//DA RIVEDERE

	}
	
	@Test
	public void MarketTest(){
	
	}
	
	@Test
	public void ProductionTest(){
		
		assertTrue(production.placeFamilyMember(player1.getFamilyManager().getFamilyMember(BlackFamilyMember.class), player1));
		assertFalse(production.placeFamilyMember(player1.getFamilyManager().getFamilyMember(OrangeFamilyMember.class), player1));
		//assertTrue("Should be true but ", production.placeFamilyMember(player1.getFamilyManager().getFamilyMember(NeutralFamilyMember.class), player1));
		/*
		assertTrue(production.getMultipleActionSpace().contains(player1));
		assertFalse("Should be false but ", production.getMultipleActionSpace().contains(player2));
		
		assertTrue("Should be true but ", production.placeFamilyMember(player2.getFamilyManager().getFamilyMember(BlackFamilyMember.class), player2));
		assertTrue("Should be true but ", production.placeFamilyMember(player3.getFamilyManager().getFamilyMember(BlackFamilyMember.class), player3));
		assertTrue("Should be true but ", production.placeFamilyMember(player4.getFamilyManager().getFamilyMember(BlackFamilyMember.class), player4));
		*/

	}
	
}
