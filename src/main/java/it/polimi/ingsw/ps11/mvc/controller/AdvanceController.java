package it.polimi.ingsw.ps11.mvc.controller;

import it.polimi.ingsw.ps11.cranio.cards.GreenCard;
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
		
		this.view.addScegliCartaListener(scegliCarta);
		//this.view.getScegliCarta().attach(scegliCarta);
	}
	
	//ScegliCarta scegliCartaListener = new ScegliCarta();
	
//_______________________________________________________________
	
	public class ScegliCartaListener implements EventListener<Player>{

		public ScegliCartaListener() {
			view.addScegliCartaListener(this);
		}
		
		@Override
		public void handle(Player player) {
			scegliCarta(player);
		}
		
	}
	
//_______________________________________________________________

	private void scegliCarta(Player player){
		int i = view.scegliCarta();
		GreenCard card = new GreenCard();
		card.take(player);
	}
	
	EventListener<Player> scegliCarta = new EventListener<Player>() {

		@Override
		public void handle(Player player) {
			scegliCarta(player);
		}
	};
	
//_______________________________________________________________
	
	
	public void prova (Object o , Object[] args){
		//something...
	}
	
	
	
	private void start(){
		model.startGame();
		Player player = model.getRoundManager().getPlayerAttuale();
		player.play();
	}
	
}
