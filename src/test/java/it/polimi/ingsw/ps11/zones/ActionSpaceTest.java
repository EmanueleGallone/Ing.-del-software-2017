package it.polimi.ingsw.ps11.zones;

import org.junit.Assert;
import org.junit.Test;

import it.polimi.ingsw.ps11.controller.server.gameServer.PlayerFactory;
import it.polimi.ingsw.ps11.model.familyMember.list.BlackFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.OrangeFamilyMember;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;

public class ActionSpaceTest {

	@Test
	public void cloneTest() {
		ResourceList resourceList = new ResourceList(new Coin(1));
		ActionSpace actionSpace = new ActionSpace();
		actionSpace.setResources(resourceList.clone());
		
		ActionSpace clone = actionSpace.clone(); //testo la clone
		
		Assert.assertEquals(actionSpace.getActionCost(), clone.getActionCost());
		Coin coin = new Coin().getFrom(actionSpace.getResources());
		Assert.assertEquals(coin.getValue(), clone.getResources().get(coin.getId()).getValue());
		Assert.assertNull(actionSpace.getOwner());
		
		PlayerFactory factory = new PlayerFactory();
		Player player = factory.newPlayer(0);
		
		
		actionSpace.placeFamilyMember(new BlackFamilyMember().getFrom(player.getFamilyManager()), player);
		clone = actionSpace.clone();
		
		Assert.assertEquals(clone.getOwner(), actionSpace.getOwner());
		
		
		
		
	}
	
	@Test
	public void isFreeTest(){
		ActionSpace actionSpace = new ActionSpace();
		Assert.assertTrue(actionSpace.isFree());
		
		//creo un giocatore e posiziono un familire all'interno, per testare isFree()
		
		PlayerFactory factory = new PlayerFactory();
		Player player = factory.newPlayer(0);
		actionSpace.placeFamilyMember(new OrangeFamilyMember().getFrom(player.getFamilyManager()), player);
		
		Assert.assertFalse(actionSpace.isFree());
		
		actionSpace.clean();
		
		Assert.assertTrue(actionSpace.isFree());
		
	}

}
