package it.polimi.ingsw.ps11.cranio.game;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.dices.DiceManager;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.zones.Board;

public class Game {
	public final int MAX_TURN = 2;
	public final int MAX_PERIODS = 3;
	public final int MAX_PLAYERS = 4;
	
	
	private Board board = new Board();

	private ResourceList resources;
	
	private DiceManager diceManager = new DiceManager();
	
	private ArrayList<Player> players;
	
	private Player playerCorrente;
	
	public Game(ArrayList<Player> players) {
		
		loadComponent(players);
		
	}
	
// Start logic
	
	protected void loadComponent(ArrayList<Player> players){
		
		CardsLoader cardsLoader = new CardsLoader();
		
		this.players = players;
		
		
	}
	
	public DiceManager getDiceManager() {
		return diceManager;
	}
	
	public void startGame(){
		newTurn();
		
		
	}
	
	public void newTurn(){
		diceManager.rollDices();
	}
	
// End logic
	
// Start getters
	
	public Board getBoard() {
		return board;
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public Player getPlayerCorrente() {
		return playerCorrente;
	}
	
// End getters
	
	public void setPlayerCorrente(Player playerCorrente) {
		this.playerCorrente = playerCorrente;
	}

}
