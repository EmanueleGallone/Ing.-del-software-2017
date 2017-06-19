package it.polimi.ingsw.ps11.controller.server.gameServer;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import it.polimi.ingsw.ps11.controller.client.network.RemoteClient;
import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.gameLogics.GameLogics;
import it.polimi.ingsw.ps11.model.player.Player;

public class GameController implements Runnable {

	private HashMap<RemoteClient, Player> players = new HashMap<>();
	private Game game;
	private GameLogics gameLogics;
	
	public GameController(ArrayList<RemoteClient> clients) {
		ArrayList<RemoteClient> players = (ArrayList<RemoteClient>) clients.clone();
		int i = 0;
		PlayerFactory pFactory = new PlayerFactory();
		
		for(RemoteClient client : players){
			Player player = pFactory.newPlayer(i);
			this.players.put(client, player);
			i++;
		}
		
		game = new Game(new ArrayList<>(this.players.values()));
	}
	
	
	public RemoteClient getClient(Player player) throws IllegalArgumentException{
		for (RemoteClient client : players.keySet()){
			if(player.equals(players.get(client))){
				return client;
			}
		}
		throw new IllegalArgumentException();
	}
	
	public void updatePlayer(Player player){
		try {
			getClient(player).update(player);
		} catch (RemoteException | IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		for(RemoteClient client : players.keySet()){
			try {
				client.startGame(game,players.get(client));
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}
}
