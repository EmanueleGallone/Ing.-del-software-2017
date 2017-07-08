package it.polimi.ingsw.ps11.zones;

import org.junit.Assert;
import org.junit.Test;

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
		Assert.assertEquals(actionSpace.getResources().get(Coin.class).getValue(), clone.getResources().get(Coin.class).getValue());
		Assert.assertNull(actionSpace.getOwner());
		Assert.assertTrue(actionSpace.isFree());
		
		//creo un giocatore e posiziono un familire all'interno, per testare isFree()
		Player player = new Player();
		actionSpace.placeFamilyMember(player.getFamilyManager().getFamilyMember(OrangeFamilyMember.class), player);
		
		Assert.assertFalse(actionSpace.isFree());
		
	}

}
