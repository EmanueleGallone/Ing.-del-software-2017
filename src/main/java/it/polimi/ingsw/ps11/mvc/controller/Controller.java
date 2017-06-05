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
import it.polimi.ingsw.ps11.mvc.view.textualView.tree.components.FloorView;
import it.polimi.ingsw.ps11.mvc.view.textualView.tree.components.PlayerView;

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


	EventListener<FloorView> floorUpdaterListener = new EventListener<FloorView>() {
		//Questo non è necessario, l'update del listener verrà notificata dal model
		
		@Override
		public void handle(FloorView e) {
			e.update(getFloor(e.getColor(), e.getWhichFloor()));
		}
	};
	
	EventListener<PlayerView> playerUpdaterListener = new EventListener<PlayerView>() {

		@Override
		public void handle(PlayerView e) {
			e.update(player.clone()); // Sbagliato, anche clonando il player la view potrebbe accedere alle risorse che sono quelle nel model
			//La clone del player dovrebbe clonare tutto, anche le risorse
		}
	};
	
	
	EventListener<FloorView> floorSelectedListener = new EventListener<FloorView>() {

		@Override
		public void handle(FloorView e) {
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
		
		
		$(FloorView.class).forEach(f -> {f.printEvent(floorUpdaterListener);});
		
		$(FloorView.class).forEach(f -> {f.selectedEvent(floorSelectedListener);} );
		
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
