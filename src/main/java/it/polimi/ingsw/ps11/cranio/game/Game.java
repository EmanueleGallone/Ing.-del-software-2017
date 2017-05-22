package it.polimi.ingsw.ps11.cranio.game;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.dices.DiceManager;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.zones.Board;

public class Game {
	
	private Board board = new Board();
	private ArrayList<DevelopmentCard> cards = new ArrayList<>();
	private DiceManager diceManager = new DiceManager();
	
	private ArrayList<Player> players;
	
	private Player playerCorrente;
	
	public Game(ArrayList<Player> players) {
		
		loadComponent(players);
		
	}
	
// Start logic
	
	protected void loadComponent(ArrayList<Player> players){
		
		CardsLoader cardsLoader = new CardsLoader();
		//roundManager = new RoundManager(players);
		//cards = cardsLoader.load();
		initializeTower(board);
	}
	
	public void initializeTower(Board board){
		/*
		board.addTower(new GreenTower());
		board.addTower(new BlueTower());
		board.addTower(new YellowTower());
		board.addTower(new PurpleTower());*/

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
