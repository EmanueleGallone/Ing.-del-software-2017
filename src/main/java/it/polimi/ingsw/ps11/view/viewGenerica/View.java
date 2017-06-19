package it.polimi.ingsw.ps11.view.viewGenerica;

import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.zones.Board;
import it.polimi.ingsw.ps11.view.ViewInterface;
import it.polimi.ingsw.ps11.view.viewGenerica.components.BoardView;
import it.polimi.ingsw.ps11.view.viewGenerica.components.Console;
import it.polimi.ingsw.ps11.view.viewGenerica.components.PlayerView;

public abstract class View implements ViewInterface, Runnable {
	
	protected Console console;
	protected PlayerView you;
	protected BoardView boardView;
	
	public View() {
		
	}


	@Override
	public void out(String message) {
		console.println(message);
	}
	
	// UPDATE ____________________________-
	

	@Override
	public void update(Game game) {
		boardView.update(game.getBoard());
	}

	@Override
	public void update(Board board) {
		boardView.update(board);
	}

	@Override
	public void update(Player player) {
		you.update(player);
	}
}
