package it.polimi.ingsw.ps11.model.modelEvents;

import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.zones.Board;

public class GameStartedEvent implements ModelEvent{

	private Board board;
	private Player player;
	
	public GameStartedEvent(Board board, Player player) {
		this.board = board;
		this.player = player;
	}
	
	public Board getBoard() {
		return board;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	@Override
	public void accept(ModelListener listener) {
		listener.handle(this);
	}

	@Override
	public void setReceiver(Player player) {
		this.player = player;
	}

	@Override
	public Player getReceiver() {
		return player;
	}

}
