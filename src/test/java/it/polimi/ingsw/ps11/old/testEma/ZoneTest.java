package it.polimi.ingsw.ps11.old.testEma;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import it.polimi.ingsw.ps11.controller.server.gameServer.PlayerFactory;
import it.polimi.ingsw.ps11.model.cards.list.BlueCard;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.BlackFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.OrangeFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.WhiteFamilyMember;
import it.polimi.ingsw.ps11.model.game.Colors;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.model.resources.list.Stone;
import it.polimi.ingsw.ps11.model.resources.list.Wood;
import it.polimi.ingsw.ps11.model.zones.CouncilPalace;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.actionSpace.MultipleActionSpace;
import it.polimi.ingsw.ps11.model.zones.towers.BlueTower;
import it.polimi.ingsw.ps11.model.zones.towers.GreenTower;
import it.polimi.ingsw.ps11.model.zones.towers.PurpleTower;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.model.zones.towers.YellowTower;

public class ZoneTest {
/*
	@Test
	public void actionSpacetest() {
		ActionSpace actionSpace = new ActionSpace();
		ResourceList resourceList = new ResourceList();
		Player player = new Player();
		FamilyMember familyMember = new OrangeFamilyMember();
		
		actionSpace.setResources(resourceList.clone());
		actionSpace.placeFamilyMember(familyMember, player);
		
		Assert.assertTrue(actionSpace.getOwner() != null);
		Assert.assertEquals(OrangeFamilyMember.class, actionSpace.getFamilyMember().getClass());
		
		Assert.assertEquals(1, actionSpace.getActionCost());
		
		ActionSpace clone = actionSpace.clone();
		Assert.assertEquals(1, clone.getActionCost());
		Assert.assertEquals(OrangeFamilyMember.class, clone.getFamilyMember().getClass());
	}
	
	@Test
	public void multipleActionSpaceTest(){
		MultipleActionSpace actionSpace = new MultipleActionSpace();
		ResourceList resourceList = new ResourceList(new Coin(2));
		ActionSpace ac = new ActionSpace(1);
		ActionSpace ac2 = new ActionSpace(2);
		actionSpace.addActionSpace(ac);
		actionSpace.addActionSpace(ac2);
		
		Player player = new Player();
		player.setColor(Colors.RED);
		player.setName("TestPlayer");
		
		actionSpace.placeFamilyMember(player.getFamilyManager().getFamilyMember(WhiteFamilyMember.class), player);
		
		Assert.assertTrue(actionSpace.contains(player));
		
		MultipleActionSpace clone = actionSpace.clone();
		
		Assert.assertFalse(clone.equals(actionSpace)); //o dovrebbe ritornare true? nel caso dovesse ritornare true, va ridefinito l'equals

	}
	/*
	@Test
	public void towerTest(){
		Tower tower = new Tower();
		Floor floor = new Floor();
		ResourceList resourceList = new ResourceList();
		ActionSpace actionSpace = new ActionSpace(1);
		BlueCard card = new BlueCard();
		card.setName("TestBlueCard");
		card.setPeriod(1);
		card.addCost(resourceList.clone());
		
		resourceList.setResource(new Coin(1));
		actionSpace.setResources(resourceList.clone());
		floor.setActionSpace(actionSpace.clone());
		floor.setCard(card.clone());
		tower.addFloor(floor);
		
		Assert.assertTrue(floor.getActionSpace().isFree());
		
		Tower clone = tower.clone();
		
		Assert.assertEquals(card, clone.getFloor(0).getCard());
		
		for(int i = 0 ; i < 5; i++) //provo ad aggiungere piu' piani del max consentito 
			tower.addFloor(new Floor(i));
		
		Assert.assertEquals(4, tower.getFloors().size());
		
	}
	
	@Test
	public void YellowTowerTest(){
		YellowTower tower = new YellowTower();
		Assert.assertEquals(4, tower.getFloors().size());
		
		Assert.assertTrue(tower.getFloor(0).getActionSpace().getActionCost() == 1);
		Assert.assertTrue(tower.getFloor(1).getActionSpace().getActionCost() == 3);
		Assert.assertTrue(tower.getFloor(2).getActionSpace().getActionCost() == 5);
		Assert.assertTrue(tower.getFloor(3).getActionSpace().getActionCost() == 7);
		
		Assert.assertEquals(MilitaryPoint.class, tower.getFloor(2).getActionSpace().getResources().getResource(MilitaryPoint.class).getClass());
		Assert.assertEquals(1, tower.getFloor(2).getActionSpace().getResources().getResource(MilitaryPoint.class).getValue());
		
		Assert.assertEquals(MilitaryPoint.class, tower.getFloor(3).getActionSpace().getResources().getResource(MilitaryPoint.class).getClass());
		Assert.assertEquals(2, tower.getFloor(3).getActionSpace().getResources().getResource(MilitaryPoint.class).getValue());
		
		YellowTower clone = tower.clone(); //test di clone
		
		Assert.assertTrue(clone.getFloor(0).getActionSpace().getActionCost() == 1);
		Assert.assertTrue(clone.getFloor(1).getActionSpace().getActionCost() == 3);
		Assert.assertTrue(clone.getFloor(2).getActionSpace().getActionCost() == 5);
		Assert.assertTrue(clone.getFloor(3).getActionSpace().getActionCost() == 7);
		
		Assert.assertEquals(MilitaryPoint.class, clone.getFloor(2).getActionSpace().getResources().getResource(MilitaryPoint.class).getClass());
		Assert.assertEquals(1, clone.getFloor(2).getActionSpace().getResources().getResource(MilitaryPoint.class).getValue());
		Assert.assertEquals(MilitaryPoint.class, clone.getFloor(3).getActionSpace().getResources().getResource(MilitaryPoint.class).getClass());
		Assert.assertEquals(2, clone.getFloor(3).getActionSpace().getResources().getResource(MilitaryPoint.class).getValue());
		
	}
	
	@Test
	public void GreenTowerTest(){
		GreenTower tower = new GreenTower();
		Assert.assertEquals(0, tower.getFloors().size());
		
		Assert.assertTrue(tower.getFloor(0).getActionSpace().getActionCost() == 1);
		Assert.assertTrue(tower.getFloor(1).getActionSpace().getActionCost() == 3);
		Assert.assertTrue(tower.getFloor(2).getActionSpace().getActionCost() == 5);
		Assert.assertTrue(tower.getFloor(3).getActionSpace().getActionCost() == 7);
		
		Assert.assertEquals(Wood.class, tower.getFloor(2).getActionSpace().getResources().getResource(Wood.class).getClass());
		Assert.assertEquals(1, tower.getFloor(2).getActionSpace().getResources().getResource(Wood.class).getValue());
		
		Assert.assertEquals(Wood.class, tower.getFloor(3).getActionSpace().getResources().getResource(Wood.class).getClass());
		Assert.assertEquals(2, tower.getFloor(3).getActionSpace().getResources().getResource(Wood.class).getValue());
		
		GreenTower clone = tower.clone(); //test di clone
		
		Assert.assertTrue(clone.getFloor(0).getActionSpace().getActionCost() == 1);
		Assert.assertTrue(clone.getFloor(1).getActionSpace().getActionCost() == 3);
		Assert.assertTrue(clone.getFloor(2).getActionSpace().getActionCost() == 5);
		Assert.assertTrue(clone.getFloor(3).getActionSpace().getActionCost() == 7);
		
		Assert.assertEquals(Wood.class, clone.getFloor(2).getActionSpace().getResources().getResource(Wood.class).getClass());
		Assert.assertEquals(1, clone.getFloor(2).getActionSpace().getResources().getResource(Wood.class).getValue());
		Assert.assertEquals(Wood.class, clone.getFloor(3).getActionSpace().getResources().getResource(Wood.class).getClass());
		Assert.assertEquals(2, clone.getFloor(3).getActionSpace().getResources().getResource(Wood.class).getValue());
		
	}
	
	@Test
	public void BlueTowerTest(){
		BlueTower tower = new BlueTower();
		Assert.assertEquals(4, tower.getFloors().size());
		
		Assert.assertTrue(tower.getFloor(0).getActionSpace().getActionCost() == 1);
		Assert.assertTrue(tower.getFloor(1).getActionSpace().getActionCost() == 3);
		Assert.assertTrue(tower.getFloor(2).getActionSpace().getActionCost() == 5);
		Assert.assertTrue(tower.getFloor(3).getActionSpace().getActionCost() == 7);
		
		Assert.assertEquals(Stone.class, tower.getFloor(2).getActionSpace().getResources().getResource(Stone.class).getClass());
		Assert.assertEquals(1, tower.getFloor(2).getActionSpace().getResources().getResource(Stone.class).getValue());
		
		Assert.assertEquals(Stone.class, tower.getFloor(3).getActionSpace().getResources().getResource(Stone.class).getClass());
		Assert.assertEquals(2, tower.getFloor(3).getActionSpace().getResources().getResource(Stone.class).getValue());
		
		BlueTower clone = tower.clone(); //test di clone
		
		Assert.assertTrue(clone.getFloor(0).getActionSpace().getActionCost() == 1);
		Assert.assertTrue(clone.getFloor(1).getActionSpace().getActionCost() == 3);
		Assert.assertTrue(clone.getFloor(2).getActionSpace().getActionCost() == 5);
		Assert.assertTrue(clone.getFloor(3).getActionSpace().getActionCost() == 7);
		
		Assert.assertEquals(Stone.class, clone.getFloor(2).getActionSpace().getResources().getResource(Stone.class).getClass());
		Assert.assertEquals(1, clone.getFloor(2).getActionSpace().getResources().getResource(Stone.class).getValue());
		Assert.assertEquals(Stone.class, clone.getFloor(3).getActionSpace().getResources().getResource(Stone.class).getClass());
		Assert.assertEquals(2, clone.getFloor(3).getActionSpace().getResources().getResource(Stone.class).getValue());
		
	}
	
	@Test
	public void PurpleTowerTest(){
		PurpleTower tower = new PurpleTower();
		Assert.assertEquals(4, tower.getFloors().size());
		
		Assert.assertTrue(tower.getFloor(0).getActionSpace().getActionCost() == 1);
		Assert.assertTrue(tower.getFloor(1).getActionSpace().getActionCost() == 3);
		Assert.assertTrue(tower.getFloor(2).getActionSpace().getActionCost() == 5);
		Assert.assertTrue(tower.getFloor(3).getActionSpace().getActionCost() == 7);
		
		Assert.assertEquals(Coin.class, tower.getFloor(2).getActionSpace().getResources().getResource(Coin.class).getClass());
		Assert.assertEquals(1, tower.getFloor(2).getActionSpace().getResources().getResource(Coin.class).getValue());
		
		Assert.assertEquals(Coin.class, tower.getFloor(3).getActionSpace().getResources().getResource(Coin.class).getClass());
		Assert.assertEquals(2, tower.getFloor(3).getActionSpace().getResources().getResource(Coin.class).getValue());
		
		PurpleTower clone = tower.clone(); //test di clone
		
		Assert.assertEquals(4, clone.getFloors().size());
		
		Assert.assertTrue(clone.getFloor(0).getActionSpace().getActionCost() == 1);
		Assert.assertTrue(clone.getFloor(1).getActionSpace().getActionCost() == 3);
		Assert.assertTrue(clone.getFloor(2).getActionSpace().getActionCost() == 5);
		Assert.assertTrue(clone.getFloor(3).getActionSpace().getActionCost() == 7);
		
		Assert.assertEquals(Coin.class, clone.getFloor(2).getActionSpace().getResources().getResource(Coin.class).getClass());
		Assert.assertEquals(1, clone.getFloor(2).getActionSpace().getResources().getResource(Coin.class).getValue());
		Assert.assertEquals(Coin.class, clone.getFloor(3).getActionSpace().getResources().getResource(Coin.class).getClass());
		Assert.assertEquals(2, clone.getFloor(3).getActionSpace().getResources().getResource(Coin.class).getValue());
		
	}
	
	
	@Test
	public void CouncilPalaceTest(){
		ArrayList<Player> newOrder = new ArrayList<>();
		CouncilPalace council = new CouncilPalace();
		PlayerFactory factory = new PlayerFactory(); 
		Player player1 = factory.newPlayer(0);
		Player player2 = factory.newPlayer(1);
		Player player3 = factory.newPlayer(2);
		Player player4 = factory.newPlayer(3);
		
		Assert.assertFalse(player4.equals(null));
		Assert.assertFalse(player4.equals(player1));
		
		Assert.assertTrue(player1.getResourceList().getResource(Coin.class).getValue() == 5); 
		Assert.assertTrue(player2.getResourceList().getResource(Coin.class).getValue() == 6);
		Assert.assertTrue(player3.getResourceList().getResource(Coin.class).getValue() == 7);
		Assert.assertTrue(player4.getResourceList().getResource(Coin.class).getValue() == 8);
		
		council.placeFamilyMember(player2.getFamilyManager().getFamilyMember(BlackFamilyMember.class), player2);
		council.placeFamilyMember(player1.getFamilyManager().getFamilyMember(OrangeFamilyMember.class), player1);
		council.placeFamilyMember(player3.getFamilyManager().getFamilyMember(WhiteFamilyMember.class), player3);
		council.placeFamilyMember(player4.getFamilyManager().getFamilyMember(WhiteFamilyMember.class), player4);
		
		newOrder = council.getNewOrder();
		
		Assert.assertTrue(newOrder.get(0).equals(player2)); //dico che in prima posizione deve esserci il giocatore 2 che ha piazzato per primo.
		Assert.assertEquals(player2, newOrder.get(0));
		
		Assert.assertTrue(newOrder.get(1).equals(player1)); //in seconda posizione deve esserci il player1
		Assert.assertEquals(player1, newOrder.get(1));
		
		Assert.assertEquals(4, newOrder.size());
		
	}
*/
}
