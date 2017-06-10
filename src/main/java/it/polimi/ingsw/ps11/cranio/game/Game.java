package it.polimi.ingsw.ps11.cranio.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.JsonAdapter;
import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.dices.DiceManager;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.resources.Resource;
import it.polimi.ingsw.ps11.cranio.zones.Board;
import it.polimi.ingsw.ps11.cranio.zones.towers.Tower;

public class Game  {
	
	private Board board;
	private DiceManager diceManager = new DiceManager();
	private RoundManager roundManager;
	

	
	public Game(ArrayList<Player> players) {
		
		roundManager = new RoundManager(players);
		
		try {
			board = initializeBoard();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private Board initializeBoard() throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader("settings\\board"));
		String line,strBoard = "";
		
		while ((line = reader.readLine())!=null){
			strBoard += line;
		}
		
		ArrayList<Class<?>> list = new ArrayList<>();
		list.add(DevelopmentCard.class);
		list.add(Resource.class);
		list.add(Tower.class);
		
		JsonAdapter jsonAdapter = new JsonAdapter(list);
		return jsonAdapter.fromJson(strBoard, Board.class);
	}
	
// Start getters
	
	public Board getBoard() {
		return board;
	}
	public RoundManager getRoundManager() {
		return roundManager;
	}
	public DiceManager getDiceManager() {
		return diceManager;
	}

// ____________________________________GAME LOGICS_________________________________
	
	public void startGame(){
		newTurn();
	}
	
	public void newTurn(){
		diceManager.rollDices();
	}
	
	
	public Tower selectTower(Integer choice) {
		//Da cancellare
		if (choice != null && choice < board.getTowers().size()){
			return board.getTowers().get(choice);
		}
		throw new IllegalArgumentException("Non hai selezionato una torre valida");
	}
	
	
	public void changeTurn(){
		/*
		if(!roundManager.roundIsOver()){
			roundManager.next();
		}
		else if(!roundManager.gameIsOver()){
			ArrayList<Player> newOrder = new ArrayList<>();
			for(FamilyMember f : board.getCouncilPalace().getFamilyMembers()){
				newOrder.add(f.getOwner());
			}
			roundManager.setNewOrder(newOrder);
			roundManager.nextRound();
			endRound();
		}
		else {
			endGame();
		}*/
	}
	
	public void endRound(){
		//Cose da fare a fine round
	}
	public void endGame(){
		//Cose da fare a fine partita
	}

// Events ___________________________________________
	

}
