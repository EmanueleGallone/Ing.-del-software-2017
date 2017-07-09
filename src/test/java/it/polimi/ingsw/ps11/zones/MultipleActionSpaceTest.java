package it.polimi.ingsw.ps11.zones;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import it.polimi.ingsw.ps11.controller.server.gameServer.PlayerFactory;
import it.polimi.ingsw.ps11.model.familyMember.list.OrangeFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.WhiteFamilyMember;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.FaithPoint;
import it.polimi.ingsw.ps11.model.resources.list.Stone;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.actionSpace.MultipleActionSpace;

public class MultipleActionSpaceTest {

	@Test
	public void cloneTest() {
		MultipleActionSpace multipleActionSpace = new MultipleActionSpace();
		
		multipleActionSpace.addActionSpace(null); //per branch if(a != null)
		
		MultipleActionSpace clone = multipleActionSpace.clone(); //test per multipleActionSpace vuoto
		
		ActionSpace single = new ActionSpace(new ResourceList(new FaithPoint(1)));
		multipleActionSpace.addActionSpace(single); //aggiungo un actionspace al multiple
		clone = multipleActionSpace.clone();
		
		ResourceList list = clone.getActionSpace(0).getResources();
		FaithPoint faithPoint = new FaithPoint().getFrom(list);
		
		Assert.assertTrue(clone.getAllSpace().size() != multipleActionSpace.getAllSpace().size()); 
		Assert.assertEquals(1, faithPoint.getValue());
		
		multipleActionSpace.addActionSpace(new ActionSpace());
		
	}
	
	@Test
	public void playerTest(){
		MultipleActionSpace multipleActionSpace = new MultipleActionSpace();
		PlayerFactory factory = new PlayerFactory();
		Player player = factory.newPlayer(0);
		
		ActionSpace actionSpace = new ActionSpace(new ResourceList(new Stone(1))); //creo uno spazio azione con una stone
		
		multipleActionSpace.addActionSpace(actionSpace); //aggiungo lo spazio azione creato nell multiplo
		
		multipleActionSpace.getFreeSpace().placeFamilyMember(new OrangeFamilyMember().getFrom(player.getFamilyManager()), player); // occupo l'unico spazioazione disponibile
		multipleActionSpace.getFreeSpace().placeFamilyMember(new WhiteFamilyMember().getFrom(player.getFamilyManager()), player); //per l'altro branch della freeSpace
		
		Assert.assertTrue(multipleActionSpace.contains(player));
		Assert.assertFalse(multipleActionSpace.contains(null));
		
		multipleActionSpace.clean(); //rimozione player
		
		Assert.assertFalse(multipleActionSpace.contains(player)); //non deve più contenere il player
		Assert.assertEquals(2, multipleActionSpace.getAllSpace().stream().count()); //devono esserci 2 actionspace
	}

}
