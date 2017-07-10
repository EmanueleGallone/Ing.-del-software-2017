package it.polimi.ingsw.ps11.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import it.polimi.ingsw.ps11.controller.server.gameServer.PlayerFactory;
import it.polimi.ingsw.ps11.model.cards.effects.AddResourceEffect;
import it.polimi.ingsw.ps11.model.cards.list.GreenCard;
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
import it.polimi.ingsw.ps11.model.gameLogics.states.VaticanReport;
import it.polimi.ingsw.ps11.model.gameLogics.states.WaitCard;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.FaithPoint;
import it.polimi.ingsw.ps11.model.resources.list.Stone;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.view.viewEvents.ActiveLeaderCardEvent;
import it.polimi.ingsw.ps11.view.viewEvents.AskUpdateEvent;
import it.polimi.ingsw.ps11.view.viewEvents.ConfirmViewEvent;
import it.polimi.ingsw.ps11.view.viewEvents.EndTurnEvent;
import it.polimi.ingsw.ps11.view.viewEvents.FamilySelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.ResourceSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.CouncilSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.FloorSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.HarvestSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.MarketSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.ProductionSelectedEvent;

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
		// [*]1 vuol dire che e' riferito al primo giocatore (Player1); [*]2 vuol dire che e' riferito al secondo giocatore
		ArrayList<Player> players = new PlayerFactory().take(2);
		for(int i = 0; i < players.size(); i++)
			players.get(i).setName("Giocatore " + (i+1));
		
		GameLogic gameLogic = new GameLogic(players);
		gameLogic.run(); //viene avviato il gioco
		StateHandler stateHandler1 = gameLogic.getPlayerStatus().get(0);
		StateHandler stateHandler2 = gameLogic.getPlayerStatus().get(1);
		
		
		Player player1 = stateHandler1.getPlayer();
		ActionManager aManager1 = stateHandler1.actions();
		System.out.println("variabile player1: " + player1.getName());
		
		Player player2 = stateHandler2.getPlayer();
		ActionManager aManager2 = stateHandler2.actions();
		System.out.println("variabile player2 : " + player2.getName());
		
		ActionSpace marketSpaceCoin = gameLogic.getGame().getBoard().getMarket().getActionSpace(0);
		Tower yellowTower = gameLogic.getGame().getBoard().getTower("YellowTower");
		
		int coinBeforeAction1 = player1.getResourceList().get("Coin").getValue();
		
		OrangeFamilyMember orangeFamilyMember1 = new OrangeFamilyMember().getFrom(player1.getFamilyManager()); //prendo l'orange family member dal primo giocatore
		FamilyInSpaceAction familyInSpaceAction = new FamilyInSpaceAction(aManager1, orangeFamilyMember1, marketSpaceCoin); //simulo l'azione del posizionare il familiare all'interno del market
		assertTrue(familyInSpaceAction.notifyConfirm(new ConfirmViewEvent(true))); //effettuo l'azione confermandola
		
		assertEquals(coinBeforeAction1+5, player1.getResourceList().get(new Coin().getId()).getValue()); //avendo posizionato nel market, il giocatore 1 deve avere +5 monete
		
		ViewEvent endturn1 = new EndTurnEvent();
		endturn1.setSource(player1);
		
		gameLogic.handle(endturn1); // il giocatore 1 passa il turno
		
		FamilySelectedEvent familySelectedEvent2 = new FamilySelectedEvent(new OrangeFamilyMember().getId());
		familySelectedEvent2.setSource(player2);
		
		gameLogic.handle(familySelectedEvent2); //notifico la selezione del familiare. ora e' in attesa della conferma
		
		MarketSelectedEvent marketSelectedEvent = new MarketSelectedEvent(0);
		marketSelectedEvent.setSource(player2);
		
		gameLogic.handle(marketSelectedEvent); // il giocatore 2 seleziona lo spazio azione 1 ora e' in attesa della conferma
		
		OrangeFamilyMember orangeFamilyMember2 = new OrangeFamilyMember().getFrom(player2.getFamilyManager());
		FamilyInSpaceAction familyInSpaceAction2 = new FamilyInSpaceAction(aManager2, orangeFamilyMember2, marketSpaceCoin); //faccio posizionare il familiare nello spazio azione
		assertFalse(familyInSpaceAction2.notifyConfirm(new ConfirmViewEvent(true))); // azione non possibile in quanto gia' occupata
		
		FloorSelectedEvent floorSelectedEvent2 = new FloorSelectedEvent("YellowTower", 0); //il giocatore 2 seleziona il primo piano della torre gialla
		floorSelectedEvent2.setSource(player2);
		gameLogic.handle(floorSelectedEvent2); // il game riceve l'evento
		
		ActionSpace yellowTowerfirstActionSpace = yellowTower.getFloor(0).getActionSpace();
		
		familyInSpaceAction2 = new FamilyInSpaceAction(aManager2, orangeFamilyMember2, yellowTowerfirstActionSpace);
		FamilyInTowerAction familyInTowerAction2 = new FamilyInTowerAction(aManager2, yellowTower, orangeFamilyMember2); // il giocatore 2 posiziona
		assertTrue(familyInTowerAction2.isLegal()); // e' legale in quanto nella torre non c'e' nessuno
		
		YellowCard yellowCard = new YellowCard("YellowCardFirstFloor");
		yellowCard.addInstantEffect(new AddResourceEffect(new ResourceList(new Stone(1))));
		yellowCard.addCost(new ResourceList(new FaithPoint(10))); 
		yellowCard.addCost(new ResourceList(new Stone(1))); // multicost
		
		familySelectedEvent2 = new FamilySelectedEvent(orangeFamilyMember2.getId());
		familySelectedEvent2.setSource(player2);
		gameLogic.handle(familySelectedEvent2);
		
		ResourceSelectedEvent resourceSelectedEvent2 = new ResourceSelectedEvent(yellowCard.getCosts().get(1));
		resourceSelectedEvent2.setSource(player2);
		gameLogic.handle(resourceSelectedEvent2);
		
		GetCardAction getCardAction2 = new GetCardAction(aManager2, yellowCard, resourceSelectedEvent2.getResourceList());
		
		FamilyInFloorAction familyInFloorAction2 = new FamilyInFloorAction(aManager2, familyInTowerAction2, familyInSpaceAction2, getCardAction2);
		assertTrue(familyInFloorAction2.notifyConfirm(new ConfirmViewEvent(true)));
		
		assertEquals(2, player2.getResourceList().get("Stone").getValue());// il giocatore deve avere le stesse risorse di prima. nota bene la carta
		assertEquals(orangeFamilyMember2, yellowTower.getFloor(0).getActionSpace().getFamilyMember()); // e' stato posizionato il familiare arancione del secondo giocatore
		
		ViewEvent endTurn2 = new EndTurnEvent();
		endTurn2.setSource(player2);
		
		gameLogic.handle(endTurn2); // il giocatore 2 passa il turno.
		
		AskUpdateEvent askUpdateEvent2 = new AskUpdateEvent();
		askUpdateEvent2.setSource(player2); //il player 2 e' nel default state
		
		gameLogic.handle(askUpdateEvent2);
		
		FamilyInTowerAction familyInTowerAction = new FamilyInTowerAction(aManager1, yellowTower, orangeFamilyMember1);
		assertTrue(familyInTowerAction.isLegal()); //puo' posizionare nella torre. non ha familiare all'interno
		familyInSpaceAction = new FamilyInSpaceAction(aManager1, orangeFamilyMember1, yellowTowerfirstActionSpace); //prova ad usare lo stesso familiare
		assertFalse(familyInSpaceAction.notifyConfirm(new ConfirmViewEvent(true))); //non e' possibile usare lo stesso familiare
		
		familyInSpaceAction = new FamilyInSpaceAction(aManager1, player1.getFamilyManager().getFamilyMember("BlackFamilyMember"), yellowTowerfirstActionSpace); //uso un altro familiare
		assertFalse(familyInSpaceAction.notifyConfirm(new ConfirmViewEvent(true))); //non e' comunque possibile in quanto e' gia' occupato
		
		familyInTowerAction = new FamilyInTowerAction(aManager1, yellowTower , player1.getFamilyManager().getFamilyMember("BlackFamilyMember"));
		familyInSpaceAction = new FamilyInSpaceAction(aManager1, player1.getFamilyManager().getFamilyMember("BlackFamilyMember"), yellowTowerfirstActionSpace);
		GetCardAction getCard = new GetCardAction(aManager1, yellowCard, yellowCard.getCosts().get(1)); //gli passo direttamente il costo
		FamilyInFloorAction familyInFloorAction = new FamilyInFloorAction(aManager1, familyInTowerAction, familyInSpaceAction, getCard);
	
		assertFalse(familyInFloorAction.notifyConfirm(new ConfirmViewEvent(true))); // non e' possibile in quanto quello spazio azione e' gia' occupato		
	}
	
	@Test
	public void defaultStateTest(){
		ArrayList<Player> players = new PlayerFactory().take(2);
		for(int i = 0; i < players.size(); i++)
			players.get(i).setName("Giocatore " + (i+1));
		
		GameLogic gameLogic = new GameLogic(players);
		gameLogic.run();
		
		StateHandler stateHandler1 = gameLogic.getPlayerStatus().get(0);
		Player player1 = stateHandler1.getPlayer(); //sara' in default state
		ActionManager aManager1 = stateHandler1.actions();
		
		StateHandler stateHandler2 = gameLogic.getPlayerStatus().get(1);
		Player player2 = stateHandler2.getPlayer(); //sara' in playstate
		ActionManager aManager2 = stateHandler2.actions();
		
		AskUpdateEvent askUpdateEvent1 = new AskUpdateEvent();
		askUpdateEvent1.setSource(player1);
		
		gameLogic.handle(askUpdateEvent1);
		
		ProductionSelectedEvent productionSelectedEvent1 = new ProductionSelectedEvent();
		productionSelectedEvent1.setFamilySelectedEvent(new FamilySelectedEvent(player1.getFamilyManager().getFamilyMember("BlackFamilyMember").getId()));
		productionSelectedEvent1.setSource(player1);
		
		gameLogic.handle(productionSelectedEvent1);
		
		CouncilSelectedEvent councilSelectedEvent1 = new CouncilSelectedEvent();
		councilSelectedEvent1.setFamilySelectedEvent(new FamilySelectedEvent(player1.getFamilyManager().getFamilyMember("BlackFamilyMember").getId()));
		councilSelectedEvent1.setSource(player1);
		
		gameLogic.handle(councilSelectedEvent1); // il giocatore e' in default state, quindi non accadra' nulla
		
		CouncilSelectedEvent councilSelectedEvent2 = new CouncilSelectedEvent();
		councilSelectedEvent2.setFamilySelectedEvent(new FamilySelectedEvent(player2.getFamilyManager().getFamilyMember("BlackFamilyMember").getId()));
		councilSelectedEvent2.setSource(player2);
		
		gameLogic.handle(councilSelectedEvent2);
		
		ActionSpace councilActionSpace = gameLogic.getGame().getBoard().getCouncilPalace().getActionSpace(0);
		FamilyInSpaceAction familyInSpaceAction2 = new FamilyInSpaceAction(aManager2, player2.getFamilyManager().getFamilyMember("BlackFamilyMember"), councilActionSpace);
		
		assertTrue(familyInSpaceAction2.isLegal());
		assertTrue(familyInSpaceAction2.notifyConfirm(new ConfirmViewEvent(true)));
		familyInSpaceAction2.perform(); //perform action
		
		assertTrue(player2.getFamilyManager().getFamilyMember("BlackFamilyMember").isUsed());
		
	}
	
	@Test
	public void playStateTest(){
		ArrayList<Player> players = new PlayerFactory().take(1);
		for(int i = 0; i < players.size(); i++)
			players.get(i).setName("Giocatore " + (i+1));
		
		GameLogic gameLogic = new GameLogic(players);
		gameLogic.run();
		StateHandler stateHandler = gameLogic.getPlayerStatus().get(0);
		Player player = stateHandler.getPlayer();
		
		ProductionSelectedEvent productionSelectedEvent = new ProductionSelectedEvent();
		productionSelectedEvent.setSource(player);
		FamilySelectedEvent familySelectedEvent = new FamilySelectedEvent(player.getFamilyManager().getFamilyMember("WhiteFamilyMember").getId());
		productionSelectedEvent.setFamilySelectedEvent(familySelectedEvent);
		
		gameLogic.handle(productionSelectedEvent);
		
		HarvestSelectedEvent harvestSelectedEvent = new HarvestSelectedEvent();
		harvestSelectedEvent.setSource(player);
		harvestSelectedEvent.setFamilySelectedEvent(familySelectedEvent);
		
		gameLogic.handle(harvestSelectedEvent);
		
		String name = player.getCardManager().getLeaderCards().get(1).getName();
		ActiveLeaderCardEvent activeLeaderCardEvent = new ActiveLeaderCardEvent(name);
		activeLeaderCardEvent.setSource(player);
		
		gameLogic.handle(activeLeaderCardEvent);
		gameLogic.handle(activeLeaderCardEvent);
		
		
	}
	
	@Test
	public void vaticanReportTesT(){
		ArrayList<Player> players = new PlayerFactory().take(1);
		for(int i = 0; i < players.size(); i++)
			players.get(i).setName("Giocatore " + (i+1));
		
		GameLogic gameLogic = new GameLogic(players);
		gameLogic.run();
		StateHandler stateHandler = gameLogic.getPlayerStatus().get(0);
		Player player = stateHandler.getPlayer();
		
		EndTurnEvent endTurnEvent = new EndTurnEvent();
		endTurnEvent.setSource(player);
		
		player.getResourceList().setResource(new FaithPoint(10));
		
		for(int i = 0; i < 22; i++)
			gameLogic.handle(endTurnEvent);
		
		ConfirmViewEvent confirmViewEvent = new ConfirmViewEvent(true);
		confirmViewEvent.setSource(player);
		
		VaticanReport vaticanReport = new VaticanReport(stateHandler);
		vaticanReport.handle(confirmViewEvent); //emulo che il giocatore confermi di voler mostrare il sostegno al
		
		vaticanReport.handle(new ConfirmViewEvent(false));
		
	}
	
//	@Test
//	public void waitCardTest(){
//		ArrayList<Player> players = new PlayerFactory().take(1);
//		for(int i = 0; i < players.size(); i++)
//			players.get(i).setName("Giocatore " + (i+1));
//		
//		GameLogic gameLogic = new GameLogic(players);
//		gameLogic.run();
//		StateHandler stateHandler = gameLogic.getPlayerStatus().get(0);
//		Player player = stateHandler.getPlayer();
//		
//		
//		
//	}

}
