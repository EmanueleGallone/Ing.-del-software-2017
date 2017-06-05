package it.polimi.ingsw.ps11.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.zones.Floor;
import it.polimi.ingsw.ps11.cranio.zones.towers.Tower;
import it.polimi.ingsw.ps11.mvc.model.Model;
import it.polimi.ingsw.ps11.mvc.view.textualView.tree.TextualComponent;
import it.polimi.ingsw.ps11.mvc.view.textualView.tree.TextualView;
import it.polimi.ingsw.ps11.mvc.view.textualView.tree.components.TextualFloorView;
import it.polimi.ingsw.ps11.mvc.view.textualView.tree.components.TextualPlayerView;

public class Controller {
	private Game model;
	private HashMap<TextualView, Player> viewMap = new HashMap<>();
	private Player player;

	public Controller(Model model, TextualView view) {
		this.model = model.getGame();
		for(Player p : this.model.getRoundManager().getCurrentOrder()){
			this.viewMap.put(new TextualView(), p);
		}
	}
	
	private TextualView textualView = new TextualView();
	
	
// _______________ EVENT LISTENER _____________________


	EventListener<TextualFloorView> floorUpdaterListener = new EventListener<TextualFloorView>() {
		//Questo non è necessario, l'update del listener verrà notificata dal model
		
		@Override
		public void handle(TextualFloorView e) {
			e.update(getFloor(e.getColor(), e.getWhichFloor()));
		}
	};
	
	EventListener<TextualPlayerView> playerUpdaterListener = new EventListener<TextualPlayerView>() {

		@Override
		public void handle(TextualPlayerView e) {
			e.update(player.clone()); // Sbagliato, anche clonando il player la view potrebbe accedere alle risorse che sono quelle nel model
			//La clone del player dovrebbe clonare tutto, anche le risorse
		}
	};
	
	
	EventListener<TextualFloorView> floorSelectedListener = new EventListener<TextualFloorView>() {

		@Override
		public void handle(TextualFloorView e) {
			//String choice = textualView.choseFamilyMember();
			e.print();
		}
	};
	
	EventListener<String> inputChangeListener = new EventListener<String>() {

		@Override
		public void handle(String e) {
			TextualComponent component = $(e);
			if (component != null)
				component.select();
		}
	};
	
	public void event(){
		
		
		$(TextualFloorView.class).forEach(f -> {f.printEvent(floorUpdaterListener);});
		
		$(TextualFloorView.class).forEach(f -> {f.selectedEvent(floorSelectedListener);} );
		
		textualView.inputChangeEvent(inputChangeListener);
	}

	
	private <T extends Tower> Floor getFloor(Class<T> tType, int floor){
		T tower = model.getBoard().getTower(tType);
		return (Floor) tower.selectFloor(floor).clone();
	}
	
	
//__________________________________________________________
	
	//					NOTIFICHE DAL MODEL
	
	
	
	EventListener<Floor> floorChangeListener = new EventListener<Floor>() {

		@Override
		public void handle(Floor e) {
			
		}
	};

	
	
//__________________________________________________________
	
	private <T> T $(String id, Class<T> retType){
		TextualComponent component = textualView.getDocument().searchById(id);
		if (component != null && component.getClass() == retType){
			return (T) component; 
		}
		return null;
		//Va gestito il caso di return null
	}
	
	private TextualComponent $(String id){
		return textualView.getDocument().searchById(id);
	}
	
	private <T extends TextualComponent> Stream<T> $(Class<T> retType){
		ArrayList<TextualComponent> result = textualView.getDocument().searchAll((t)->{return t.getClass() == retType;});
		return (Stream<T>) result.stream(); 
	}
	
	
	
	public void start(){
		event();
		model.startGame();
		textualView.start();
	}
	
}
