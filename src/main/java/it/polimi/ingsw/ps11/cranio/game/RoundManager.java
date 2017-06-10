package it.polimi.ingsw.ps11.cranio.game;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.player.Player;

public class RoundManager {

	private static final int MAX_TURN = 6;
	private static final int MAX_PERIOD = 3;
	private static final int ROUND_FOR_PERIOD = 2;
	private static final int REFRESH_CARDS_TURN = 1;
	private int round = 1;
	private ArrayList<Player> players = new ArrayList<>();
	private int actualPlayer = 0; 
	private int period = 1;
	private int turn = 1;
	
	public RoundManager(ArrayList<Player> players) {
		this.players = players;
	}
	
	public Player next() {
		if(!roundIsOver()){
			actualPlayer++;
			return players.get(actualPlayer);
		}
		return null;
	}
	
	public void nextRound(){
		if(!gameIsOver()){
			actualPlayer++;
			round++;
		}
		
	}
	
	public void nextTurn(){
		if(!gameIsOver()){
			actualPlayer = 0;
			round = 1;
			turn++;
		}
	}
	
	public boolean roundIsOver(){
		return (actualPlayer + 1 >= players.size());
	}
	
	public boolean turnIsOver(){
		return (round >= players.size());
	}
	
	public boolean gameIsOver(){
		return (period >= MAX_PERIOD);
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
	public int getTurn(){
		return turn;
	}
	public int getPeriod() {
		return period;
	}
	
	public static int getRefreshCardsTurn() {
		return REFRESH_CARDS_TURN;
	}
}
