package it.polimi.ingsw.ps11.mvc.view;

import it.polimi.ingsw.ps11.cranio.game.Game;

public abstract class View extends Thread implements ViewInterface {
	
	private Game game;
	
	@Override
	public void update(Game game){
		this.game = game;
	}
}
