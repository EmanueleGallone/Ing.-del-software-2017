package it.polimi.ingsw.ps11.game;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import it.polimi.ingsw.ps11.controller.server.gameServer.PlayerFactory;
import it.polimi.ingsw.ps11.model.game.Game;

public class GameTest {

	@Test
	public void test() {
		Game game = new Game(new PlayerFactory().takeAll());
		
		Assert.assertEquals(4, game.getRoundManager().getCurrentOrder().size());
		
	}

}
