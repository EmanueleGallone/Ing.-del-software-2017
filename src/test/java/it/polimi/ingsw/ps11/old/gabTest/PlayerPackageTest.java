package it.polimi.ingsw.ps11.old.gabTest;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.ps11.model.game.Colors;
import it.polimi.ingsw.ps11.model.player.Player;

public class PlayerPackageTest {

	/* 1) LA CLONE DEVE COPIARE ANCHE IL COLORE DEL GIOCATORE
	 */
	
	public Player player1;
	public Player player2;
	
	@Before
	public void setting(){
		
		player1 = new Player();
		player2 = new Player();
	}
	
	@Test
	public void SetAndGetTest(){
		
		String name = "Player";
		Colors color = Colors.GREEN;
		player1.setName(name);
		player1.setColor(color);
		assertEquals(name, player1.getName());
		assertEquals(color, player1.getColor());
		
	}
	
	@Test
	public void EqualsTest(){
		
		player1.setColor(Colors.GREEN);
		player2.setColor(Colors.GREEN);
		assertTrue(player1.equals(player2));
		
		player2 = player1.clone();
		//assertTrue(player1.equals(player2));
		
	}
}  
