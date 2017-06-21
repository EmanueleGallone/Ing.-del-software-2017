package it.polimi.ingsw.ps11.model.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.json.JsonAdapter;
import it.polimi.ingsw.ps11.model.resources.Resource;
import it.polimi.ingsw.ps11.model.zones.Board;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;

public class GameLoader implements Serializable  {
	
	private Board board;
	
	public GameLoader(int playerNumber) {
		try {
			board = initializeBoard();
			board.getMarket().setPlayerNumber(playerNumber);
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
	

	public Board getBoard() {
		return board;
	}

}
