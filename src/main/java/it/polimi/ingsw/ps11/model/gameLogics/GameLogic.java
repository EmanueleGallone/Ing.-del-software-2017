package it.polimi.ingsw.ps11.model.gameLogics;

import java.util.ArrayList;
import java.util.HashMap;

import it.polimi.ingsw.ps11.controller.network.Connection;
import it.polimi.ingsw.ps11.controller.server.gameServer.PlayerFactory;
import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.player.Player;

public class GameLogic {

	private HashMap<Connection, Player> players = new HashMap<>();
	private Game game;
	
	public GameLogic(ArrayList<Connection> clients) {
		
		int i = 0;
		PlayerFactory pFactory = new PlayerFactory();
		
		for(Connection client : clients){
			Player player = pFactory.newPlayer(i);
			this.players.put(client, player);
			i++;
		}
		
		game = new Game(new ArrayList<>(this.players.values()));
	}
	
	

}
