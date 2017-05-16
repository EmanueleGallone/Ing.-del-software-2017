package it.polimi.ingsw.ps11.mvc.controller;

import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.mvc.model.Model;
import it.polimi.ingsw.ps11.mvc.view.TextualView;

public class AdvanceController {
	private Game model;
	private TextualView view;

	public AdvanceController(Model model, TextualView view) {
		this.model = model.getGame();
		this.view = view;
	}
	
	private void start(){
		model.startGame();
		Player player = model.getRoundManager().getPlayerAttuale();
	}
	
}
