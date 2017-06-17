package it.polimi.ingsw.ps11.beta.server.game;

import java.util.ArrayList;
import java.util.HashMap;

import it.polimi.ingsw.ps11.beta.client.RemoteClient;
import it.polimi.ingsw.ps11.cranio.player.Player;

public class GameController implements Runnable {

	private HashMap<RemoteClient, Player> players = new HashMap<>();
	
	public GameController(ArrayList<RemoteClient> clients) {
		ArrayList<RemoteClient> players = (ArrayList<RemoteClient>) clients.clone();
		int i = 0;
		PlayerFactory pFactory = new PlayerFactory();
		
		for(RemoteClient client : players){
			Player player = pFactory.newPlayer(i);
			this.players.put(client, player);
			//client.update(player);
			i++;
		}
	}

	@Override
	public void run() {
		
	}
}
