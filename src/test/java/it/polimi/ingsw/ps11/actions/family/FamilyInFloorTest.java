package it.polimi.ingsw.ps11.actions.family;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import it.polimi.ingsw.ps11.model.cards.effects.FamilyInSpaceBonus;
import it.polimi.ingsw.ps11.model.cards.list.GreenCard;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.BlackFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.NeutralFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.OrangeFamilyMember;
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
import it.polimi.ingsw.ps11.model.resources.list.Stone;
import it.polimi.ingsw.ps11.model.resources.list.Wood;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.view.viewEvents.ConfirmViewEvent;

public class FamilyInFloorTest {

	Player player1, player2;
	
	ArrayList<Player> players;
	
	FamilyMember familyMember1, orangeFamilyMember;
	FamilyMember familyMember2, blackFamilyMember;
			
	GameLogic gameLogic;
	
	FamilyInFloorAction floorAction;
	FamilyInTowerAction towerAction;
	GetCardAction getCardAction;
	FamilyInSpaceAction spaceAction;
	
	StateHandler handler1, handler2;
	ActionManager aManager1, aManager2;
		
	ResourceList cost1, cost2;
	
	Tower tower;
	Floor floor1, floor2;
	ArrayList<Floor> floors;
	ActionSpace actionSpace1, actionSpace2;
	GreenCard gCard1, gCard2;

	@Before
	public void setting(){
		
		//Inizializzo l'action manager e il player
		player1 = new Player("Giocatore 1");
		player2 = new Player("Giocatore 2");
		
		players = new ArrayList<>();
		players.add(player1);
		players.add(player2);
		
		familyMember1 = new NeutralFamilyMember();	
		orangeFamilyMember = new OrangeFamilyMember();
		
		familyMember2 = new NeutralFamilyMember();	
		blackFamilyMember = new BlackFamilyMember();
		
		player1.getFamilyManager().setFamilyMember(familyMember1);
		player1.getFamilyManager().setFamilyMember(orangeFamilyMember);

		player2.getFamilyManager().setFamilyMember(familyMember2);
		player2.getFamilyManager().setFamilyMember(blackFamilyMember);
			
		gameLogic = new GameLogic(players);
		handler1 = new StateHandler(gameLogic, player1);
		handler2 = new StateHandler(gameLogic, player2);
		
		//Prendo l'action manager del Giocatore 1 
		aManager1 = handler1.actions();
		aManager2 = handler2.actions();
		//Inizializzo le risorse del Giocatore 1
			
		player1.getResourceList().setResource(new Coin(3));
						
		gCard1 = new GreenCard(); gCard2 = new GreenCard();
		floor1 = new Floor(); floor2 = new Floor();
		floor1.setCard(gCard1); floor2.setCard(gCard2);
		floors = new ArrayList<>();
		floors.add(floor1);
		floors.add(floor2);
		
		cost1 = new ResourceList(new Coin(1), new Wood(1));
		cost2 = new ResourceList(new Stone(1));
		
		tower = new Tower(floors);
		
		//initializeTower(tower);	
	}
	
	
	@Test
	public void checkFloorTest(){
		
	}
	
	@Test
	public void isLegalTest(){
		
		ConfirmViewEvent confirmViewEvent = new ConfirmViewEvent(true);
		
		towerAction = new FamilyInTowerAction(aManager1, tower, player1.getFamilyManager().getFamilyMember(OrangeFamilyMember.class));
		getCardAction = new GetCardAction(aManager1, tower.getFloor(0).getCard(), cost1);
		spaceAction = new FamilyInSpaceAction(aManager1, player1.getFamilyManager().getFamilyMember(OrangeFamilyMember.class), tower.getFloor(0).getActionSpace());
		
		floorAction = new FamilyInFloorAction(aManager1, towerAction, spaceAction, getCardAction);
		floorAction.notifyConfirm(confirmViewEvent);
		assertTrue(floorAction.isLegal());
	}
	
	
	@Test
	public void performTest(){
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
