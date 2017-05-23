package it.polimi.ingsw.ps11.mvc.model;

import it.polimi.ingsw.ps11.cranio.game.Game;

public class Model {

	
	private Game game;
	
	public Model(Game game) {
		this.game = game;
	}
	
	public void doSomething(){
		
	}
	
	public Game getGame() {
		return game;
	}
}
