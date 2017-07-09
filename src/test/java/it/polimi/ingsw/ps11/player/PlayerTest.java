package it.polimi.ingsw.ps11.player;

import java.util.ArrayList;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

import it.polimi.ingsw.ps11.controller.server.gameServer.PlayerFactory;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMemberManager;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.Resource;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.model.resources.list.Stone;

public class PlayerTest {

	@Test
	public void cloneTest(){
		PlayerFactory factory = new PlayerFactory();
		Player player = factory.newPlayer("player1",0);
		Player clone = player.clone();
		
		Assert.assertEquals(clone, player); //devono essere uguali
		Assert.assertTrue(clone.equals(player)); // test della equals
		
		Assert.assertEquals(clone.getName(), player.getName()); //devono avere stesso nome
		
		Assert.assertEquals(clone.getResourceList(), player.getResourceList()); // devono avere stesse resourceList
		
		Assert.assertFalse(clone.equals(null)); //altro branch della equals
		
		Assert.assertFalse(clone.equals(new ResourceList())); //branch equals
		
		Assert.assertTrue(clone.getColor() == player.getColor());
		
	}
	
	@Test
	public void test(){
		PlayerFactory factory = new PlayerFactory();
		Player player = factory.newPlayer("player",0);
		Player player2 = factory.newPlayer("player2", 1);
		
		ArrayList<Resource> resources = new ArrayList<>();
		resources.add(new Stone(1));
		resources.add(new MilitaryPoint(8));
		FamilyMemberManager familyMemberManager = new FamilyMemberManager();
		
		player = new Player(resources,familyMemberManager); //test costruttore
		
		Assert.assertEquals(2, player.getResourceList().getResources().size()); //deve avere 2 risorse
		Assert.assertEquals(0, player.getFamilyManager().getFamily().size()); // non ha piu' i familiari essendo un familymanager nuovo
		
		Assert.assertEquals(player.getCardManager().getAllCards().size(), player2.getCardManager().getAllCards().size()); //non hanno carte inizialmente
		
		
	}
}
