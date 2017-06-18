package it.polimi.ingsw.ps11.model.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.actions.ActionHandler;
import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.dices.DiceManager;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.json.JsonAdapter;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.Resource;
import it.polimi.ingsw.ps11.model.zones.Board;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;

public class Game implements Serializable  {
	
	private Board board;
	private RoundManager roundManager;

	private ActionHandler actions = new ActionHandler();
	
	public Game(ArrayList<Player> players) {
		
		roundManager = new RoundManager(players);
		roundManager.newTurn(newTurnListener);
		roundManager.newPeriod(newPeriodListener);
		try {
			board = initializeBoard();
			board.getMarket().setPlayerNumber(players.size());
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

// ____________________________________GAME LOGICS_________________________________
	
	public Tower selectTower(Integer choice) {
		//Da cancellare
		if (choice != null && choice < board.getTowers().size()){
			return board.getTowers().get(choice);
		}
		throw new IllegalArgumentException("Non hai selezionato una torre valida");
	}
	
	
	private EventListener<RoundManager> newTurnListener = new EventListener<RoundManager>() {

		@Override
		public void handle(RoundManager e) {
			ArrayList<Player> newOrder = getBoard().getCouncilPalace().getNewOrder();
			if(newOrder != null){
				e.setNewOrder(newOrder);
			}
			if(!e.gameIsOver())
				board.getDices().rollDices();
		}
	};
	
	private EventListener<RoundManager> newPeriodListener = new EventListener<RoundManager>() {

		@Override
		public void handle(RoundManager e) {
			if(!e.gameIsOver())
				refreshCard();
		}
	};
	
	public void refreshCard(){
		// Qua aggiorna le carte sulla torre
	}
	
	public void endRound(){
		//Cose da fare a fine round
	}
	public void endGame(){
		//Cose da fare a fine partita
	}

// Events ___________________________________________
	

}
