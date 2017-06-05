package it.polimi.ingsw.ps11.mvc.view.viewGenerica;

import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.zones.Board;

public interface ViewInterface {
	
	public abstract void out(String message);

	public void update(Game game);
	public void update(Board board);
	public void update(Player player);
}
