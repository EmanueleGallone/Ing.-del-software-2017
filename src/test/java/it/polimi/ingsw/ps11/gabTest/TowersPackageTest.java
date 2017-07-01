package it.polimi.ingsw.ps11.gabTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import it.polimi.ingsw.ps11.model.familyMember.list.BlackFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.NeutralFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.OrangeFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.WhiteFamilyMember;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.towers.BlueTower;
import it.polimi.ingsw.ps11.model.zones.towers.GreenTower;
import it.polimi.ingsw.ps11.model.zones.towers.PurpleTower;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.model.zones.towers.YellowTower;

public class TowersPackageTest {

	/* 1)RENDERE TOWER ABSTRACT
	 * 2)LE TORRI POSSONO AVERE INFINITI PIANI POICHè IL CONTROLLO è SOLO SULL'ADDFLOOR -> METTERLO ANCHE SUL COSTRUTTORE
	 * 3)DA AGGIUNGERE IL CONTROLLO SUI COSTI FAMILYMEMBER - ACTIONSPACE DEL PIANO, IL NEUTRALFAMILYMEMBER NON DOVREBBE POTER
	 * ANDARE SU NESSUN PIANO SENZA MODIFIER/SERVANTS
	 * 4)BISOGNA FARE LA SOMMA TRA RESOURCELIST DELL'ACTIONSPACE E QUELLA DEL GIOCATORE
	 * 5)BISOGNA INSERIRE IL CONTROLLO CHE IMPEDISCE DI AVERE DUE FAMILYMEMBERS DELLO STESSO GIOCATORE, TRANNE QUUANDO UNO è NEUTRALFAMILYMEMBER
	 * 6)BISOGNA RENDERE I FAMILIARI NON "SPOSTABILI" UNA VOLTA PIAZZATI
	 */
	
	Player player1, player2;
	
	NeutralFamilyMember nFamilyMember;
	BlackFamilyMember bFamilyMember;
	OrangeFamilyMember oFamilyMember;
	WhiteFamilyMember wFamilyMember;
	
	ResourceList resourceOnFloor;
	Coin coin;
	
	BlueTower bTower;
	GreenTower gTower;
	PurpleTower pTower;
	YellowTower yTower;
	Floor floor1, floor2, floor3, floor4, floor5;
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setting(){
		
		player1 = new Player();
		player2 = new Player();
		
//		nFamilyMember = new NeutralFamilyMember();
//		nFamilyMember.setValue(0);
//		bFamilyMember = new BlackFamilyMember();
//		nFamilyMember.setValue(2);
//		oFamilyMember = new OrangeFamilyMember();
//		nFamilyMember.setValue(4);
//		wFamilyMember = new WhiteFamilyMember();
//		nFamilyMember.setValue(6);
		
		coin = new Coin(2);
		resourceOnFloor = new ResourceList(coin);

		bTower = new BlueTower();
		gTower = new GreenTower();
		pTower = new PurpleTower();
		yTower = new YellowTower();
		floor1 = new Floor(1);
		floor2 = new Floor(3);
		floor3 = new Floor(5);
		floor4 = new Floor(7, resourceOnFloor);
		floor5 = new Floor();

	}
	
	@Test
	public void FloorTest(){
				
		ArrayList<Floor> floors = new ArrayList<>();
		floors.add(floor1);
		floors.add(floor2);
		floors.add(floor3);
		floors.add(floor4);
		floors.add(floor5);
		Tower towerTest = new Tower(floors);
		assertEquals(floor1, towerTest.getFloor(0));
		assertEquals(floor2, towerTest.getFloor(1));
		assertEquals(floor3, towerTest.getFloor(2));
		assertEquals(floor4, towerTest.getFloor(3));
		assertEquals(floor5, towerTest.getFloor(4));
		
		assertEquals(4, towerTest.getMaxFloors());
		assertEquals(floors, towerTest.getFloors());
		//assertEquals(bTower.getMaxFloors(), towerTest.getFloors().size());	DOVREBBE ESSERE TRUE, MA UNA TORRE PUò AVERE PIù DI 4 PIANI
		
		exception.expectMessage("Non hai selezionato un piano corretto");
		towerTest.getFloor(5);
		
		assertEquals(5, towerTest.getFloors().size());							//NON POSSO AGGIUNGERE PIANI A TORRI CON GIà 4 PIANI
		towerTest.addFloor(floor5);
		assertEquals(5, towerTest.getFloors().size());
		
		floor2 = floor1.clone();
		assertEquals(floor1, floor2);
		
	}
	
	@Test
	public void placeFamilyMemberinFloorTest(){
		
		assertTrue(bTower.isFree());
		bTower.addFloor(floor1);
		bTower.addFloor(floor2);
		bTower.addFloor(floor3);
		bTower.addFloor(floor4);
		
//		assertTrue(bTower.getFloor(0).placeFamilyMember(nFamilyMember, player1));
//		assertFalse(bTower.getFloor(0).placeFamilyMember(bFamilyMember, player1));		//NON SI PUò PIAZZARE ALTRO FAMILIARE
//		assertFalse(bTower.getFloor(0).placeFamilyMember(oFamilyMember, player2));		//NEACNHE UN'ALTRO GIOCATORE
//		
//		assertTrue(bTower.getFloor(1).placeFamilyMember(bFamilyMember, player1));		//POSSO PIAZZARE UN'ALTRO FAMILIARE IN UN'ALTRO FLOOR
//		assertTrue(bTower.getFloor(2).placeFamilyMember(nFamilyMember, player1));		//DOVREBBE ESSERE FALSE, UN FAMILIARE NON SI DEVE SPOSTARE
//		assertTrue(bTower.getFloor(3).placeFamilyMember(oFamilyMember, player1));		//DOVREBBE ESSERE FALSE, NON SI POSSONO AVERE DUE FAILIARI 
//																						//SULLA STESSA TORRE SE UNO DI QUESTI NON è NEUTRAL
//		assertEquals(nFamilyMember, bTower.getFloor(0).getActionSpace().getFamilyMember());		//SUL PIANO C'è IL QUEL FAMILYMEMBER DI QUEL GIOCATORE
//		assertEquals(player1, bTower.getFloor(0 ).getActionSpace().getOwner());
//		
//		assertFalse(bTower.getFloor(0).getActionSpace().isFree());
//
//		assertFalse(bTower.isFree());

	}
	
	
}
