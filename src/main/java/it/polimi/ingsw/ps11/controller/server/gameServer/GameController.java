package it.polimi.ingsw.ps11.controller.server.gameServer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import it.polimi.ingsw.ps11.controller.messageList.toClient.StartGameMessage;
import it.polimi.ingsw.ps11.controller.network.Connection;
import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.player.Player;

public class GameController implements Runnable {

	private HashMap<Connection, Player> players = new HashMap<>();
	private Game game;
	
	public GameController(ArrayList<Connection> clients) {
		
		int i = 0;
		PlayerFactory pFactory = new PlayerFactory();
		
		for(Connection client : clients){
			Player player = pFactory.newPlayer(i);
			this.players.put(client, player);
			i++;
		}
		
		game = new Game(new ArrayList<>(this.players.values()));
	}
	
	
	public Connection getClient(Player player) throws IllegalArgumentException{
		for (Connection client : players.keySet()){
			if(player.equals(players.get(client))){
				return client;
			}
		}
		throw new IllegalArgumentException();
	}
	

	@Override
	public void run() {
		for(Connection client : players.keySet()){
			try {
				client.send(new StartGameMessage(game, players.get(client)));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
