package it.polimi.ingsw.ps11.gab;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.ps11.cranio.cards.list.BlueCard;
import it.polimi.ingsw.ps11.cranio.player.Colors;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.resources.Resource;
import it.polimi.ingsw.ps11.cranio.resources.list.Coin;
import it.polimi.ingsw.ps11.cranio.resources.list.Stone;

public class PlayerTest{
	
	public ArrayList<Resource> rlist;
	public Player player1;
	public Player player2;
	BlueCard card;

	@Before
	public void setting(){
		rlist = new ArrayList<>();
		rlist.add(new Coin(5));
		rlist.add(new Stone(3));
		player1 = new Player(rlist);
		player2 = new Player();
		card = new BlueCard();

	}
	
	@Test
	public void Test(){
		
		
		player1.setColor(Colors.GREEN);
		player2.setColor(Colors.GREEN);
		
		assertTrue(player1.equals(player2));
		assertTrue(player1.getCardManager().addCard(card));
		System.out.println(player1.getCardManager().toString());
	}
	
}
