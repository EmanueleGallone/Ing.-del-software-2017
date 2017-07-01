package it.polimi.ingsw.ps11.testEma;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import it.polimi.ingsw.ps11.model.game.RoundManager;
import it.polimi.ingsw.ps11.model.player.Player;

public class RoundManagerTest {
///*
//	@Test
//	public void testRoundManager2Players(){
////		Player player1 = new Player();
////		Player player2 = new Player();
////		
////		ArrayList<Player> players = new ArrayList<Player>(Arrays.asList(player1,player2));
////		
////		RoundManager roundManager = new RoundManager(players);
////		
////		Assert.assertTrue( roundManager.getRound() == 1);
////		Assert.assertEquals(player1, roundManager.currentPlayer());
////		
////		for(int i = 0; i < 80; i++){
////			System.out.print("round= " + roundManager.getRound() + " turno: " + roundManager.getTurn());
////			System.out.println(" periodo = " + roundManager.getPeriod());
////			roundManager.next();
////		}
//		
//		/*
//		
//		roundManager.next(); //primo giocatore fa la mossa, round 1; tocca al secondo
//		
//		Assert.assertEquals(player2, roundManager.getCurrentPlayer());
//		Assert.assertFalse(roundManager.turnIsOver());
//		Assert.assertFalse(roundManager.roundIsOver()); //il giocatore 2 deve ancora fare la mossa. quindi in realtà non è finito il round
//		Assert.assertTrue(roundManager.getRound() == 1);
//		
//		roundManager.next(); //il secondo giocatore fa la mossa; dovrebbe terminare il round 1 e iniziare il round 2
//		
//		Assert.assertEquals(player1, roundManager.getCurrentPlayer());
//		Assert.assertTrue(roundManager.getTurn() == 1);
//		Assert.assertTrue(roundManager.getRound() == 2);
//		
//		roundManager.next();// il primo giocatore fa la mossa; tocca al secondo, ancora round 2
//		
//		Assert.assertEquals(player2, roundManager.getCurrentPlayer());
//		Assert.assertTrue(roundManager.getTurn() == 1);
//		Assert.assertTrue(roundManager.getRound() == 2);
//		
//		roundManager.next(); //il secondo giocatore fa la mossa, tocca al primo, 3 round
//		
//		Assert.assertEquals(player1, roundManager.getCurrentPlayer());
//		Assert.assertTrue(roundManager.getTurn() == 1);
//		Assert.assertTrue(roundManager.getRound() == 3);
//		
//		roundManager.next(); //il primo giocatore fa la mossa, tocca al secondo, 3 round
//		
//		Assert.assertEquals(player1, roundManager.getCurrentPlayer());
//		Assert.assertTrue(roundManager.getTurn() == 1);
//		Assert.assertTrue(roundManager.getRound() == 3);
//		
//		roundManager.next(); //il secondo fa la mossa, quarto round
//		
//		Assert.assertTrue(roundManager.getTurn() == 1);
//		Assert.assertTrue(roundManager.getRound() == 4);
//		
//		roundManager.next(); //primo giocatore, 4 round
//		
//		Assert.assertTrue(roundManager.getTurn() == 1);
//		Assert.assertTrue(roundManager.getRound() == 4);
//		
//		roundManager.next(); //secondo giocatore, 4 round, finiti i round, termina il turno
//		//INIZIO TURNO 2
//		Assert.assertTrue(roundManager.getTurn() == 2);
//		Assert.assertTrue(roundManager.getRound() == 1);
//		Assert.assertTrue(roundManager.getPeriod() == 1);
//		
//		roundManager.next(); //primo giocatore fa la mossa, round 1; tocca al secondo
//		
//		Assert.assertEquals(player2, roundManager.getCurrentPlayer());
//		Assert.assertFalse(roundManager.turnIsOver());
//		Assert.assertFalse(roundManager.roundIsOver()); //il giocatore 2 deve ancora fare la mossa. quindi in realtà non è finito il round
//		Assert.assertTrue(roundManager.getRound() == 1);
//		
//		roundManager.next(); //il secondo giocatore fa la mossa; dovrebbe terminare il round 1 e iniziare il round 2
//		
//		Assert.assertEquals(player1, roundManager.getCurrentPlayer());
//		Assert.assertTrue(roundManager.getTurn() == 2);
//		Assert.assertTrue(roundManager.getRound() == 2);
//		
//		roundManager.next();// il primo giocatore fa la mossa; tocca al secondo, ancora round 2
//		
//		Assert.assertEquals(player2, roundManager.getCurrentPlayer());
//		Assert.assertTrue(roundManager.getTurn() == 2);
//		Assert.assertTrue(roundManager.getRound() == 2);
//		
//		roundManager.next(); //il secondo giocatore fa la mossa, tocca al primo, 3 round
//		
//		Assert.assertEquals(player1, roundManager.getCurrentPlayer());
//		Assert.assertTrue(roundManager.getTurn() == 2);
//		Assert.assertTrue(roundManager.getRound() == 3);
//		
//		roundManager.next(); //il primo giocatore fa la mossa, tocca al secondo, 3 round
//		
//		Assert.assertEquals(player1, roundManager.getCurrentPlayer());
//		Assert.assertTrue(roundManager.getTurn() == 2);
//		Assert.assertTrue(roundManager.getRound() == 3);
//		
//		roundManager.next(); //il secondo fa la mossa, quarto round
//		
//		Assert.assertTrue(roundManager.getTurn() == 2);
//		Assert.assertTrue(roundManager.getRound() == 4);
//		
//		roundManager.next(); //primo giocatore, 4 round
//		
//		Assert.assertTrue(roundManager.getTurn() == 2);
//		Assert.assertTrue(roundManager.getRound() == 4);
//		
//		roundManager.next(); //secondo giocatore, 4 round, finiti i round, termina il turno
//		Assert.assertTrue(roundManager.getTurn() == 1);
//		Assert.assertTrue(roundManager.getRound() == 1);
//		Assert.assertTrue(roundManager.getPeriod() == 2);
//		
//		//fine secondo turno
//		*/
//		
//	}
//
//	@Test
//	public void testRoundManager3Players(){
//		Player player1 = new Player();
//		Player player2 = new Player();
//		Player player3 = new Player();
//		
//		ArrayList<Player> players = new ArrayList<Player>(Arrays.asList(player1,player2,player3));
//		
//		RoundManager roundManager = new RoundManager(players);
//		
//		Assert.assertTrue( roundManager.getRound() == 1);
//		Assert.assertEquals(player1, roundManager.currentPlayer());
//		
//		roundManager.next(); // giocatore 1 fa la mossa, tocca al secondo
//		
//		Assert.assertTrue(roundManager.getRound() == 1);
//		Assert.assertTrue(roundManager.getTurn() == 1);
//		
//
//		roundManager.next(); //giocatore 1 fa la mossa, tocca al 3
//		
//		Assert.assertTrue(roundManager.getRound() == 1);
//		Assert.assertTrue(roundManager.getTurn() == 1);
//		Assert.assertEquals(player3, roundManager.currentPlayer());
//
//
//		roundManager.next(); //giocatore 3 fa la mossa, termina il round
//
//		
//		Assert.assertTrue(roundManager.getRound() == 2);
//		Assert.assertTrue(roundManager.getTurn() == 1);
//		Assert.assertTrue(roundManager.getPeriod() == 1);
//	}

}
