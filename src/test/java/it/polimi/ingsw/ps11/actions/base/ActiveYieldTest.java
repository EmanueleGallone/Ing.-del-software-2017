package it.polimi.ingsw.ps11.actions.base;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import it.polimi.ingsw.ps11.controller.server.gameServer.PlayerFactory;
import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.cards.effects.AddResourceEffect;
import it.polimi.ingsw.ps11.model.cards.effects.Effect;
import it.polimi.ingsw.ps11.model.cards.list.GreenCard;
import it.polimi.ingsw.ps11.model.familyMember.list.OrangeFamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.GameLogic;
import it.polimi.ingsw.ps11.model.gameLogics.StateHandler;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.ActiveYieldAction;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;

public class ActiveYieldTest {

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
		
		OrangeFamilyMember familyMember = new OrangeFamilyMember().getFrom(aManager.state().getPlayer().getFamilyManager());
		
		ActiveYieldAction action = new ActiveYieldAction(aManager, new GreenCard().getId(), familyMember.getValue());
		assertTrue(action.isLegal());
		action.perform();
		
		DevelopmentCard card1 = new GreenCard(new GreenCard().getId());
		DevelopmentCard card2 = new GreenCard(new GreenCard().getId());

		players.get(0).getCardManager().addCard(card1);
		players.get(0).getCardManager().addCard(card2);
		action.perform();
		
		AddResourceEffect effect1 = new AddResourceEffect(new ResourceList(new Coin(1)));
		ArrayList<Effect> effects = new ArrayList<>();
		effects.add(effect1);
		action.active(effects);
		
	}

}
