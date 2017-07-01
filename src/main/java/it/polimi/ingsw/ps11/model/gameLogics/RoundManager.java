package it.polimi.ingsw.ps11.model.gameLogics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.player.Player;
/**
 * <h3>RoundManager</h3>
 * <p> Classe che gestisce e organizza i turni dei giocatori.</p>
 */
public class RoundManager implements Serializable{

	private static final int MAX_ROUND_PER_TURN = 4;
	private static final int MAX_PERIOD = 3;
	
	private long delay = 60000; //va caricato da file, Tempo a disposizione di ciascun player per fare la propria mossa
	private Timer timer;

	private ArrayList<Player> players = new ArrayList<>();
	private ArrayList<Player> suspended = new ArrayList<>();
	
	private int round = 1; //il round finisce quando i giocatori hanno tutti fatto 1 mossa. Quando i giocatori hanno fatto 4 mosse, allora vuol dire che siamo alla fine del round 4
	private int turn = 1; //dopo che è finito il round 4, vuol dire che e' terminato il turno
	private int period = 1; 
	private int actualPlayer = -1; 

	
	private EventHandler<RoundManager> gameOver = new EventHandler<>();
	private EventHandler<RoundManager> newPeriod = new EventHandler<>();
	private EventHandler<RoundManager> newTurn = new EventHandler<>();
	private EventHandler<Player> timerOut = new EventHandler<>();
	
	public RoundManager(ArrayList<Player> players){
		this.players = players;
	}
	
	public void nextRound(){
		if(round == MAX_ROUND_PER_TURN){
			nextTurn();
		}
		round++;
		actualPlayer = 0;
	}
	
	public void nextTurn(){
		round = 1; //resetto il round
		turn++; //incremento il turno
		actualPlayer = 0; //punto al primo giocatore
		
		if(((turn+1) % 2) == 0){ //il periodo finisce sui turni pari; il +1 serve altrimenti sul secondo turno del terzo periodo non funziona
			//nextPeriod();        //incrementa il periodo, il turno ed il round sono già aggiornati nell'if precedente
			newPeriod.invoke(this);
		}
		return;
	}
	
	public void nextPeriod(){
		period++;
		if(gameIsOver()){
			gameOver.invoke(this);
		}
	}
	
	public void setNewOrder(ArrayList<Player> players){
		this.players = players;
	}
	
	public ArrayList<Player> getCurrentOrder() {
		return players;
	}
	
	public Player next(){
		if(!gameIsOver() && !roundIsOver()){
			actualPlayer++;
		}
		
		if(roundIsOver()){
			newTurn.invoke(this);
			//nextRound();
		}
		
		Player player = players.get(actualPlayer);
		if(!suspended.contains(player))
			return player;
		return next();
	}
	
	public int getRound() {
		return round;
	}
	public int getTurn() {
		return (turn/period); //all'esterno i turni sono solo 2, per periodo
	}
	public int getPeriod() {
		return period;
	}
	
	private boolean turnIsOver(){
		//il turno è finito quando i round sono pari al numero di giocatori
		return (round >= MAX_ROUND_PER_TURN);
	}
	
	private boolean roundIsOver(){
		//quando i giocatori hanno tutti fatto una mossa
		return (actualPlayer >= players.size());
	}
	
	public Player getCurrentPlayer() {
		return players.get(actualPlayer);
	}
	
	public boolean gameIsOver(){
		return period>MAX_PERIOD;
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
	
// Time handling ______________________________-
	
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
	
}
