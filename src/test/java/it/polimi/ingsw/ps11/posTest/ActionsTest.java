package it.polimi.ingsw.ps11.posTest;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.ps11.model.gameLogics.actions.baseAction.IncrementResource;
import it.polimi.ingsw.ps11.model.gameLogics.newTry.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.newTry.actions.IncrementAction;
import it.polimi.ingsw.ps11.model.gameLogics.newTry.affecter.IncrementAffecter;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;

public class ActionsTest {
	
	@Test
	public void IncrementActionTest(){
		
		Player player = new Player();
		ActionManager actionManager = new ActionManager(player);
		IncrementAffecter affecter = new IncrementAffecter();
		IncrementAction increment = actionManager.newIncrementResource(new ResourceList(new Coin(5)));
		
		//Test fatto male ma per sbrigarmi
		increment.perform();
		
		affecter.attach(actionManager);
		
		increment = actionManager.newIncrementResource(new ResourceList(new Coin(5)));
		
		increment.perform();
	}

}
