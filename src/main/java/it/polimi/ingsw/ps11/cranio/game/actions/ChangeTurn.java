package it.polimi.ingsw.ps11.cranio.game.actions;

import it.polimi.ingsw.ps11.cranio.events.EventHandler;
import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.game.RoundManager;
import it.polimi.ingsw.ps11.cranio.player.Player;

public class ChangeTurn implements Action{

	private Player subject;
	private Game game;
	
	EventHandler<ChangeTurn> endGameEvent = new EventHandler<>();
	
	public ChangeTurn(Game game,Player subject) {
		this.game = game;
		this.subject = subject;
	}
	
	@Override
	public void perform() {
		RoundManager roundManager = game.getRoundManager();
		if(!roundManager.roundIsOver()){
			roundManager.next();
		}
	}

	@Override
	public boolean isLegal() {
		if(game.getRoundManager().getCurrentPlayer().equals(subject)){
			return true;
		}
		return false;
	}

	@Override
	public void accept(ActionVisitor visitor) {
		visitor.visit(this);
	}

	
}
