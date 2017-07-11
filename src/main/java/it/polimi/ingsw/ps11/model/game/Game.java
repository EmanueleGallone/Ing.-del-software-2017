package it.polimi.ingsw.ps11.model.game;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;

import com.google.gson.reflect.TypeToken;

import it.polimi.ingsw.ps11.model.FileRegistry;
import it.polimi.ingsw.ps11.model.cards.CardManager;
import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.cards.leaderCards.LeaderCard;
import it.polimi.ingsw.ps11.model.excommunications.Excommunication;
import it.polimi.ingsw.ps11.model.gameLogics.RoundManager;
import it.polimi.ingsw.ps11.model.loaders.Loader;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.zones.Church;
/** <h3> Game </h3>
 * <p> Classe generale che racchiude l'intera partita: la board di gioco contenente tutte le zone di gioco, una per partita, il roundManager
 * che gestisce la meccanica dei turni del gioco, uno per partita,e i giocatori che partecipano alla partita, da due a quattro per partita,
 * Gestisce l'intera interazione tra i vari componenti</p>
 * @version 1.0
 * @see Board
 * @see RoundManager
 */
public class Game implements Serializable  {
	
	private final int LEADER_CARD = 4;
	
	private Board board;
	private RoundManager roundManager;
	
	public Game(ArrayList<Player> players) {
		try {
			roundManager = new RoundManager(players);
			board = initializeBoard(players);
			setDices(players);

			assignLeaderCard(players);
			
			refreshCard(roundManager.currentPeriod());
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
	private Board initializeBoard(ArrayList<Player> players) throws IOException{
		Board board = new Loader(FileRegistry.board).load(Board.class);
		board.getMarket().setPlayerNumber(players.size());
		Church church = new Loader(FileRegistry.church).load(Church.class);
		setExcomunications(church);
		board.setChurch(church);
		return board;
	}
	
	private void setExcomunications(Church church) throws FileNotFoundException, ClassCastException{
		Type type = new TypeToken<ArrayList<Excommunication>>(){}.getType();
		ArrayList<Excommunication> exc = new Loader(FileRegistry.excommunication).load(type);
		Collections.shuffle(exc);
		
		for(Excommunication e : exc){
			church.addExcomunication(e);
		}
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

	
	private void assignLeaderCard(ArrayList<Player> players) throws FileNotFoundException, ClassCastException{
		CardManager cManager = new Loader(FileRegistry.leaderCards).load(CardManager.class);
		Collections.shuffle(cManager.getLeaderCards());
		for(Player player: players){
			assignLeaderCard(player,cManager.getLeaderCards());
		}
	}
	
	private void assignLeaderCard(Player player, ArrayList<LeaderCard> cards){
		ArrayList<LeaderCard> leaderCards = new ArrayList<>();
		for(int i = 0; i < LEADER_CARD && i<cards.size(); i++){
			leaderCards.add(cards.get(i));
		}
		cards.removeAll(leaderCards);
		player.getCardManager().setLeaderCards(leaderCards);
	}
	
	
	public Board getBoard() {
		return board;
	}

	public RoundManager getRoundManager() {
		return roundManager;
	}

}
