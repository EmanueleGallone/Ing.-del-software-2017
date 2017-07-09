package it.polimi.ingsw.ps11.game;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import it.polimi.ingsw.ps11.controller.server.gameServer.PlayerFactory;
import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.resources.list.Coin;

public class GameTest {

	@Test
	public void test() {
		Game game = new Game(new PlayerFactory().takeAll());
		
		Assert.assertEquals(4, game.getRoundManager().getCurrentOrder().size());
		Assert.assertEquals(5 , game.getRoundManager().getCurrentOrder().get(0).getResourceList().get(new Coin().getId()).getValue());
		Assert.assertEquals(6 , game.getRoundManager().getCurrentOrder().get(1).getResourceList().get(new Coin().getId()).getValue());
		Assert.assertEquals(7 , game.getRoundManager().getCurrentOrder().get(2).getResourceList().get(new Coin().getId()).getValue());
		Assert.assertEquals(8 , game.getRoundManager().getCurrentOrder().get(3).getResourceList().get(new Coin().getId()).getValue());
	}

}
