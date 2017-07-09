package it.polimi.ingsw.ps11.actions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

import org.junit.Test;

import it.polimi.ingsw.ps11.model.gameLogics.GameLogic;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.affecter.DecrementAffecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.resources.DecrementAction;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.Servant;
import it.polimi.ingsw.ps11.model.resources.list.Stone;
import it.polimi.ingsw.ps11.model.resources.list.Wood;

public class DecrementActionTest {
	

	
	private ActionManager initializeAManager(Player player){
		ArrayList<Player> players = new ArrayList<>();
		players.add(player);
		GameLogic gameLogic = new GameLogic(players);
		return gameLogic.getPlayerStatus().get(0).actions();
	}
	
	@Test
	public void decrementActionTest(){
		
		// Inizializzo un player
		Player player = new Player();
		ResourceList playerResources = player.getResourceList();
		playerResources.setResource(new Coin(5),new Stone(2),new Wood(2));
		
		
		//Definisco la resourceList che andrà sottratta alle risorse del player
		ResourceList resourceToSubtract = new ResourceList(new Coin(2),new Wood(2));
		
		//Le Action per essere usate necessitano di un ActionManager con all'interno un player:
		ActionManager aManager = initializeAManager(player);
		
		DecrementAction decrementAction = new DecrementAction(aManager, resourceToSubtract);
		
		if(decrementAction.isLegal())
			decrementAction.perform();
		
		assertEquals( new Coin().getFrom(playerResources), new Coin(3));
		assertEquals( new Stone().getFrom(playerResources),new Stone(2));
		assertEquals( new Wood().getFrom(playerResources), new Wood(0));
		
		//Sommiamo una risorceList vuota, le risorse dovranno rimanere invariate
		
		ResourceList resourceListEmpty = new ResourceList();
		
		DecrementAction incrementEmpty = new DecrementAction(aManager, resourceListEmpty);
		
		if(incrementEmpty.isLegal())
			incrementEmpty.perform();
		
		assertEquals( new Coin().getFrom(playerResources), new Coin(3));
		assertEquals( new Stone().getFrom(playerResources),new Stone(2));
		assertEquals( new Wood().getFrom(playerResources), new Wood(0));
		
		//Sommiamo una risorceList nulla, le risorse dovranno rimanere invariate
		resourceToSubtract = new ResourceList();
		DecrementAction incrementNull = new DecrementAction(aManager, null);
		
		if(incrementNull.isLegal())
			incrementNull.perform();
		
		assertEquals( new Coin().getFrom(playerResources), new Coin(3));
		assertEquals( new Stone().getFrom(playerResources),new Stone(2));
		assertEquals( new Wood().getFrom(playerResources), new Wood(0));
				
		
		
		// Proviamo a sottrarre una resourceList con una resource di valore maggiore alla corrispondente risorsa del giocatore
		
		playerResources.setResource(new Coin(5),new Stone(2),new Wood(2));
		ResourceList resourceToSubtract_2 = new ResourceList(new Coin(2),new Wood(3)); 
		
		DecrementAction decrementAction_2 = new DecrementAction(aManager, resourceToSubtract_2);
		
		//Il giocatore ha 2 wood, se proviamo a sottrargli una resourceList con wood = 3 la isLegal ritorna false
		assertFalse(decrementAction_2.isLegal());
	}
	
	@Test
	public void decrementAffecterTest(){
		
		// Inizializzo un player
		Player player = new Player();
		ResourceList playerResources = player.getResourceList();
		playerResources.setResource(new Coin(5),new Stone(2),new Wood(2));
		
		
		//Definisco la resourceList che andrà sottratta alle risorse del player
		ResourceList resourceToSubtract = new ResourceList(new Coin(1),new Wood(2));
		
		//Le Action per essere usate necessitano di un ActionManager con all'interno un player:
		ActionManager aManager = initializeAManager(player);
		
		DecrementAction decrementAction = new DecrementAction(aManager, resourceToSubtract);
		
		
		// Questo affecter triplica il costo in monete di qualsiasi cosa
		DecrementAffecter decrementAffecter = new DecrementAffecter(new Coin().getId(), 3);
		aManager.add(decrementAffecter);
		
		
		DecrementAction effectiveAction = aManager.affect(decrementAction);
	
		
		if(effectiveAction.isLegal())
			effectiveAction.perform();
		
		//Dovevo sottrarre 1 coin e 2 wood, essendoci però l'affecter verranno sottratte 3 coin e 2 wood
		assertEquals( new Coin().getFrom(playerResources), new Coin(2));
		assertEquals( new Stone().getFrom(playerResources),new Stone(2));
		assertEquals( new Wood().getFrom(playerResources), new Wood(0));
		
		//Aggiungiamo un altro affecter:
		
		// Questo affecter aumenta il decremento di 2 Stone, bisogna tenere conto che è presente l'affecter precedente
		
		playerResources.setResource(new Coin(5),new Stone(2),new Wood(2)); // resetto le risorse del player
		
		DecrementAffecter decrementAffecter_stone = new DecrementAffecter(new Stone().getId(), 2);
		aManager.add(decrementAffecter_stone);
		
		
		DecrementAction effectiveAction_2 = aManager.affect(decrementAction);
	
		
		if(effectiveAction_2.isLegal())
			effectiveAction_2.perform();
		
		// La decrementAction dovrebbe sottrarre 1 Coin e 2 wood, questo decremento viene aumentato dal primo affecter
		// e portato a 3 coin.
		// Il secondo affecter non influenza l'azione perchè moltiplica per due il decremento di stone che in questo caso è zero
		// quindi il decremento totale dovrà essere di  3 coin, 0 stone e 2 wood: 
		assertEquals( new Coin().getFrom(playerResources), new Coin(2));
		assertEquals( new Stone().getFrom(playerResources),new Stone(2));
		assertEquals( new Wood().getFrom(playerResources), new Wood(0));
		
		
		// Stessa situazione ma ora i costi modificati superano le risorse del giocatore:
		
		playerResources.setResource(new Coin(5),new Stone(2),new Wood(2)); // resetto le risorse del player

		
		// Aggiungo un'altro affecter che incrementa il costo di 3 servant (il player ha 0 servant
		DecrementAffecter decrementAffecter_servant = new DecrementAffecter(new Coin().getId(), 4);
		aManager.add(decrementAffecter_servant);
		
		assertFalse(aManager.affect(decrementAction).isLegal());
		
		DecrementAction clone = decrementAction.clone();
		assertEquals(clone.getResources().get(new Coin().getId()).getValue(), decrementAction.getResources().get(new Coin().getId()).getValue());
	}
	

}
