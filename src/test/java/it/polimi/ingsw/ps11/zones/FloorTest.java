package it.polimi.ingsw.ps11.zones;

import org.junit.Assert;
import org.junit.Test;

import it.polimi.ingsw.ps11.controller.server.gameServer.PlayerFactory;
import it.polimi.ingsw.ps11.model.cards.list.YellowCard;
import it.polimi.ingsw.ps11.model.familyMember.list.WhiteFamilyMember;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;

public class FloorTest {

	@Test
	public void cloneTest() {
		Floor floor = new Floor(1);
		Floor clone;
		floor.setActionSpace(new ActionSpace(new ResourceList(new Coin(1))));
		clone = floor.clone();
		
		Assert.assertNull(clone.getCard());
		
		floor.setCard(new YellowCard("card"));
		clone = floor.clone();
		
		Assert.assertEquals("card", clone.getCard().getName());
	}
	
	@Test
	public void placeTest(){
		PlayerFactory factory = new PlayerFactory();
		Player player = factory.newPlayer(0);
		
		Floor floor = new Floor(new YellowCard("card"));
		floor.setActionSpace(new ActionSpace(new ResourceList(new Coin(1))));
		
		floor.placeFamilyMember(new WhiteFamilyMember().getFrom(player.getFamilyManager()), player);
		
		Assert.assertEquals(player, floor.getActionSpace().getOwner());
		floor.clean();
		Assert.assertNull(floor.getActionSpace().getOwner());
		
		floor = new Floor(1, new ResourceList(new Coin(1))); // test costruttore
		floor.setCard(new YellowCard("yellow"));
		floor.cleanCard(); //test clean
		Assert.assertNull(floor.getCard());
	}

}
