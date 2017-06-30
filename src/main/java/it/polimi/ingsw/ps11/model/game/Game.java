package it.polimi.ingsw.ps11.model.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.cards.CardManager;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.json.JsonAdapter;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.zones.Board;
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
			//refreshCard(roundManager.getPeriod());
			board.getMarket().setPlayerNumber(players.size());
			
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
		
//		ArrayList<Class<?>> list = new ArrayList<>();
//		list.add(DevelopmentCard.class);
//		list.add(Resource.class);
//		list.add(Tower.class);
//		JsonAdapter jsonAdapter = new JsonAdapter(list);

		JsonAdapter jsonAdapter = new JsonAdapter();
		return jsonAdapter.fromJson(strBoard, Board.class);
	}
	
	
	private CardManager loadCards(int period){
		CardManager cardManager = null;
		
		return cardManager;
	}

	public void refreshCard(int period){
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
