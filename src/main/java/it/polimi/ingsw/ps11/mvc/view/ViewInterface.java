package it.polimi.ingsw.ps11.mvc.view;

import it.polimi.ingsw.ps11.cranio.game.Game;

public interface ViewInterface {
	
	public abstract void out(String message);

	public void update(Game game);
}
