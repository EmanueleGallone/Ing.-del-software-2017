package it.polimi.ingsw.ps11.posTest;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.ps11.model.gameLogics.newTry.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.newTry.actions.IncrementAction;
import it.polimi.ingsw.ps11.model.gameLogics.newTry.affecter.IncrementAffecter;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;

public class ActionsTest {
	
	@Test
	public void IncrementActionTest(){
		
		// Da completare
		
		Player player = new Player();
		ActionManager actionManager = new ActionManager(player);

		IncrementAction increment = actionManager.newIncrementAction(new ResourceList(new Coin(5)));
		
		//Non c'e' ancora nessuno ad influenzare questa azione quindi il risultato della increment dovrebbe essere 5
		increment.perform();
		assertEquals(player.getResourceList().getResource(Coin.class).getValue(),5);
		
		// Creo il malus che diminuisce le coin ogni volta di 2
		IncrementAffecter affecter = new IncrementAffecter(new ResourceList(new Coin(2)));
		affecter.attach(actionManager);
		
		increment = actionManager.newIncrementAction(new ResourceList(new Coin(5)));
		
		// Il player aveva gia' 5 monete, faccio la increment di altre 5 ma essendoci il malus ne riceve solo altre 3 
		// quindi va ad 8
		increment.perform();
		assertEquals(player.getResourceList().getResource(Coin.class).getValue(),8);
		
		// ___________________________________________
		
		IncrementAffecter affecter2 = new IncrementAffecter(new ResourceList(new Coin(3)));
		affecter2.attach(actionManager);
		
		increment = actionManager.newIncrementAction(new ResourceList(new Coin(5)));
		
		// Il giocatore ha 8 monete
		// Ci sono pero' due malus malus che riducono l'increment rispettivamente di 2 e di 3 quindi 
		// dopo l'increment di +5 dovrebbe avere ancora 8 monete
		
		increment.perform();
		assertEquals(player.getResourceList().getResource(Coin.class).getValue(), 8);
	}
	

}
