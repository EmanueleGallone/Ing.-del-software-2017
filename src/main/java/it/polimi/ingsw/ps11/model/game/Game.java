package it.polimi.ingsw.ps11.model.game;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import it.polimi.ingsw.ps11.model.FileRegistry;
import it.polimi.ingsw.ps11.model.cards.CardManager;
import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.gameLogics.RoundManager;
import it.polimi.ingsw.ps11.model.loaders.Loader;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.zones.Church;
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
			refreshCard(roundManager.currentPeriod());
			board.setChurch(loadChurch());
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
		for(ArrayList<DevelopmentCard> deck: currentCard){
			Collections.shuffle(deck);
		}
		board.setCard(currentCard);
	}
	
	
	public Church loadChurch() throws FileNotFoundException, ClassCastException{
		Church church = new Loader(FileRegistry.church).load(Church.class);
		//church.setExcomunications(/* caricare da file 3 scomuniche, 1 per periodo*/);
		return church;
	}
	
	
	public Board getBoard() {
		return board;
	}

	public RoundManager getRoundManager() {
		return roundManager;
	}

}
