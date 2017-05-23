package it.polimi.ingsw.ps11.cranio.game;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.dices.DiceManager;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.zones.Board;

public class Game {
	
	private Board board = new Board();
	private DiceManager diceManager = new DiceManager();
	private RoundManager roundManager;
	
	public Game(ArrayList<Player> players) {
		
		loadComponent(players);
		
	}
	
// Start logic
	
	protected void loadComponent(ArrayList<Player> players){
		
		roundManager = new RoundManager(players);
		//CardsLoader cardsLoader = new CardsLoader();
		//cards = cardsLoader.load();
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
	public RoundManager getRoundManager() {
		return roundManager;
	}
	
// End getters

}
