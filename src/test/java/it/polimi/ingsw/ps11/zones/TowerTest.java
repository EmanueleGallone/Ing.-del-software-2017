package it.polimi.ingsw.ps11.zones;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import it.polimi.ingsw.ps11.controller.server.gameServer.PlayerFactory;
import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.cards.list.GreenCard;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.OrangeFamilyMember;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;

public class TowerTest {

	@Test
	public void test(){
		
		PlayerFactory playerFactory = new PlayerFactory();
		Player player = playerFactory.newPlayer(0);
		String greenTowername = "GreenTower" ;
		FamilyMember familyMember = new OrangeFamilyMember().getFrom(player.getFamilyManager());
		ArrayList<DevelopmentCard> towerCards = new ArrayList<>();
		ArrayList<Floor> towerFloors = new ArrayList<>();
		
		DevelopmentCard card1 = new GreenCard();
		DevelopmentCard card2 = new GreenCard();
		towerCards.add(card1);
		towerCards.add(card2);

		Floor floor1 = new Floor(card1);
		Floor floor2 = new Floor();
		towerFloors.add(floor1);
		Tower greenTower = new Tower(greenTowername);
		Tower floorsTower = new Tower(towerFloors);
		
		floorsTower.addFloor(floor2);
		assertEquals(floor2, floorsTower.getFloor(1));
		floorsTower.setCard(towerCards);
		assertEquals(card1, floorsTower.getFloor(0).getCard());
		assertEquals(card2, floorsTower.getFloor(1).getCard());

		assertTrue(floorsTower.isFree());
		floorsTower.getFloor(0).placeFamilyMember(familyMember, player);
		assertFalse(floorsTower.isFree());
		
		assertEquals(floorsTower.getFloors(), towerFloors);
		assertEquals(greenTowername, greenTower.getName());
		assertEquals("GreenCard", greenTower.getCardType());
		
		floorsTower.resetFloors();
		assertTrue(floorsTower.isFree());
		Tower clone = greenTower.clone();
		assertEquals(clone.toString(), greenTower.toString());
		
		Tower tower = new Tower("Tower");
		tower.addFloor(null);
		tower.addFloor(new Floor()); //necessario per coprire la clone di tower
		Tower clone2 = tower.clone();
		assertFalse(tower.equals(clone2)); //equals non ridefinita nella torre
	}
}
