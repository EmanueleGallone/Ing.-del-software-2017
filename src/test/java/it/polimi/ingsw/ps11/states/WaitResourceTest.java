package it.polimi.ingsw.ps11.states;

import org.junit.Test;

import it.polimi.ingsw.ps11.controller.server.gameServer.PlayerFactory;
import it.polimi.ingsw.ps11.model.gameLogics.GameLogic;

public class WaitResourceTest {

	@Test
	public void test(){
		
		PlayerFactory playerFactory = new PlayerFactory();
		GameLogic gameLogic = new GameLogic(playerFactory.takeAll());
		
		
		
	}
	
	
	
}
