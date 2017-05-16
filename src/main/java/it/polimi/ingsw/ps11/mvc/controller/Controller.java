package it.polimi.ingsw.ps11.mvc.controller;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.cranio.events.Event;
import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.mvc.model.Model;
import it.polimi.ingsw.ps11.mvc.view.TextualView;

public class Controller {
	private Game model;
	private TextualView view;

	public Controller(Model model, TextualView view) {
		this.model = model.getGame();
		this.view = view;
		
		//this.view.addScegliCartaListener(scegliCarta);
		//this.view.getScegliCarta().attach(scegliCarta);
	}
	
	
	public void prova (Object o , Object[] args){
		//something...
	}
	
// _______________ EVENT LISTENER _____________________
	
	
	public class StampaPlayer2 implements EventListener<Event>{

		public StampaPlayer2() {
			view.addStampaPlayerListener(this);
		}
		
		@Override
		public void handle(Event event) {
			
		}
		
	}
	
	
	EventListener<Event> stampaPlayer1 = new EventListener<Event>() {
		@Override
		public void handle(Event event) {
		  Player player = model.getRoundManager().getPlayerAttuale();
		  view.stampaPlayer(player);
		}
	};
	
	
//__________________________________________________________
	
	private void start(){
		model.startGame();
		view.start();
		
		StampaPlayer2 pListener = new StampaPlayer2();
		// oppure 
		view.addStampaPlayerListener(stampaPlayer1);
		}
	
//______________________________________________________________________________________________
	
	//MAIN
	
	public static void main(String[] args){
		
		ArrayList<Player> players = new ArrayList<>();
		
		Controller controller = new Controller(new Model(players), new TextualView());
		
		controller.start();
	}
	
	
	
}
