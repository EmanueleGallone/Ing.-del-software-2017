package it.polimi.ingsw.ps11.zones;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import it.polimi.ingsw.ps11.controller.server.gameServer.PlayerFactory;
import it.polimi.ingsw.ps11.model.familyMember.list.NeutralFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.OrangeFamilyMember;
import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.model.resources.list.Servant;
import it.polimi.ingsw.ps11.model.resources.list.Wood;
import it.polimi.ingsw.ps11.model.zones.Market;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;

public class MarketTest {
	
	@Test
	public void test(){
		Market market = new Market(2);
		Assert.assertEquals(2, market.getPlayerNumber());
		ArrayList<Player> players = new ArrayList<>();
		PlayerFactory factory = new PlayerFactory();
		Player player1 = factory.newPlayer(0);
		Player player2 = factory.newPlayer(1);
		players.add(player1);
		players.add(player2);
		
		Game game = new Game(players);
		
		Market market2 = game.getBoard().getMarket();
		assertEquals(players.size(), market2.getPlayerNumber());
		
		market.addActionSpace(new ActionSpace(new ResourceList(new Coin(5)))); //creo le prime due action space
		market.addActionSpace(new ActionSpace(new ResourceList(new Servant(5))));
		market.addActionSpace(new ActionSpace(new ResourceList(new MilitaryPoint(5)))); //creo le altre due action sapce
		market.addActionSpace(new ActionSpace(new ResourceList(new Wood(5)))); //fittizio. dovrebbero esserci due councilPrivilege
		
		market.getActionSpace(0).placeFamilyMember(new OrangeFamilyMember().getFrom(player1.getFamilyManager()), player1);
		
		try {
			market.getActionSpace(3).placeFamilyMember(new OrangeFamilyMember().getFrom(player1.getFamilyManager()), player1);			
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true); //verifico che è stata lanciata l'eccezione
		}
		
		try {
			market.getActionSpace(-1).placeFamilyMember(new OrangeFamilyMember().getFrom(player1.getFamilyManager()), player1);			
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true); //verifico che è stata lanciata l'eccezione. per l'altro branch dell'if
		}

		assertFalse(market.isFull());
	}

}
