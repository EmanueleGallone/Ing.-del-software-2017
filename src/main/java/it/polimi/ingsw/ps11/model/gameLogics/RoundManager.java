package it.polimi.ingsw.ps11.model.gameLogics;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import it.polimi.ingsw.ps11.model.FileRegistry;
import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.loaders.Loader;
import it.polimi.ingsw.ps11.model.player.Player;
/**
 * <h3>RoundManager</h3>
 * <p> Classe che gestisce e organizza i turni di gioco dei giocatori.</p>
 */
public class RoundManager implements Serializable{

	private static final int ROUND_PER_TURN = 4;
	private static final int TURN_PER_PERIOD = 2;
	private static final int MAX_PERIOD = 3;
	
	private long delay = 60000; //Viene caricato da file, Tempo a disposizione di ciascun player per fare la propria mossa
	private transient Timer timer;

	private ArrayList<Player> players = new ArrayList<>();
	private ArrayList<Player> suspended = new ArrayList<>();
	
	private int actions = -1;
	private int actualPlayer = 0; 

	
	private transient EventHandler<RoundManager> gameOver = new EventHandler<>();
	private transient EventHandler<RoundManager> newPeriod = new EventHandler<>();
	private transient EventHandler<RoundManager> newTurn = new EventHandler<>();
	private transient EventHandler<Player> timerOut = new EventHandler<>();
	private transient EventHandler<RoundManager> nobodyOn = new EventHandler<>();

	
	
	@SuppressWarnings("unchecked")
	public RoundManager(ArrayList<Player> players){
		this.players = (ArrayList<Player>) players.clone();
		try {
			delay = new Loader(FileRegistry.timers_turn).load(Integer.class);
		} catch (FileNotFoundException | ClassCastException e) {
			e.printStackTrace();
		}
	}
	
	public Player next(){
		actions++;
		if(roundIsOver() && turnIsOver()){
			newTurn.invoke(this);
			checkPeriod();
		}
		
		Player player = currentPlayer();
		
		if(players.size() == suspended.size()){
			nobodyOn.invoke(this);
			return player;
		}
		if(suspended.contains(player) && !gameIsOver())
			return next();
		return player;
	}
	
	private void checkPeriod(){
		if(periodIsOver()){
			newPeriod.invoke(this);
			if(gameIsOver())
				gameOver.invoke(this);
		}
	}
	
	public boolean isOver(){
		return currentPeriod() > MAX_PERIOD;
	}
	
	
	public ArrayList<Player> getCurrentOrder(){
		return players;
	}
	
	public String currentSituation(){
		String message =  currentRound() + " Round of " + currentTurn();
		message = message + " Turn of " + currentPeriod() + " Period.";
		return message;
	}
	
	public void setNewOrder(ArrayList<Player> newOrder) {
		ArrayList<Player> support = new ArrayList<>();
		for(Player player : newOrder){
			if(player!=null){
				support.add(player);
			}
		}
		players.removeAll(support);
		support.addAll(players);
		this.players = support;
	}
	
	public boolean isSuspended(){
		return players.size() == suspended.size();
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

	
	public void removeFromAfk(Player player){
		suspended.remove(player);
	}
	
	
// Envents attach ______________________________________________________________-
	
	
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
	
	public void nobodyOnEvent(EventListener<RoundManager> listener){
		nobodyOn.attach(listener);
	}
	
	
// Timer handling ______________________________
	
	public void startTimer(){
		stopTimer();
		timer = new Timer();
		TimerTask task = new StartingMatch();
		timer.schedule(task, delay);
		System.err.println("\nTimer started, next turn in : " + delay/1000 + " seconds\n");
	}
	
	class StartingMatch extends TimerTask{

		@Override
		public void run() {
			Player player = players.get(actualPlayer);
			suspended.add(player);
			timerOut.invoke(player);
		}
	}
	
	public void stopTimer(){
		if(timer!= null){
			timer.cancel();
			timer.purge();
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
