package it.polimi.ingsw.ps11.cranio.game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.cards.CardManager;
import it.polimi.ingsw.ps11.cranio.dices.DiceManager;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.zones.Board;

public class Game {
	
	private final static String settingsFile = "";
	
	private ArrayList<Player> players = new ArrayList<>();
	private Board board = new Board();
	private DiceManager diceManager = new DiceManager();
	private CardManager cardManager = new CardManager();
	
	public Game() {
		
	}
	
// Start logic
	
	public void loadComponent() throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(settingsFile));
		String line;
		
		while((line = reader.readLine()) != null){
			cardManager.deserializeCard(line);
		}
	}
	
	public void startGame(){
		
	}
	
// End logic
}
