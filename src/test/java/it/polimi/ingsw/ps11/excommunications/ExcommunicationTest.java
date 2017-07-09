package it.polimi.ingsw.ps11.excommunications;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import it.polimi.ingsw.ps11.model.cards.effects.AddResourceEffect;
import it.polimi.ingsw.ps11.model.cards.effects.Effect;
import it.polimi.ingsw.ps11.model.excommunications.Excommunication;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.Servant;

public class ExcommunicationTest {

	@Test
	public void cloneTest() {
		Excommunication excommunication = new Excommunication("1", 1);
		Effect effect = new AddResourceEffect(new ResourceList(new Coin(1),new Servant(1)));
		excommunication.addEffect(effect);
		
		Excommunication clone = excommunication.clone();
		Assert.assertEquals(1, clone.getPeriod());
		Assert.assertEquals("1", clone.getId());
		Assert.assertEquals(clone.getEffect(0), excommunication.getEffect(0));
		
		excommunication.setPeriod(3);
		Assert.assertFalse(clone.getPeriod() == excommunication.getPeriod());
		
	}

}
