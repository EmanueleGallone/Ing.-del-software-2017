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
import it.polimi.ingsw.ps11.mvc.view.TextualView;

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
	
	public void start(){
		
		attachAll();
		
		model.startGame();
		view.start();
	}
	
}
