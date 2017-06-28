package it.polimi.ingsw.ps11.posTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import it.polimi.ingsw.ps11.model.cards.list.GreenCard;
import it.polimi.ingsw.ps11.model.cards.list.YellowCard;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.BlackFamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.affecter.IncrementAffecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.FamilyInFloorAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.IncrementAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.effects.AddResourceEffect;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.Stone;
import it.polimi.ingsw.ps11.model.resources.list.Wood;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.towers.GreenTower;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.model.zones.towers.YellowTower;

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
	
	
	@Test
	public void FamilyInFloorTest(){
		//Da completare
		
		Player player = new Player();
		ResourceList startResource = new ResourceList(new Wood(5));
		player.getResourceList().sum(startResource);
		FamilyMember fMember = player.getFamilyManager().getFamilyMember(BlackFamilyMember.class);
		fMember.setValue(5);
		
		YellowCard card = new YellowCard("carta");
		ResourceList cardCost = new ResourceList(new Wood(4));
		card.addCost(cardCost);
		
		Tower tower = new YellowTower();
		Floor floor = tower.getFloor(1);
		floor.setCard(card);
		
		ActionManager aManager = new ActionManager(player);
		
		FamilyInFloorAction action = aManager.newFamilyInFloorAction(tower, floor, fMember, cardCost);
		if(action.isLegal())
			action.perform();
		
		//Dopo aver eseguito la placeInFloor Action la situazione è:
		
		//Il floor ha come owner il player
		assertEquals(floor.getActionSpace().getOwner(), player);
		//Il player ha tra le carte la carta che era sul piano
		assertEquals(player.getCardManager().getCardList(YellowCard.class).contains(card), true);
		//Il player ha pagato il costo della carta (aveva 5 wood - 4 wood = 1 )
		assertEquals(player.getResourceList().getResource(Wood.class).getValue(), 1);
		
		
   //Testo gli effetti
		
		//Do al giocatore +5 wood
		player.getResourceList().sum(startResource);
		assertEquals(player.getResourceList().getResource(Wood.class).getValue(), 6);
		
		GreenCard card2 = new GreenCard("secondaCarta");
		ResourceList card2Cost = new ResourceList(new Wood(3));
		card2.addCost(card2Cost);
		
		Tower greenTower = new GreenTower();
		Floor floor2 = greenTower.getFloor(1);
		floor2.setCard(card2);
		
		AddResourceEffect addResourceEffect = new AddResourceEffect(new ResourceList(new Coin(3)));
		
		card2.getIstantEffect().add(addResourceEffect);
		
		Action action2 = aManager.newFamilyInFloorAction(greenTower, floor2, fMember, card2Cost);
		
		if (action2.isLegal())
			action2.perform();
		
		//Dopo aver eseguito la placeInFloor Action la situazione è:
		
		//Il floor ha come owner il player
		assertEquals(floor2.getActionSpace().getOwner(), player);
		//Il player ha tra le carte la carta che era sul piano
		assertEquals(player.getCardManager().getCardList(GreenCard.class).contains(card2), true);
		//Il player ha pagato il costo della carta (aveva 6 wood - 3 wood = 3 )
		assertEquals(player.getResourceList().getResource(Wood.class).getValue(), 3);
		//La carta aveva un bonus istantaneo +3 coin quindi il giocatore dovrà avere 3 coin
		assertEquals(player.getResourceList().getResource(Coin.class).getValue(), 3);
		
	}
	
	@Test
	public void FamilyMemberAffecterTest(){

		Player player = new Player();
		ResourceList startResource = new ResourceList(new Stone(5));
		player.getResourceList().sum(startResource);
		FamilyMember fMember = player.getFamilyManager().getFamilyMember(BlackFamilyMember.class);
		fMember.setValue(1);
		
		YellowCard card = new YellowCard("carta");
		ResourceList cardCost = new ResourceList(new Stone(4));
		card.addCost(cardCost);
		
		Tower tower = new YellowTower();
		Floor floor = tower.getFloor(1);
		floor.setCard(card);
		
		ActionManager aManager = new ActionManager(player);
		
		
		
		FamilyInFloorAction action = aManager.newFamilyInFloorAction(tower, floor, fMember, cardCost);
		if(action.isLegal())
			action.perform();
	}
	

}
