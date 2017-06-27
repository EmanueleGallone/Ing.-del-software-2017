package it.polimi.ingsw.ps11.posTest;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.ps11.model.gameLogics.actions.baseAction.IncrementResource;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;

public class Actions {
	
	@Test
	public void IncrementActionText(){
		Player player = new Player();
		
		IncrementResource increment = new IncrementResource(player, new ResourceList(new Coin(5)));
		
		if(increment.isLegal())
			increment.perform();
		assertEquals(player.getResourceList().getResource(Coin.class),new Coin(5));
	}

}
