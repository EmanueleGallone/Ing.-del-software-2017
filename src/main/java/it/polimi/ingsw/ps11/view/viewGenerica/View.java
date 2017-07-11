package it.polimi.ingsw.ps11.view.viewGenerica;

import it.polimi.ingsw.ps11.controller.network.message.Message;
import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.game.Board;
import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.view.ViewInterface;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEventInterface;
import it.polimi.ingsw.ps11.view.viewGenerica.components.BoardView;
import it.polimi.ingsw.ps11.view.viewGenerica.components.Console;
import it.polimi.ingsw.ps11.view.viewGenerica.components.PlayerView;

/**
 * <h3>View</h3>
 * <p> Classe astratta rappresentante la view che il giocatore puo' scegliere, ovvero CLI o GUI. e' stata portata avanti
 * una struttura modulare utilizzando i "components". Ogni oggetto che ha bisogno di essere stampato a video fa parte dei components.
 * </p>
 */
public abstract class View implements ViewInterface, Runnable {
	
	protected Game game;
	protected PlayerView you;
	protected BoardView boardView;
	protected Console console;
	
	protected EventHandler<ViewEventInterface> viewEvent = new EventHandler<>();

	@Override
	public void out(String message) {
		console.println(message);
	}
	
	// EVENT _____________________________
	
	
	public void attach(EventListener<ViewEventInterface> listener){
		this.viewEvent.attach(listener);
	}
	
	public void attachMessageListener(EventListener<Message> listener) {}
	
	// UPDATE ____________________________
	/**
	 * <h3>update</h3>
	 * <p> Metodo che permette l'update della board; da qui in poi sara' possibile, per ogni View (Testuale o grafica)
	 *  prendere gli elementi da mandare a video.
	 *  </p>
	 */
	@Override
	public void update(Board board){
		boardView.update(board);
	}
	
	@Override
	public void update(Game game) {
		boardView.update(game.getBoard());
		boardView.update(game.getRoundManager().getCurrentOrder());
		
	}

	@Override
	public void update(Player player) {
		you.update(player);
	}

}
