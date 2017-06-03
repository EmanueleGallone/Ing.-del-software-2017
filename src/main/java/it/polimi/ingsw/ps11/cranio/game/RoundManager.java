package it.polimi.ingsw.ps11.cranio.game;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.events.EventHandler;
import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.cranio.player.Player;

public class RoundManager {

	private static final int MAX_ROUND = 6;
	private static final int ROUND_FOR_PERIOD = 2;
	private int round = 1;
	private ArrayList<Player> players = new ArrayList<>();
	private int actualPlayer = 0; 
	
	public RoundManager(ArrayList<Player> players) {
		this.players = players;
	}
	
	public Player next() {
		if(!turnIsOver()){
			actualPlayer++;
			return players.get(actualPlayer);
		}
		return null;
	}
	
	public void nextRound(){
		actualPlayer = 0;
		if(!gameIsOver())
			round++;
	}
	
	public boolean turnIsOver(){
		return (actualPlayer + 1 >= players.size());
	}
	
	public boolean gameIsOver(){
		return (round >= MAX_ROUND);
	}
	
	public Player getCurrentPlayer() {
		return players.get(actualPlayer);
	}
	
	public ArrayList<Player> getCurrentOrder() {
		return players;
	}
	public void setNewOrder(ArrayList<Player> players) {
		this.players = players;
		nextRound();
	}
	
	public int getRound() {
		return round;
	}
	public int getPeriod() {
		int period = 0;
		if(ROUND_FOR_PERIOD != 0){
			period = round/ROUND_FOR_PERIOD;
			if(!(round % ROUND_FOR_PERIOD == 0))
				period++;
		}
		return period;
	}
}
