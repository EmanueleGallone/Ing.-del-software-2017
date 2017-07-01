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
public class RoundManagerTemp implements Serializable{

	private static final int MAX_ROUND_PER_TURN = 4;
	private static final int MAX_PERIOD = 3;
	
	private long delay = 60000; //va caricato da file, Tempo a disposizione di ciascun player per fare la propria mossa
	private Timer timer;

	private ArrayList<Player> players = new ArrayList<>();
	private ArrayList<Player> suspended = new ArrayList<>();
	
	private int actions = 0;
	private int actualPlayer = 0; 

	
	private EventHandler<RoundManagerTemp> gameOver = new EventHandler<>();
	private EventHandler<RoundManagerTemp> newPeriod = new EventHandler<>();
	private EventHandler<RoundManagerTemp> newTurn = new EventHandler<>();
	private EventHandler<Player> timerOut = new EventHandler<>();
	
	public RoundManagerTemp(ArrayList<Player> players){
		this.players = players;
	}
	
	
	
	public Player next(){
		
		
		
		
		return null;
	}
	
	
	
	
	
	public Player getCurrentPlayer() {
		if(actualPlayer < players.size())
			players.get(actualPlayer);
		return null;
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

	
	public void newPeriodEvent(EventListener<RoundManagerTemp> listener){
		newPeriod.attach(listener);
	}
	
	public void newTurnEvent(EventListener<RoundManagerTemp> listener){
		newTurn.attach(listener);
	}
	
	public void gameOverEvent(EventListener<RoundManagerTemp> listener){
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
