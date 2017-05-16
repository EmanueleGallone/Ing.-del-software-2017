package it.polimi.ingsw.ps11.mvc.controller;

import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.cards.PurpleCard;
import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.cranio.events.list.ConsoleInputEvent;
import it.polimi.ingsw.ps11.cranio.events.list.ScegliCartaEvent;
import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.mvc.model.Model;
import it.polimi.ingsw.ps11.mvc.view.TextualView;

public class Controller implements EventListener<ConsoleInputEvent>{
	
	
	private Game model;
	private TextualView view;

	public Controller(Model model, TextualView view) {
		this.model = model.getGame();
		this.view = view;
	
		view.getInputChangeEvent().attach(this);
		view.getStampaEvent().attach(stampaListener);
		view.getTiraDadiEvent().attach(tiraDadiListener);
		view.getStampaFamiliare().attach(stampaFamiliareListener);
		
		//GlobalEventHandler.getScegliCarta().attach(scegliCarta);
	}
	

	private DevelopmentCard scegliCarta(){
		int i = view.scegliCarta();
		DevelopmentCard card = null;
		if (i == 1){
			card = new PurpleCard();
		}
		return card;
	}
	
	
	private EventListener<ScegliCartaEvent> scegliCarta = new EventListener<ScegliCartaEvent>() {
		
		@Override
		public void handle(ScegliCartaEvent event) {
			event.setCard(scegliCarta());
		}
	};
	
	private EventListener<Void> stampaFamiliareListener = new EventListener<Void>() {
		@Override
		public void handle(Void event) {
			//String stringa = model.getGame().getRoundManager().getPlayers(0).getWhiteFamilyMember().toString();
			//view.stampa(stringa);
		}
	};
	
	private EventListener<Void> stampaListener = new EventListener<Void>() {
		@Override
		public void handle(Void event) {
			System.out.println("Voi che stampi..");
		}
	};
	
	private EventListener<Void> tiraDadiListener = new EventListener<Void>() {
		@Override
		public void handle(Void event) {
			model.getDiceManager().rollDices();
			view.stampaDadi(model.getDiceManager());
		}
	};
	
	@Override
	public void handle(ConsoleInputEvent event) {
		System.out.println("Sono il controller, hai scritto: " + event.getInput());
	}
}
