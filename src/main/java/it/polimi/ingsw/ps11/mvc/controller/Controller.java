package it.polimi.ingsw.ps11.mvc.controller;

import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.cranio.events.list.ConsoleInputEvent;
import it.polimi.ingsw.ps11.mvc.model.Model;
import it.polimi.ingsw.ps11.mvc.view.TextualView;

public class Controller implements EventListener<ConsoleInputEvent>{
	
	
	private Model model;
	private TextualView view;

	public Controller(Model model, TextualView view) {
		this.model = model;
		this.view = view;
	
		view.getInputChangeEvent().attach(this);
		view.getStampaEvent().attach(stampaListener);
		view.getTiraDadiEvent().attach(tiraDadiListener);
	}
	
	private EventListener<Void> stampaListener = new EventListener<Void>() {
		@Override
		public void handle(Void event) {
			System.out.println("Voi che stampi..");
		}
	};
	
	private EventListener<Void> tiraDadiListener = new EventListener<Void>() {
		@Override
		public void handle(Void event) {
			model.getGame().getDiceManager().rollDices();
			view.stampaDadi(model.getGame().getDiceManager());
		}
	};
	
	@Override
	public void handle(ConsoleInputEvent event) {
		System.out.println("Sono il controller, hai scritto: " + event.getInput());
	}
}
