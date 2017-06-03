package it.polimi.ingsw.ps11.network.server;

import java.util.ArrayList;
import java.util.HashMap;

public class ServerController {
	private HashMap<Integer, Match> partite = new HashMap<Integer, Match>();
	private Server server;
	
	public ServerController(Server server) {
		this.server = server;
	}

	public void addMatch(Integer id, Match match){
		partite.put(id, match);
	}
	
	public void sendInGame(int game, String player, Object object){
		partite.get(game).send(player, object);
	}
}
