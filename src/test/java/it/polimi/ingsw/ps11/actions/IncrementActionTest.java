package it.polimi.ingsw.ps11.actions;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import it.polimi.ingsw.ps11.model.gameLogics.GameLogic;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.affecter.IncrementAffecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.resources.IncrementAction;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.Stone;
import it.polimi.ingsw.ps11.model.resources.list.Wood;

public class IncrementActionTest {
	

	
	private ActionManager initializeAManager(Player player){
		ArrayList<Player> players = new ArrayList<>();
		players.add(player);
		GameLogic gameLogic = new GameLogic(players);
		return gameLogic.getPlayerStatus().get(0).actions();
	}
	
	@Test
	public void incrementActionTest(){
		
		// Inizializzo un player
		Player player = new Player();
		ResourceList playerResources = player.getResourceList();
		playerResources.setResource(new Coin(5),new Stone(2),new Wood(2));
		
		
		//Definisco la resourceList che andrà sommata alle risorse del player
		ResourceList resourceToAdd = new ResourceList(new Coin(2),new Wood(3));
		
		//Le Action per essere usate necessitano di un ActionManager con all'interno un player:
		ActionManager aManager = initializeAManager(player);
		
		IncrementAction incrementAction = new IncrementAction(aManager, resourceToAdd);
		
		if(incrementAction.isLegal())
			incrementAction.perform();
		
		assertEquals(playerResources.get(new Coin().getId()),new Coin(7));
		assertEquals(playerResources.get(new Stone().getId()),new Stone(2));
		assertEquals(playerResources.get(new Wood().getId()),new Wood(5));
		
		//Sommiamo una risorceList vuota, le risorse dovranno rimanere invariate
		
		ResourceList resourceListEmpty = new ResourceList();
		
		IncrementAction incrementEmpty = new IncrementAction(aManager, resourceListEmpty);
		
		if(incrementEmpty.isLegal())
			incrementEmpty.perform();
		
		assertEquals(playerResources.get(new Coin().getId()),new Coin(7));
		assertEquals(playerResources.get(new Stone().getId()),new Stone(2));
		assertEquals(playerResources.get(new Wood().getId()),new Wood(5));
		
		//Sommiamo una risorceList nulla, le risorse dovranno rimanere invariate
		
		IncrementAction incrementNull = new IncrementAction(aManager, null);
		
		if(incrementNull.isLegal())
			incrementNull.perform();
		
		assertEquals(playerResources.get(new Coin().getId()),new Coin(7));
		assertEquals(playerResources.get(new Stone().getId()),new Stone(2));
		assertEquals(playerResources.get(new Wood().getId()),new Wood(5));
				
		
		
	}
	
	@Test
	public void incrementAffecterTest(){
		
		// Inizializzo un player
		Player player = new Player();
		ResourceList playerResources = player.getResourceList();
		playerResources.setResource(new Coin(5),new Stone(2),new Wood(2));
		
		
		//Definisco la resourceList che andrà sommata alle risorse del player
		ResourceList resourceToAdd = new ResourceList(new Coin(2),new Wood(3));
		
		//Le Action per essere usate necessitano di un ActionManager con all'interno un player:
		ActionManager aManager = initializeAManager(player);
		
		IncrementAction incrementAction = new IncrementAction(aManager, resourceToAdd);
		
		//Aggiungiamo all'action manager un incrementAffecter che dimunisce il valore delle risorse incrementate
		//di un tot
		ResourceList toDecrese = new ResourceList(new Coin(1), new Wood(1));
		IncrementAffecter decreserAffecter = new IncrementAffecter(toDecrese);
		
		aManager.add(decreserAffecter);  //Da questo momento in poi le action incrementeranno di 1 coin e 1 wood in meno
		
		IncrementAction incrementActionAffected = aManager.affect(incrementAction);
		
		
		if(incrementActionAffected.isLegal())
			incrementActionAffected.perform();
		
		
		assertEquals(playerResources.get(new Coin().getId()),new Coin(6));
		assertEquals(playerResources.get(new Stone().getId()),new Stone(2));
		assertEquals(playerResources.get(new Wood().getId()),new Wood(4));
		
		//Aggiungiamo un affecter che influenza una risorsa che non viene coinvolta nell'increment 
		//(es: resourceToAdd ha 2 Coin e 3 Wood, creiamo un affecter che decrementa di 1 Coin e 2 Stone)
		
		ResourceList toDecrese_2 = new ResourceList(new Coin(1), new Stone(2));
		IncrementAffecter decreserAffecter_2 = new IncrementAffecter(toDecrese_2);
		
		aManager.add(decreserAffecter_2);  //Da questo momento in poi le action incrementeranno di 1 coin e 1 stone in meno
										   //(Che vanno sommati all'affecter precedente quindi: 2 coin 1 stone e 1 wood)
		
		incrementActionAffected = aManager.affect(incrementAction);
				
		if(incrementActionAffected.isLegal())
			incrementActionAffected.perform();
		
		//L'incrementAction di base dovrebbe incrementare di 2 coin e 3 wood, però sono stati aggiunti 2 affecter
		//che diminuiscono l'effetto rispettivamente di 1 coin e 1 wood e 1 coin e 2 stone. Quindi l'incremento totale
		//dovra' essere di 0 coin e 2 wood (le stone non comparivano nell'incremento originale e non devono essere alterate)
		
		assertEquals(playerResources.get(new Coin().getId()),new Coin(6));
		assertEquals(playerResources.get(new Stone().getId()),new Stone(2));
		assertEquals(playerResources.get(new Wood().getId()),new Wood(6));
		
		IncrementAction clone = incrementAction.clone();
		assertEquals(clone.getResources().get(new Coin().getId()).getValue(), incrementAction.getResources().get(new Coin().getId()).getValue());
		Assert.assertNull(clone.getResources().get(new Stone().getId()));
	}
	

}
