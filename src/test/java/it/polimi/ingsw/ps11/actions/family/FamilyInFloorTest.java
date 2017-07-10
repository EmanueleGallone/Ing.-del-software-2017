package it.polimi.ingsw.ps11.actions.family;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import it.polimi.ingsw.ps11.controller.server.gameServer.PlayerFactory;
import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.cards.list.PurpleCard;
import it.polimi.ingsw.ps11.model.familyMember.list.WhiteFamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.GameLogic;
import it.polimi.ingsw.ps11.model.gameLogics.StateHandler;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.GetCardAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInFloorAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInSpaceAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInTowerAction;
import it.polimi.ingsw.ps11.model.gameLogics.states.WaitConfirm;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.Stone;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.view.viewEvents.ConfirmViewEvent;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEvent;

public class FamilyInFloorTest {	
	
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
		
		Player player = stateHandler.getPlayer();
		player.getResourceList().sum(new ResourceList(new Stone(1)));
		WhiteFamilyMember familyMember = new WhiteFamilyMember().getFrom(player.getFamilyManager());
		
		Tower tower = gameLogic.getGame().getBoard().getTower("PurpleTower");
		ActionSpace actionSpace = tower.getFloor(0).getActionSpace();
		DevelopmentCard card = new PurpleCard("PurpleCard");
		card.addCost(new ResourceList(new Stone(1)));
		ResourceList cost = card.getFirstCost();
		
		FamilyInTowerAction tAction = new FamilyInTowerAction(aManager, tower, familyMember);
		FamilyInSpaceAction sAction = new FamilyInSpaceAction(aManager, familyMember, actionSpace);
		GetCardAction getCard = new GetCardAction(aManager, card, cost);
		
		FamilyInFloorAction familyInFloorAction = new FamilyInFloorAction(aManager, tAction, sAction, getCard);
		
		Assert.assertFalse(familyInFloorAction.isLegal()); //L'azione e' lecita ma ritorna false e manda il giocatore nello stato "WaitConfirm"
		Assert.assertEquals(stateHandler.currentState().getClass(), WaitConfirm.class);
		
		
		//Simulo l'invio di una conferma da parte del client
		ViewEvent confirmEvent = new ConfirmViewEvent(true);
		confirmEvent.setSource(player);
		gameLogic.handle(confirmEvent); 
		//Quando arriva la conferma l'azione familyInFloorAction viene notificata  avviene il check sulla isLegal() e successivamente la perform
		
		//Verifico che il giocatore abbia preso la carta
		Assert.assertTrue(player.getCardManager().getCardList(card.getId()).contains(card));	
		familyInFloorAction.update(new ResourceList(new Coin(1)));
		
	}
	
	
}
