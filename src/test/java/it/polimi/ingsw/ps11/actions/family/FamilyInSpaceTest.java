package it.polimi.ingsw.ps11.actions.family;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import it.polimi.ingsw.ps11.controller.server.gameServer.PlayerFactory;
import it.polimi.ingsw.ps11.model.familyMember.list.BlackFamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.GameLogic;
import it.polimi.ingsw.ps11.model.gameLogics.StateHandler;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInSpaceAction;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;

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
		Assert.assertTrue(familyInSpaceAction.isLegal()); //non e' possibile in quanto il valueCost dell'actionSpace e' maggiore del valore del familiare
		
	}

}
