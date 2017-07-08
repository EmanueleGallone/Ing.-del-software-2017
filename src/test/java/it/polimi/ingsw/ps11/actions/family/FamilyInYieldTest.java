package it.polimi.ingsw.ps11.actions.family;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import it.polimi.ingsw.ps11.controller.server.gameServer.PlayerFactory;
import it.polimi.ingsw.ps11.model.cards.effects.AddResourceEffect;
import it.polimi.ingsw.ps11.model.cards.list.GreenCard;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.BlackFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.NeutralFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.OrangeFamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.GameLogic;
import it.polimi.ingsw.ps11.model.gameLogics.StateHandler;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInSpaceAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInTowerAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInYieldAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.resources.IncrementAction;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.Wood;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.towers.GreenTower;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.model.zones.yield.Yield;

public class FamilyInYieldTest {

	Player player1, player2;
	
	ArrayList<Player> players;
			
	GameLogic gameLogic;
	FamilyInYieldAction action1;
	StateHandler handler1, handler2;
	ActionManager aManager1, aManager2;
		
	ResourceList resourceListCoin, resourceListWood;
	GreenCard card1, card2;
	Yield harvest;
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setting(){
		
		//Inizializzo l'action manager e il player
		PlayerFactory factory = new PlayerFactory();
		player1 = factory.newPlayer("Giocatore 1", 0);
		player2 = factory.newPlayer("Giocatore 2", 1);
		
		players = new ArrayList<>();
		players.add(player1);
		players.add(player2);
			
		gameLogic = new GameLogic(players);
		handler1 = new StateHandler(gameLogic, player1);
		handler2 = new StateHandler(gameLogic, player2);
		
		//Prendo l'action manager del Giocatore 1 
		aManager1 = handler1.actions();
		aManager2 = handler2.actions();
		//Inizializzo le risorse del Giocatore 1
		
		resourceListCoin = new ResourceList(new Coin(3));
		resourceListWood = new ResourceList(new Wood(3));
		
		card1 = new GreenCard();
		card1.addInstantEffect(new AddResourceEffect(resourceListCoin));
		card1.setActiveValue(2);
		player1.getCardManager().addCard(card1);
		
		card2 = new GreenCard();
		card2.addInstantEffect(new AddResourceEffect(resourceListWood));
		card2.setActiveValue(4);
		player1.getCardManager().addCard(card2);
		
		harvest = new Yield(GreenCard.class);
		}
	
	@Test
	public void isLegalTest(){
		
		//assertTrue(action1.isLegal()); 			//il controllo è nel FamilyInSpaceTest
	}
	
	@Test
	public void performTest(){
		//assertEquals(3, player1.getResourceList().get(Coin.class).getValue());		//la prima carta viene attivata
		//assertNull(player1.getResourceList().get(Wood.class).getValue());			//la seconda carta non viene attivata
	}
	
	
	@Test
	public void Test(){
		
	}
}
