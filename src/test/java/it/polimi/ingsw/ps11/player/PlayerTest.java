package it.polimi.ingsw.ps11.player;

import org.junit.Assert;
import org.junit.Test;

import it.polimi.ingsw.ps11.controller.server.gameServer.PlayerFactory;
import it.polimi.ingsw.ps11.model.player.Player;

public class PlayerTest {

	@Test
	public void test(){
		PlayerFactory factory = new PlayerFactory();
		Player player = factory.newPlayer("player1",0);
		Player clone = player.clone();
		
		Assert.assertEquals(clone, player); //devono essere uguali
		Assert.assertTrue(clone.equals(player)); // test della equals
		
		Assert.assertEquals(clone.getName(), player.getName()); //devono avere stesso nome
		
		Assert.assertEquals(clone.getResourceList(), player.getResourceList()); // devono avere stesse resourceList
		
		Assert.assertFalse(clone.equals(null)); //altro branch della equals
		
	}
}
