package it.polimi.ingsw.ps11.actions.family;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import it.polimi.ingsw.ps11.controller.server.gameServer.PlayerFactory;
import it.polimi.ingsw.ps11.model.cards.list.YellowCard;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.BlackFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.NeutralFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.OrangeFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.WhiteFamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.GameLogic;
import it.polimi.ingsw.ps11.model.gameLogics.StateHandler;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInFloorAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInSpaceAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInTowerAction;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;

public class FamilyInTowerTest {
	
	private ArrayList<Player> initializePlayers(){
		PlayerFactory factory = new PlayerFactory();
		ArrayList<Player> players = new ArrayList<>();
		for(int i = 0; i < 4; i++)
			players.add(factory.newPlayer(i));
		
		return players;
	}

	@Test
	public void test(){
		ArrayList<Player> players = initializePlayers();
		
		GameLogic gameLogic = new GameLogic(players);
		StateHandler stateHandler = gameLogic.getPlayerStatus().get(0);
		ActionManager aManager = stateHandler.actions();
		
		OrangeFamilyMember orangeFamilyMember = new OrangeFamilyMember().getFrom(players.get(0).getFamilyManager());
		Player player = stateHandler.getPlayer();
		
		Tower tower = gameLogic.getGame().getBoard().getTower("YellowTower");
		
		FamilyInTowerAction familyInTowerAction = new FamilyInTowerAction(aManager, tower, orangeFamilyMember);
		Assert.assertTrue(familyInTowerAction.isLegal()); //l'azione deve essere legale. la torre e' completamente vuota
		Assert.assertTrue(familyInTowerAction.checkTax()); //la torre e' vuota e la tassa non deve essere pagata
		
		tower.getFloor(0).placeFamilyMember(orangeFamilyMember, player); //piazzo il familiare nella torre
		Assert.assertTrue(familyInTowerAction.checkTax());

		familyInTowerAction.perform();
		Assert.assertFalse(familyInTowerAction.isLegal()); // altro branch. l'azione e' stata gia' fatta quindi non e' piu' legale
		
	}
}
