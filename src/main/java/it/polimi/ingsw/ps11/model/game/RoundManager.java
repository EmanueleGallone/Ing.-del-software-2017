package it.polimi.ingsw.ps11.model.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.player.Player;
/**
 * <h3>RoundManager</h3>
 * <p> Classe che gestisce e organizza i turni di gioco dei giocatori.</p>
 */
public class RoundManager implements Serializable{

	private static final int ROUND_PER_TURN = 4;
	private static final int TURN_PER_PERIOD = 2;
	private static final int MAX_PERIOD = 3;
	
	private long delay = 60000; //va caricato da file, Tempo a disposizione di ciascun player per fare la propria mossa
	private transient Timer timer;

	private ArrayList<Player> players = new ArrayList<>();
	private ArrayList<Player> suspended = new ArrayList<>();
	
	private int actions = -1;
	private int actualPlayer = 0; 

	
	private EventHandler<RoundManager> gameOver = new EventHandler<>();
	private EventHandler<RoundManager> newPeriod = new EventHandler<>();
	private EventHandler<RoundManager> newTurn = new EventHandler<>();
	private EventHandler<Player> timerOut = new EventHandler<>();
	
	public RoundManager(ArrayList<Player> players){
		this.players = players;
	}
	
	public Player next(){
		actions++;
		if(roundIsOver() && turnIsOver()){
			newTurn.invoke(this);
			checkPeriod();
		}
		
		Player player = currentPlayer();
		if(suspended.contains(player)){
			return next();
		}
		return currentPlayer();
	}
	
	private void checkPeriod(){
		if(periodIsOver()){
			newPeriod.invoke(this);
			if(gameIsOver())
				gameOver.invoke(this);
		}
	}
	
	
	public ArrayList<Player> getCurrentOrder(){
		return players;
	}
// ____________________________________________
	
	/**
	 * Ritorna l'indice del giocatore corrente
	 */
	private int actualIndex(){
		return actions % players.size();
	}
	
	/**
	 * Ritorna il numero totale di round/giri trascorsi
	 */
	private int round(){
		return actions / players.size();
	}
	
	/**
	 * Ritorna il numero totale di turni trascorsi
	 */
	private int turn(){
		return round() / ROUND_PER_TURN;
	}
	
	public Player currentPlayer(){
		int i = actualIndex();
		if(i >= 0 && i < players.size() )
			return players.get(i);
		return null;
	}

	public int getActionsNumber() {
		return actions;
	}
	
	
	/**
	 * Il turno finisce quando tutti i giocatori hanno fatto 1 mossa ciascuno
	 */
	private boolean roundIsOver(){
		return actualIndex() % players.size() == 0 && actions > 0;
	}
	
	private boolean turnIsOver(){
		return round() % ROUND_PER_TURN == 0 && actions > 0;
	}
	
	private boolean periodIsOver(){
		return turn() % TURN_PER_PERIOD == 0 && actions > 0;
	}
	
	/**
	 * Il gioco finisce quando finisce l'ultimo round dell'ultimo turno dell'ultimo periodo
	 */
	private boolean gameIsOver(){
		return currentPeriod() > MAX_PERIOD;
	}
	
	
	/**
	 * Ritorna l'indice del round corrente all'interno del turno corrente
	 * Di conseguenza è un numero compreso tra 1 e Max_round_per_turn (ovvero 4)
	 */
	public int currentRound() {
		return (round() % ROUND_PER_TURN) +1;
	}
	
	/**
	 * Ritorna l'indice del turno corrente all'interno del periodo corrente
	 * Di conseguenza è un numero compreso tra 1 e Max_turn_per_period (ovvero 2)
	 */
	public int currentTurn() {
		return (turn() % TURN_PER_PERIOD)+1;
	}
	
	public int currentPeriod() {
		return (turn() / TURN_PER_PERIOD)+1;
	}

	public void newPeriodEvent(EventListener<RoundManager> listener){
		newPeriod.attach(listener);
	}
	
	public void newTurnEvent(EventListener<RoundManager> listener){
		newTurn.attach(listener);
	}
	
	public void gameOverEvent(EventListener<RoundManager> listener){
		gameOver.attach(listener);
	}
	
	public void timeOutEvent(EventListener<Player> listener){
		timerOut.attach(listener);
	}
	
// Timer handling ______________________________
	
	public void startTimer(){
		timer = new Timer();
		TimerTask task = new StartingMatch();
		timer.schedule(task, delay);
	}
	
	class StartingMatch extends TimerTask{

		@Override
		public void run() {
			Player player = players.get(actualPlayer);
			suspended.add(player);
			timerOut.invoke(player);
		}
	}
	
	
//	private void tempTest(){
//		if(roundIsOver()){
//			System.out.println("Round finito");
//			if(turnIsOver()){
//				System.out.println("Turno finito");
//				if(periodIsOver()){
//					System.out.println("Periodo finito");
//					if(gameIsOver())
//						System.out.println("Gioco finito");
//				}
//			}
//		}
//	}
}
