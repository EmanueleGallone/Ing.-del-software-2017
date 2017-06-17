package it.polimi.ingsw.ps11.gab;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import it.polimi.ingsw.ps11.cranio.familyMember.list.BlackFamilyMember;
import it.polimi.ingsw.ps11.cranio.familyMember.list.NeutralFamilyMember;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.zones.Floor;
import it.polimi.ingsw.ps11.cranio.zones.towers.BlueTower;
import it.polimi.ingsw.ps11.cranio.zones.towers.GreenTower;
import it.polimi.ingsw.ps11.cranio.zones.towers.PurpleTower;
import it.polimi.ingsw.ps11.cranio.zones.towers.Tower;
import it.polimi.ingsw.ps11.cranio.zones.towers.YellowTower;

public class YellowTowerTest {
	
	NeutralFamilyMember NfamilyMember;
	YellowTower yTower;
	
	BlackFamilyMember BfamilyMember;
	Floor floor;
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	//exception.expect(tipoDiEccezione.class)
	
	@Before
	public void setting(){
		//se creo un arraylist con 5 floors e poi li passo al costruttore della torre, questo non fa il check. DA AGGIUNGERE
		NfamilyMember = new NeutralFamilyMember();
		yTower = new YellowTower();
		BfamilyMember = new BlackFamilyMember();
		floor = new Floor();
		
	}

	@Test
	public void FloorTest(){
		
		assertEquals(4, yTower.getMaxFloors());
		
		exception.expectMessage("Non hai selezionato un piano corretto");
		yTower.getFloor(4);
		
		assertEquals(yTower.getMaxFloors(), yTower.getFloors().size());
		assertEquals(4, yTower.getFloors().size());
		yTower.addFloor(floor);
		assertEquals(4, yTower.getFloors().size());
		
		assertTrue(yTower.isFree());
		yTower.getFloor(3).placeFamilyMember(new BlackFamilyMember(), new Player());
		assertFalse(yTower.getFloor(3).getActionSpace().isFree());
		assertFalse(yTower.isFree());
	}
	
}
