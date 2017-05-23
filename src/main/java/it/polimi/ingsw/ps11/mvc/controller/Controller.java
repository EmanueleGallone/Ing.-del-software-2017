package it.polimi.ingsw.ps11.mvc.controller;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.attachment.AttachmentMarshaller;

import it.polimi.ingsw.ps11.cranio.events.Event;
import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.mvc.model.Model;
import it.polimi.ingsw.ps11.mvc.view.textual.TextualView;

public class Controller {
	private Game model;
	private TextualView view;

	public Controller(Model model, TextualView view) {
		this.model = model.getGame();
		this.view = view;
	}
	
// _______________ EVENT LISTENER _____________________
	
	
	EventListener<Event> printPlayerStatus = new EventListener<Event>() {
		
		@Override
		public void handle(Event event) {
		  Player player =	model.getRoundManager().getActualPlayer();
		  view.printStatus(player);
		}
	};

	
//__________________________________________________________
	

	protected void attachAll(){
	
		view.getPrintStatus().attach(printPlayerStatus);
	}
	
	private void start(){
		
		attachAll();
		
		model.startGame();
		view.start();
	}

	
//______________________________________________________________________________________________
	
	//MAIN
	
	public static void main(String[] args){
		
		
		TextualView textualView = new TextualView();
		ArrayList<Player> players = new ArrayList<>();
		
		Player p1 = new Player();
		p1.setName("Jack");
		Player p2 = new Player();
		p2.setName("Sparrow");
		
		players.add(p1);
		players.add(p2);
		
		Controller controller = new Controller(new Model(players), textualView);
		//textualView.update(controller.model);
		controller.start();
	}
	
	
	
}
