package it.polimi.ingsw.ps11.mvc.posView;

import java.util.HashMap;

import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.cranio.events.list.TextualViewEvent;
import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.mvc.model.Model;

public class Controller {
	private Game model;
	private HashMap<TextualView, Player> viewMap = new HashMap<>();

	public Controller(Model model, TextualView view) {
		this.model = model.getGame();
		for(Player p : this.model.getRoundManager().getPlayers()){
			this.viewMap.put(new TextualView(), p);
		}
	}
	
// _______________ EVENT LISTENER _____________________
	
	EventListener<TextualViewEvent> printPlayerStatus = new EventListener<TextualViewEvent>() {

		@Override
		public void handle(TextualViewEvent event) {
			Player player = viewMap.get(event.getSource());
			event.getSource().getPlayer().printStatus(player);
		}		
	};

	
//__________________________________________________________
	

	protected void attachAll(TextualView view){
		
		view.getPrintStatus().attach(printPlayerStatus);
		//view.getPosizionaFamiliareTorre().attach(posizionaTorreListener);
	}
	
	public void start(){
		
		model.startGame();
		
		for(TextualView t : viewMap.keySet()){
			attachAll(t);
			t.start();
		}
	}
	
}
