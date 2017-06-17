package it.polimi.ingsw.ps11.model.game.actionsEma;

import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.game.RoundManager;
import it.polimi.ingsw.ps11.model.player.Player;

public class FinishRoundAction extends PlayerAction {

	private Game game;
	
	public FinishRoundAction(Player player, Game game) {
		super(player);
		this.game = game;
	}

	@Override
	public boolean isLegal() {
		if(player == game.getRoundManager().getCurrentPlayer()) //notabene: bisogna passargli lo stesso oggetto
			return true;
		
		return false;
	}
	
	@Override
	public void perform() {
		//potremmo usare il pattern state per evitare gli if
		//occhio che basta fare roundManager.next() e fa tutto lui
		RoundManager roundManager = game.getRoundManager();
		
		if( roundManager.roundIsOver() ){
			//roundManager.nextRound();
			roundManager.next();
		}

		/*
>>>>>>> Pos
		if( roundManager.turnIsOver() && roundManager.getTurn() == roundManager.getRefreshCardsTurn()){
			//refresh carte nelle torri
			//togliere i familiari
		}
		*/
		//gestire le scomuniche
		
	}

}