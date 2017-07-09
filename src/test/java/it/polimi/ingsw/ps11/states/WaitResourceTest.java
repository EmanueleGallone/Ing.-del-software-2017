package it.polimi.ingsw.ps11.states;

import org.junit.Test;

import it.polimi.ingsw.ps11.controller.server.gameServer.PlayerFactory;
import it.polimi.ingsw.ps11.model.player.Player;

public class WaitResourceTest {

	@Test
	public void test(){
		
		PlayerFactory playerFactory = new PlayerFactory();
		Player player1 = playerFactory.newPlayer(0);
		Player player2 = playerFactory.newPlayer(1);
		Player player3 = playerFactory.newPlayer(2);
		Player player4 = playerFactory.newPlayer(3);
		
		//GameLogic gameLogic = new GameLogic(players);
		
	}
	
	
	
}
