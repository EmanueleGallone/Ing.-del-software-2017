package it.polimi.ingsw.ps11.actions.family;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import it.polimi.ingsw.ps11.controller.server.gameServer.PlayerFactory;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.BlackFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.NeutralFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.OrangeFamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.GameLogic;
import it.polimi.ingsw.ps11.model.gameLogics.StateHandler;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInYieldAction;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.zones.yield.Yield;
import it.polimi.ingsw.ps11.view.viewEvents.ConfirmViewEvent;

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
		//MANCA IL NEUTRALE PIU' SERVITORI, SEMPREPOSSIBILE
		ArrayList<Player> players = playersSetting();
		GameLogic gameLogic = new GameLogic(players);
		StateHandler stateHandler1 = gameLogic.getPlayerStatus().get(0);
		StateHandler stateHandler2 = gameLogic.getPlayerStatus().get(1);
		

		Player player1 = stateHandler1.getPlayer();
		Player player2 = stateHandler2.getPlayer();
		Yield harvest = gameLogic.getGame().getBoard().getHarvest();
		//valore del familiare troppo basso
		FamilyMember neutralFamilyMember = new NeutralFamilyMember().getFrom(player1.getFamilyManager());
		FamilyInYieldAction familyInYieldAction = new FamilyInYieldAction(getActionManager(player1, gameLogic), harvest, neutralFamilyMember);
		assertFalse(familyInYieldAction.isLegal());
		//valore opportuno, eseguito
		FamilyMember blackFamilyMember = new BlackFamilyMember().getFrom(player1.getFamilyManager());
		FamilyInYieldAction familyInYieldAction2 = new FamilyInYieldAction(getActionManager(player1, gameLogic), harvest, blackFamilyMember);
		assertTrue(familyInYieldAction2.notifyConfirm(new ConfirmViewEvent(true)));
		familyInYieldAction2.perform();
		//valore opportuno, ma player già presente nella zona

		FamilyMember orangeFamilyMember = new OrangeFamilyMember().getFrom(player1.getFamilyManager());
		FamilyInYieldAction familyInYieldAction3 = new FamilyInYieldAction(getActionManager(player1, gameLogic), harvest, orangeFamilyMember);
		assertFalse(familyInYieldAction3.isLegal());
		//valore opportuno, altro giocatore eseguito
		FamilyMember orangeFamilyMemberPlayer2 = new OrangeFamilyMember().getFrom(player2.getFamilyManager());
		FamilyInYieldAction familyInYieldAction4 = new FamilyInYieldAction(getActionManager(player2, gameLogic), harvest, orangeFamilyMemberPlayer2);
	}
	
	@Test
	public void performTest(){

		ArrayList<Player> players = playersSetting();
		GameLogic gameLogic = new GameLogic(players);
		
		Player player1 = players.get(0);
		Player player2 = players.get(1);
		Yield harvest = gameLogic.getGame().getBoard().getHarvest();
	}
}
