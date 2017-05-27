package it.polimi.ingsw.ps11.mvc.posView;

import java.util.HashMap;

import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.zones.Floor;
import it.polimi.ingsw.ps11.cranio.zones.towers.Tower;
import it.polimi.ingsw.ps11.mvc.model.Model;
import it.polimi.ingsw.ps11.mvc.posView.component.FloorView;
import it.polimi.ingsw.ps11.mvc.posView.component.TowerView;
import it.polimi.ingsw.ps11.mvc.posView.events.TextualViewEvent;

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
			/*TextualView view = event.getSource();
			Player player = viewMap.get(view);
			try {
				view.getPlayerView().printStatus(player.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}*/
		}
	};
	
	EventListener<TextualViewEvent<TowerView>> towerSelectedListener = new EventListener<TextualViewEvent<TowerView>>() {

		@Override
		public void handle(TextualViewEvent<TowerView> e) {
			
			TowerView tView = e.getSource();
			Tower t = tView.getTower();
			
			try{
				t = model.getBoard().getTower(t.getClass());
				Floor floor = t.selectFloor(new Integer(e.getInput()));
				//floorSelectedListener.handle(new TextualViewEvent<>(floor,e.getTextualView()));
			}
			catch (IllegalArgumentException ex){	
				e.getTextualView().showErrorMessage(ex.getMessage());
			}
			
		}
	};
	
	EventListener<TextualViewEvent<FloorView>> floorSelectedListener = new EventListener<TextualViewEvent<FloorView>>() {

		@Override
		public void handle(TextualViewEvent<FloorView> e) {
			e.getSource();
		}
	};
	
	
	EventListener<TextualViewEvent<FloorView>> takeCardListener = new EventListener<TextualViewEvent<FloorView>>() {

		@Override
		public void handle(TextualViewEvent<FloorView> e) {
			// TODO Auto-generated method stub
			
		}
	};
	
	EventListener<TextualViewEvent<TowerView>> updateTowerListener = new EventListener<TextualViewEvent<TowerView>>() {

		@Override
		public void handle(TextualViewEvent<TowerView> e) {
			Tower t = e.getSource().getTower();
			t  = model.getBoard().getTower(t.getClass());
			try {
				e.getSource().update(t.clone());
			} catch (CloneNotSupportedException e1) {
				e1.printStackTrace();
			}
		}

	};

	
//__________________________________________________________
	

	protected void attachAll(TextualView view){
		
		//view.getPrintStatus().attach(printPlayerStatus);
		//view.getPosizionaFamiliareTorre().attach(posizionaInTorreListener);
		//view.getComponent(TowerView.class).getTowerSelectedEvent().attach(towerSelectedListener);;
	}
	
	public void start(){
		
		model.startGame();
		
		for(TextualView t : viewMap.keySet()){
			attachAll(t);
			t.start();
		}
	}
	
}
