package it.polimi.ingsw.ps11.controller.server.gameServer;

import java.util.ArrayList;
import java.util.HashMap;

import it.polimi.ingsw.ps11.controller.network.Connection;
import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.player.Player;

public class GameController implements Runnable {

	private HashMap<Connection, Player> players = new HashMap<>();
	private Game game;
	
	public GameController(ArrayList<Connection> clients) {
		ArrayList<Connection> players = (ArrayList<Connection>) clients.clone();
		int i = 0;
		PlayerFactory pFactory = new PlayerFactory();
		
		for(Connection client : players){
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
	
	public void updatePlayer(Player player){
		/*
		try {
			getClient(player).update(player);
		} catch (RemoteException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		*/
	}

	@Override
	public void run() {
		/*
		for(RemoteClient client : players.keySet()){
			try {
				client.startGame(game,players.get(client));
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		*/
	}
}
