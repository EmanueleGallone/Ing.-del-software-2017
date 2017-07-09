package it.polimi.ingsw.ps11.actions.family;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import it.polimi.ingsw.ps11.controller.server.gameServer.PlayerFactory;
import it.polimi.ingsw.ps11.model.dices.Dice;
import it.polimi.ingsw.ps11.model.dices.DiceProxy;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.BlackFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.NeutralFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.OrangeFamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.GameLogic;
import it.polimi.ingsw.ps11.model.gameLogics.State;
import it.polimi.ingsw.ps11.model.gameLogics.StateHandler;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInSpaceAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInTowerAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.resources.DecrementAction;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.Servant;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.view.viewEvents.ConfirmViewEvent;

public class FamilyInSpaceTest {
	
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
		StateHandler stateHandler = new StateHandler(gameLogic, players.get(0));
		ActionManager aManager = new ActionManager(stateHandler);
		
		Player player = players.get(0); //prendo il primo giocatore
		BlackFamilyMember blackFamilyMember = new BlackFamilyMember().getFrom(player.getFamilyManager()); // il familiare ha valore 0

		ActionSpace actionSpace = gameLogic.getGame().getBoard().getTower("GreenTower").getFloors().get(1).getActionSpace(); //prendo il secondo piano della greenTower
		
		FamilyInSpaceAction familyInSpaceAction = new FamilyInSpaceAction(aManager, blackFamilyMember, actionSpace);
		Assert.assertFalse(familyInSpaceAction.isLegal()); //non e' possibile in quanto il valueCost dell'actionSpace e' maggiore del valore del familiare
		
	}

}
