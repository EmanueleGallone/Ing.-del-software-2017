package it.polimi.ingsw.ps11.testEma;

import org.junit.Assert;
import org.junit.Test;

import it.polimi.ingsw.ps11.model.cards.list.BlueCard;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.OrangeFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.WhiteFamilyMember;
import it.polimi.ingsw.ps11.model.player.Colors;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.actionSpace.MultipleActionSpace;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;

public class ZoneTest {

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
		
	}

}
