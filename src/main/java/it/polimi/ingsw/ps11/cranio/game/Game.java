package it.polimi.ingsw.ps11.cranio.game;

import java.io.IOException;
import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.cards.CardManager;
import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.dices.DiceManager;
import it.polimi.ingsw.ps11.cranio.game.loaders.ResourceLoader;
import it.polimi.ingsw.ps11.cranio.game.loaders.RoundManager;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.resources.Resource;
import it.polimi.ingsw.ps11.cranio.zones.Board;
import it.polimi.ingsw.ps11.cranio.zones.towers.*;

public class Game {
		
	private Board board = new Board();
	private ArrayList<Resource> resources = new ArrayList<>();
	private ArrayList<DevelopmentCard> cards = new ArrayList<>();
	private DiceManager diceManager = new DiceManager();
	private RoundManager roundManager;
	
	public Game(ArrayList<Player> players) {
		
		/*
		try
		{
			loadComponent(players); //Bisogna decidere cosa fare de la load fallisce
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		*/
		
	}
	
// Start logic
	
	protected void loadComponent(ArrayList<Player> players) throws IOException{
		
		CardsLoader cardsLoader = new CardsLoader();
		ResourceLoader resourceLoader = new ResourceLoader();
		
		roundManager = new RoundManager(players);
		cards = cardsLoader.load();
		resources = resourceLoader.load();
		initializeTower(board);
	}
	
	
	
	public RoundManager getRoundManager() {
		return roundManager;
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
		diceManager.rollDices();
		
	}
	
// End logic
	
// Start getters
	
	public Board getBoard() {
		return board;
	}
	
// End getters

}
