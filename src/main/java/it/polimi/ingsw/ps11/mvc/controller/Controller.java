package it.polimi.ingsw.ps11.mvc.controller;

import java.util.HashMap;

import javax.naming.NameNotFoundException;

import it.polimi.ingsw.ps11.cranio.cards.list.GreenCard;
import it.polimi.ingsw.ps11.cranio.events.Event;
import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.zones.Floor;
import it.polimi.ingsw.ps11.cranio.zones.towers.GreenTower;
import it.polimi.ingsw.ps11.mvc.MyMap;
import it.polimi.ingsw.ps11.mvc.components.FloorView;
import it.polimi.ingsw.ps11.mvc.components.TextualComponent;
import it.polimi.ingsw.ps11.mvc.model.Model;
import it.polimi.ingsw.ps11.mvc.view.TextualView;
import it.polimi.ingsw.ps11.mvc.view.events.FloorSelectedEvent;

public class Controller {
	private Game model;
	private HashMap<TextualView, Player> viewMap = new HashMap<>();

	public Controller(Model model, TextualView view) {
		this.model = model.getGame();
		for(Player p : this.model.getRoundManager().getPlayers()){
			this.viewMap.put(new TextualView(), p);
		}
	}
	

	private MyMap map = new MyMap();
	
// _______________ EVENT LISTENER _____________________

	
	EventListener<String> inputChangeListener = new  EventListener<String>() {
		
		@Override
		public void handle(String e) {
			
			TextualComponent component;
			try {
	
				component = map.getViewComponent(e, TextualComponent.class);
				component.selected();
				
			} catch (NameNotFoundException | ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	};

	
	EventListener<FloorSelectedEvent> floorSelectedListener = new EventListener<FloorSelectedEvent>() {
		
		@Override
		public void handle(FloorSelectedEvent e) {
			FloorView floorView = e.getSource();
			try {
				Floor floor = map.getModelComponent(floorView.toString(), Floor.class);
				
			} catch (NameNotFoundException | ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	};
	
//__________________________________________________________
	

	protected void attachAll(TextualView view){
		
		//view.getPrintStatus().attach(printPlayerStatus);
		//view.getPosizionaFamiliareTorre().attach(posizionaTorreListener);
	}
	
	protected void initialize(){
		map.addModelElement("GreenTower 1", model.getBoard().getTower(GreenTower.class).getFloors().get(0));
		//map.addViewElement("GreenTowe 1", );
	}
	
	public void start(){
		
		model.startGame();
		
		for(TextualView t : viewMap.keySet()){
			attachAll(t);
			//t.start();
		}
	}
	
}
