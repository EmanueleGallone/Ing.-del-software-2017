package it.polimi.ingsw.ps11.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import it.polimi.ingsw.ps11.controller.server.gameServer.PlayerFactory;
import it.polimi.ingsw.ps11.model.cards.effects.AddResourceEffect;
import it.polimi.ingsw.ps11.model.cards.list.YellowCard;
import it.polimi.ingsw.ps11.model.familyMember.list.OrangeFamilyMember;
import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.gameLogics.GameLogic;
import it.polimi.ingsw.ps11.model.gameLogics.StateHandler;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.GetCardAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInFloorAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInSpaceAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInTowerAction;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.FaithPoint;
import it.polimi.ingsw.ps11.model.resources.list.Stone;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.view.viewEvents.ConfirmViewEvent;
import it.polimi.ingsw.ps11.view.viewEvents.EndTurnEvent;
import it.polimi.ingsw.ps11.view.viewEvents.FamilySelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.ResourceSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.FloorSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.MarketSelectedEvent;

public class GameTest {

	@Test
	public void roundManagertest() {
		Game game = new Game(new PlayerFactory().takeAll());
		
		assertEquals(4, game.getRoundManager().getCurrentOrder().size());
		assertEquals(5 , game.getRoundManager().getCurrentOrder().get(0).getResourceList().get(new Coin().getId()).getValue());
		assertEquals(6 , game.getRoundManager().getCurrentOrder().get(1).getResourceList().get(new Coin().getId()).getValue());
		assertEquals(7 , game.getRoundManager().getCurrentOrder().get(2).getResourceList().get(new Coin().getId()).getValue());
		assertEquals(8 , game.getRoundManager().getCurrentOrder().get(3).getResourceList().get(new Coin().getId()).getValue());
	}
	
	@Test
	public void gamingTest(){
		ArrayList<Player> players = new PlayerFactory().take(2);
		for(int i = 0; i < players.size(); i++)
			players.get(0).setName("Giocatore " + i);
		
		GameLogic gameLogic = new GameLogic(players);
		gameLogic.run();
		StateHandler stateHandler1 = gameLogic.getPlayerStatus().get(0);
		StateHandler stateHandler2 = gameLogic.getPlayerStatus().get(1);
		
		
		Player player1 = stateHandler1.getPlayer();
		ActionManager aManager1 = stateHandler1.actions();
		
		Player player2 = stateHandler2.getPlayer();
		ActionManager aManager2 = stateHandler2.actions();
		
		ActionSpace marketSpace1 = gameLogic.getGame().getBoard().getMarket().getActionSpace(0);
		
		
		OrangeFamilyMember orangeFamilyMember1 = new OrangeFamilyMember().getFrom(player1.getFamilyManager()); //prendo l'orange family member dal primo giocatore
		FamilyInSpaceAction familyInFloorAction = new FamilyInSpaceAction(aManager1, orangeFamilyMember1, marketSpace1); //simulo l'azione del posizionare il familiare all'interno del market
		assertTrue(familyInFloorAction.notifyConfirm(new ConfirmViewEvent(true))); //effettuo l'azione confermandola
		
		assertEquals(10, player1.getResourceList().get(new Coin().getId()).getValue()); //avendo posizionato nel market, il giocatore 1 deve avere +5 monete
		
		ViewEvent endturn1 = new EndTurnEvent();
		endturn1.setSource(player1);
		
		gameLogic.handle(endturn1); // il giocatore 1 passa il turno
		
		MarketSelectedEvent marketSelectedEvent = new MarketSelectedEvent(0);
		marketSelectedEvent.setSource(player2);
		
		gameLogic.handle(marketSelectedEvent); // il giocatore 2 seleziona lo spazio azione 1
		
		OrangeFamilyMember orangeFamilyMember2 = new OrangeFamilyMember().getFrom(player2.getFamilyManager());
		FamilyInSpaceAction familyInSpaceAction2 = new FamilyInSpaceAction(aManager1, orangeFamilyMember1, marketSpace1); //faccio posizionare il familiare nello spazio azione
		assertFalse(familyInSpaceAction2.notifyConfirm(new ConfirmViewEvent(true))); // azione non possibile in quanto gia' occupata
		
		FloorSelectedEvent floorSelectedEvent2 = new FloorSelectedEvent("YellowTower", 0); //il giocatore 2 seleziona il primo piano della torre gialla
		floorSelectedEvent2.setSource(player2);
		gameLogic.handle(floorSelectedEvent2); // il game riceve l'evento
		
		ActionSpace yellowTowerfirstActionSpace = gameLogic.getGame().getBoard().getTower("YellowTower").getFloor(0).getActionSpace();
		
		familyInSpaceAction2 = new FamilyInSpaceAction(aManager2, orangeFamilyMember2, yellowTowerfirstActionSpace);
		FamilyInTowerAction familyInTowerAction2 = new FamilyInTowerAction(aManager2, gameLogic.getGame().getBoard().getTower("YellowTower"), orangeFamilyMember2); // il giocatore 2 posiziona
		assertTrue(familyInTowerAction2.isLegal()); // e' legale in quanto nella torre non c'e' nessuno
		
		YellowCard yellowCard = new YellowCard("YellowCardFirstFloor");
		yellowCard.addInstantEffect(new AddResourceEffect(new ResourceList(new Stone(1))));
		yellowCard.addCost(new ResourceList(new FaithPoint(10))); 
		yellowCard.addCost(new ResourceList(new Stone(1))); // multicost
		
		FamilySelectedEvent familySelectedEvent2 = new FamilySelectedEvent(orangeFamilyMember2.getId());
		familySelectedEvent2.setSource(player2);
		gameLogic.handle(familySelectedEvent2);
		
		ResourceSelectedEvent resourceSelectedEvent2 = new ResourceSelectedEvent(yellowCard.getCosts().get(1));
		resourceSelectedEvent2.setSource(player2);
		gameLogic.handle(resourceSelectedEvent2);
		
		GetCardAction getCardAction2 = new GetCardAction(aManager2, yellowCard, resourceSelectedEvent2.getResourceList());
		
		FamilyInFloorAction familyInFloorAction2 = new FamilyInFloorAction(aManager2, familyInTowerAction2, familyInSpaceAction2, getCardAction2);
		assertTrue(familyInFloorAction2.notifyConfirm(new ConfirmViewEvent(true)));
		
		assertEquals(2, player2.getResourceList().get("Stone").getValue());// il giocatore deve avere le stesse risorse di prima. nota bene la carta
		assertEquals(orangeFamilyMember2, gameLogic.getGame().getBoard().getTower("YellowTower").getFloor(0).getActionSpace().getFamilyMember()); // e' stato posizionato il familiare arancione del secondo giocatore
		
		ViewEvent endTurn2 = new EndTurnEvent();
		endTurn2.setSource(player2);
		
		gameLogic.handle(endTurn2); // il giocatore 2 passa il turno.
	}

}
