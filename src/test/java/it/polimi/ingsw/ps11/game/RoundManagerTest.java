package it.polimi.ingsw.ps11.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.gameLogics.RoundManager;
import it.polimi.ingsw.ps11.model.player.Player;

public class RoundManagerTest {

	boolean gameOver = false;
	int i;
	
	private final int MAX_ROUND = 4;
	
	int turnConter = 0;
	int periodCounter = 0;
	
	@Test
	public void roundSequenceTest(){
		ArrayList<Player> players = new ArrayList<>();
		players.add(new Player());
		players.add(new Player());
		players.add(new Player());
		
		RoundManager rManager = new RoundManager(players);
		
		initializeListener(rManager);
		
		/*
		 * • 4 azioni per ogni turno 
		 * • 2 turni per ogni periodo
		 * • 3 è il numero massimo di periodi
		 * 
		 * 4 x 2 x 3 = 24 azioni in totale per ogni giocatore
		 */
		
		for(i = 0; i <= 24*players.size() ; i++){
			//Ogni next corrisponde ad un'azione eseguita da un player
			rManager.next();
			
			//IL round deve essere sempre minore di Max_Round
			assertTrue(rManager.currentRound() <= MAX_ROUND);
		
			//Controlla che i player si alternino nella sequenza 1,2,3 --> 1,2,3 ecc...
			Player player = rManager.currentPlayer();
			assertTrue(player == players.get(i % players.size()));
		}
		
		
		/*
		 * Nel nostro caso abbiamo 3 giocatori quindi 3 x 24 = 72 azioni
		 * Al termine delle 72 azioni la situazione deve essere questa: 
		 */
		
		// Sono 2 turni per ogni periodo e ci sono 3 periodo quindi 3 x 2 = 6 turni in totale
		assertEquals(turnConter, 6);
		
		// Devono essere passati 3 periodi
		assertEquals(periodCounter, 3);
		
		//L'evento "gameOver" deve essere stato innescato quindi la variabile gameOver deve essere "true"
		assertTrue(gameOver);
	}
	
	private void initializeListener(RoundManager rManager){
		EventListener<RoundManager> gameOverListener = new EventListener<RoundManager>() {

			@Override
			public void handle(RoundManager e) {
				//Quando il game finisce devono essere state fatte 72 azioni
				assertEquals(i, 72);
				gameOver = true;
			}
		};
		
		EventListener<RoundManager> newTurnListener = new EventListener<RoundManager>() {

			@Override
			public void handle(RoundManager e) {
				turnConter++;
			}
		};
		
		EventListener<RoundManager> newPeriodListener = new EventListener<RoundManager>() {

			@Override
			public void handle(RoundManager e) {
				periodCounter++;
			}
		};
		
		rManager.gameOverEvent(gameOverListener);
		rManager.newTurnEvent(newTurnListener);
		rManager.newPeriodEvent(newPeriodListener);
	}
}
