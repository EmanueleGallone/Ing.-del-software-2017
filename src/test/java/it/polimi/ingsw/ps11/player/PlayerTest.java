package it.polimi.ingsw.ps11.player;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.ps11.model.game.Colors;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.Resource;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.Wood;

public class PlayerTest {

	Player player1, player2, playerNegative;
	ArrayList<Resource> player1Resources, player2Resources, playerNegativeResources;
	Coin coin1, coin3, coinNegative;
	Wood wood1, wood3, woodNegative;
	
	@Before
	public void setting(){
		
		coin1 = new Coin(1); coin3 = new Coin(3); coinNegative = new Coin(-1);
		wood1 = new Wood(1); wood3 = new Wood(3); woodNegative = new Wood(-1);
		
		player1Resources = new ArrayList<>();
		player1Resources.add(coin3);
		player1Resources.add(wood3);
		
		player2Resources = new ArrayList<>();
		player2Resources.add(coin1);
		player2Resources.add(wood1);
		
		playerNegativeResources = new ArrayList<>();
		playerNegativeResources.add(coinNegative);
		playerNegativeResources.add(woodNegative);
		
		player1 = new Player(player1Resources);
		player1.setName("player1Test");
		player1.setColor(Colors.BLUE);
		
		player2 = new Player(player2Resources);
		player2.setName("player1Test");
		player2.setColor(Colors.RED);
		
		playerNegative = new Player(playerNegativeResources);
		playerNegative.setName("playerNegativeTest");
		playerNegative.setColor(Colors.GREEN);
		
	}
	
	@Test
	public void equalsTest(){
		
		assertFalse(player1.equals(playerNegative));
		assertTrue(player1.equals(player2));
		
	}
}
