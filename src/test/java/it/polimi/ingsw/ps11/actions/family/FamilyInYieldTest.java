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


	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	private ArrayList<Player> playersSetting() {
		PlayerFactory playerFactory = new PlayerFactory();
		ArrayList<Player> players = playerFactory.takeAll();
		int i = 1;
		for (Player player : players) {
			player.setName("Giocatore " + i);
			i++;
		}
		return players;
	}

	private ActionManager getActionManager(Player player, GameLogic gameLogic){
		for (StateHandler s : gameLogic.getPlayerStatus()) {
			if(s.getPlayer().equals(player)) 
				return s.actions();
			
		}
		return null;
	}
	
	@Test
	public void isLegalTest(){
		//MANCA IL NEUTRALE PIù SERVITORI, SEMPREPOSSIBILE
		ArrayList<Player> players = playersSetting();
		GameLogic gameLogic = new GameLogic(players);
		
		Player player1 = players.get(0);
		Player player2 = players.get(1);
		Yield harvest = gameLogic.getGame().getBoard().getHarvest();
		//valore del familiare troppo basso
		FamilyInYieldAction familyInYieldAction = new FamilyInYieldAction(getActionManager(player1, gameLogic), harvest, player1.getFamilyManager().getFamilyMember(NeutralFamilyMember.class));
		assertFalse(familyInYieldAction.isLegal());
		//valore opportuno, eseguito
		FamilyInYieldAction familyInYieldAction2 = new FamilyInYieldAction(getActionManager(player1, gameLogic), harvest, player1.getFamilyManager().getFamilyMember(BlackFamilyMember.class));
		assertTrue(familyInYieldAction2.isLegal());
		familyInYieldAction2.perform();
		//valore opportuno, ma player già presente nella zona
		FamilyInYieldAction familyInYieldAction3 = new FamilyInYieldAction(getActionManager(player1, gameLogic), harvest, player1.getFamilyManager().getFamilyMember(OrangeFamilyMember.class));
		assertFalse(familyInYieldAction3.isLegal());
		//valore opportuno, altro giocatore eseguito
		FamilyInYieldAction familyInYieldAction4 = new FamilyInYieldAction(getActionManager(player2, gameLogic), harvest, player2.getFamilyManager().getFamilyMember(OrangeFamilyMember.class));
		assertTrue(familyInYieldAction4.isLegal());

	}
	
	@Test
	public void performTest(){
		
		ArrayList<Player> players = playersSetting();
		GameLogic gameLogic = new GameLogic(players);
		
		Player player1 = players.get(0);
		Player player2 = players.get(1);
		Yield harvest = gameLogic.getGame().getBoard().getHarvest();
		
	}
	
	
	@Test
	public void Test(){
		
	}
}
