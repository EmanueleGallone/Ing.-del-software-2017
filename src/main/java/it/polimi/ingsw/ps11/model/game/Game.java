package it.polimi.ingsw.ps11.model.game;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.FileRegistry;
import it.polimi.ingsw.ps11.model.cards.CardManager;
import it.polimi.ingsw.ps11.model.gameLogics.RoundManager;
import it.polimi.ingsw.ps11.model.loaders.Loader;
import it.polimi.ingsw.ps11.model.player.Player;
/** <h3> Game </h3>
 * <p> Classe che racchiude l'intera partita: la board, il roundManager e i giocatori</p>
 * @version 1.0
 * @see Board
 * @see RoundManager
 */
public class Game implements Serializable  {
	
	private Board board;
	private RoundManager roundManager;
	
	public Game(ArrayList<Player> players) {
		try {
			roundManager = new RoundManager(players);
			board = initializeBoard();
			board.getMarket().setPlayerNumber(players.size());
			setDices(players);
			board.setCard(loadCards(roundManager.currentPeriod()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	private void setDices(ArrayList<Player> players){
		board.getDices().rollDices();
		for(Player player: players){
			player.getFamilyManager().setDices(board.getDices());
		}
	}
	

	/**<h3> Board initializeBoard() </h3>
	 * <p> Crea una board caricandola da file</p>
	 * @return una nuova board
	 */
	private Board initializeBoard() throws IOException{
		return new Loader(FileRegistry.board).load(Board.class);
	}
	
	/**<h3> CardManager loadCards(int period) </h3>
	 * <p> Carica le carte sulle torri in base al periodo</p>
	 */
	private CardManager loadCards(int period) throws FileNotFoundException{
		return new Loader(FileRegistry.cards + period).load(CardManager.class);
	}

	/**<h3> void refreshCard(int Period) </h3>
	 * <p>Posiziona le carte sulle torri in maniera casuale in base al periodo</p>
	 */
	public void refreshCard(int period) throws FileNotFoundException{
		CardManager currentCard = loadCards(period);
		//impostaOrdineCasuale();
		board.setCard(currentCard);
	}
	
	public Board getBoard() {
		return board;
	}

	public RoundManager getRoundManager() {
		return roundManager;
	}

}
