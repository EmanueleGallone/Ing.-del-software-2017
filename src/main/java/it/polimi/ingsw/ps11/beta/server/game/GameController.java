package it.polimi.ingsw.ps11.beta.server.game;

import java.util.ArrayList;
import java.util.HashMap;

import it.polimi.ingsw.ps11.beta.client.RemoteClient;
import it.polimi.ingsw.ps11.cranio.actions.test.Player;

public class GameController implements Runnable {

	private HashMap<RemoteClient, Player> players = new HashMap<>();
	
	public GameController(ArrayList<RemoteClient> clients) {
		ArrayList<RemoteClient> players = (ArrayList<RemoteClient>) clients.clone();
		for(RemoteClient client : players){
			//this.players.put(client, value);
		}
	}

	@Override
	public void run() {
		
	}
}
