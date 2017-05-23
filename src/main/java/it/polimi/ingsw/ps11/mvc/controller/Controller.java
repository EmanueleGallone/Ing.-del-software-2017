package it.polimi.ingsw.ps11.mvc.controller;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.attachment.AttachmentMarshaller;

import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.events.Event;
import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.zones.towers.Tower;
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

	
	EventListener<Event> posizionaTorreListener = new EventListener<Event>() {
		
		@Override
		public void handle(Event event) {
			ArrayList<Tower> towers = model.getBoard().getTowers();
			String input = view.scegliTorre(towers);
			Integer i;
			try{
				i = Integer.parseInt(input);
				if (i < towers.size()){
					input = view.scegliCarta(towers.get(i));
				}
			}
			catch (Exception e) {
				view.print("Non hai selezionato una torre");
			}
		}
	};
	
//__________________________________________________________
	

	protected void attachAll(){
	
		view.getPrintStatus().attach(printPlayerStatus);
		view.getPosizionaFamiliareTorre().attach(posizionaTorreListener);
	}
	
	public void start(){
		
		attachAll();
		
		model.startGame();
		view.start();
	}
	
}
