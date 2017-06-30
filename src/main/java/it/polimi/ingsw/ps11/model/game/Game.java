package it.polimi.ingsw.ps11.model.game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.cards.CardManager;
import it.polimi.ingsw.ps11.model.json.JsonAdapter;
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
			refreshCard(roundManager.getPeriod());
			board.getMarket().setPlayerNumber(players.size());
			board.getDices().rollDices();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Board initializeBoard() throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader("settings\\board"));
		String line,strBoard = "";
		
		while ((line = reader.readLine())!=null){
			strBoard += line;
		}

		JsonAdapter jsonAdapter = new JsonAdapter();
		return jsonAdapter.fromJson(strBoard, Board.class);
	}
	
	
	private CardManager loadCards(int period) throws FileNotFoundException{
		FileReader reader = new FileReader("settings\\cards\\"+period);
		CardManager cardManager = new JsonAdapter().fromJson(reader, CardManager.class);
		return cardManager;
	}

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
