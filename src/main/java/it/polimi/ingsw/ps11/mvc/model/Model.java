package it.polimi.ingsw.ps11.mvc.model;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;

public class Model {

	
	private Game game;
	
	public Model() {
		ArrayList<Player> players = new ArrayList<>();
		players.add(new Player());
		players.add(new Player());
		players.add(new Player());
		players.add(new Player());
		
		game = new Game(players);
	}
	
	public void doSomething(){
		
	}
	
	public Game getGame() {
		return game;
	}
}
