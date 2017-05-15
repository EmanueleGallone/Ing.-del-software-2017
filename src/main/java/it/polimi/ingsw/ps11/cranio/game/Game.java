package it.polimi.ingsw.ps11.cranio.game;

import java.io.IOException;
import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.cards.CardManager;
import it.polimi.ingsw.ps11.cranio.dices.DiceManager;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.zones.Board;
import it.polimi.ingsw.ps11.cranio.zones.towers.*;

public class Game {
	
	private final static String cardsFile = "";
	
	private Board board = new Board();
	private DiceManager diceManager = new DiceManager();
	private CardManager cardManager = new CardManager();
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
		roundManager = new RoundManager(players);
		cardManager = cardsLoader.load(cardsFile);
		initializeTower(board);
	}
	
	public void initializeTower(Board board){
		/*
		ArrayList<Floor> greenFloors = new ArrayList<>();
		
		greenFloors.add(new Floor(1));
		greenFloors.add(new Floor(3));
		ResourceList resource = new ResourceList();
		resource.setWood(1);
		greenFloors.add(new Floor(5,resource.clone()));
		resource.setWood(2);
		greenFloors.add(new Floor(7,resource.clone()));
		
		board.addTower(new Tower(greenFloors));
		
		// Idem per le altre 4 torri... Non è il massimo.. Va rivisto.
		*/
		
		//Avendo introdotto 4 tipi di torri si può semplicemente fare.
		
		board.addTower(new GreenTower());
		board.addTower(new BlueTower());
		board.addTower(new YellowTower());
		board.addTower(new PurpleTower());
		
		// Si potrebbe fare la stessa cosa usando una Factory di torri però a quel punto
		// Servirebbe un enum di colori cosi alla factory gli passi il colore e lui ti da la torre costruita
	}
	
	public DiceManager getDiceManager() {
		return diceManager;
	}
	
	public void startGame(){
		diceManager.rollDices();
		Player player = roundManager.choosePlayer();
		player.play();
		// Qualcosa del genere... ovviamente in un ciclo
	}
	
// End logic
}
