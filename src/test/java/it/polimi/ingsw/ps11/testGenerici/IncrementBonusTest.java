package it.polimi.ingsw.ps11.testGenerici;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.ps11.cranio.bonus.Bonus;
import it.polimi.ingsw.ps11.cranio.bonus.IncrementResourceBonus;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.resources.list.Wood;

public class IncrementBonusTest {
	
		private ResourceList resourceList;
		private Bonus bonus;
		
		@Before
		public void constructor() {
			resourceList = new ResourceList();
			bonus = new IncrementResourceBonus(resourceList);
		}
		
		@Test
		public void InstanceBonusBehaviour(){
			Player player = new Player();
			
			Assert.assertTrue(player.getResourceList() != null);
			Assert.assertFalse(player.getResourceList().getResource(Wood.class) == null);
			
			int valueBeforeBonus = player.getResourceList().getResource(Wood.class).getValue();
			
			resourceList.setResource(new Wood(5));
			bonus = new IncrementResourceBonus(resourceList);
			bonus.setOwner(player);
			
			bonus.behavior();
			
			Assert.assertEquals(valueBeforeBonus + resourceList.getResource(Wood.class).getValue(),
					player.getResourceList().getResource(Wood.class).getValue());
		}

}
