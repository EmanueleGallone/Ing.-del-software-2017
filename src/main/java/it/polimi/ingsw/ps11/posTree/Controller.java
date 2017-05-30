package it.polimi.ingsw.ps11.posTree;

import java.util.HashMap;
import java.util.stream.Stream;

import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.zones.Floor;
import it.polimi.ingsw.ps11.cranio.zones.towers.Tower;
import it.polimi.ingsw.ps11.mvc.model.Model;
import it.polimi.ingsw.ps11.posTree.components.FloorView;

public class Controller {
	private Game model;
	private HashMap<TextualView, Player> viewMap = new HashMap<>();
	private Player player;

	public Controller(Model model, TextualView view) {
		this.model = model.getGame();
		for(Player p : this.model.getRoundManager().getPlayers()){
			this.viewMap.put(new TextualView(), p);
		}
	}
	
	private TextualView textualView = new TextualView();

	
// _______________ EVENT LISTENER _____________________

	
	public void event(){
		
		$(FloorView.class).forEach( f -> {f.printEvent(new EventListener<FloorView>() {

			@Override
			public void handle(FloorView e) {
				
				e.update(getFloor(e.getColor(), e.getWhichFloor()));
			}
			
		});}
	 );
		
		
		$(FloorView.class).forEach(f -> {f.selectedEvent(new EventListener<FloorView>() {

			@Override
			public void handle(FloorView e) {
				//String choice = textualView.choseFamilyMember();
				e.print();
			}
		});});
	
		
		
		
		$("DOM",TextualView.class).inputChangeEvent(new EventListener<String>() {
			
			@Override
			public void handle(String e) {
				TextualComponent component = $(e);
				if (component != null)
					component.select();
			}
		});
	}

	
	private <T extends Tower> Floor getFloor(Class<T> tType, int floor){
		T tower = model.getBoard().getTower(tType);
		return (Floor) tower.selectFloor(floor).clone();
	}
	
	
//__________________________________________________________
	
	
	private <T> T $(String id, Class<T> retType){
		TextualComponent component = textualView.getDocument().searchById(id);
		if (component != null && component.getClass() == retType){
			return (T) component; 
		}
		return (T) component;
		//Va gestito il caso di return null
	}
	
	private TextualComponent $(String id){
		return textualView.getDocument().searchById(id);
	}
	
	private <T extends TextualComponent> Stream<T> $(Class<T> retType){
		//return (Stream<T>) textualView.getDocument().searchById(id);
		return null;
	}
	
	
	
	public void start(){
		event();
		model.startGame();
		textualView.start();
	}
	
}
