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
		StateHandler stateHandler = gameLogic.getPlayerStatus().get(0);
		ActionManager aManager = stateHandler.actions();
		
		Player player = stateHandler.getPlayer(); //prendo il primo giocatore
		BlackFamilyMember blackFamilyMember = new BlackFamilyMember().getFrom(player.getFamilyManager()); // il familiare ha valore 0

		ActionSpace actionSpace = gameLogic.getGame().getBoard().getTower("GreenTower").getFloors().get(1).getActionSpace(); //prendo il secondo piano della greenTower
		
		FamilyInSpaceAction familyInSpaceAction = new FamilyInSpaceAction(aManager, blackFamilyMember, actionSpace);
		if (blackFamilyMember.getValue() >= 3){ //necessario in quanto il valore e' random
			Assert.assertTrue(familyInSpaceAction.checkActionCost());
			Assert.assertTrue(familyInSpaceAction.notifyConfirm(new ConfirmViewEvent(true))); //possibile, in quanto il familiare ha valore maggiore o uguale allo spazio azione
		}
		else {
			Assert.assertFalse(familyInSpaceAction.isLegal());
			Assert.assertFalse(familyInSpaceAction.checkActionCost());
		}

		familyInSpaceAction.perform();
		Assert.assertFalse(familyInSpaceAction.notifyConfirm(new ConfirmViewEvent(true))); //e' stata fatta la perform. non puo' piu' essere fatta l'azione
		familyInSpaceAction.setAlreadyDone(true);
		familyInSpaceAction.perform(); // per l'altro branch nell'if
		Assert.assertFalse(familyInSpaceAction.isLegal());
		
		actionSpace = new ActionSpace(8);
		familyInSpaceAction = new FamilyInSpaceAction(aManager, blackFamilyMember, actionSpace);
		Assert.assertFalse(familyInSpaceAction.checkActionCost());
	}

}
