package it.polimi.ingsw.ps11.view;

import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.zones.Board;

public interface ViewInterface {
	
	public void print();
	public abstract void out(String message);

	public void update(Game game);
	public void update(Board board);
	public void update(Player player);
}
