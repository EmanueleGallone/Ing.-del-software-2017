package it.polimi.ingsw.ps11.mvc.posView.component;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.events.EventHandler;
import it.polimi.ingsw.ps11.cranio.zones.Floor;
import it.polimi.ingsw.ps11.cranio.zones.towers.Tower;
import it.polimi.ingsw.ps11.mvc.posView.QuitGameException;
import it.polimi.ingsw.ps11.mvc.posView.TextualComponent;
import it.polimi.ingsw.ps11.mvc.posView.TextualView;
import it.polimi.ingsw.ps11.mvc.posView.events.TextualViewEvent;

public class TowerView implements TextualComponent {

	private String menuAzione = "Premi un numero da 1 a 4 per selezionare un piano.";
	private Tower tower;
	private TextualView textualView;
	
	ArrayList<FloorView> floors;
	
	EventHandler<TextualViewEvent<TowerView>> towerSelectedEvent = new EventHandler<>();
	EventHandler<TextualViewEvent<TowerView>> updateTowerEvent = new EventHandler<>();
	
	public TowerView(TextualView textualView) {
		this.textualView = textualView;
	}
	
	
	public String scegliTorre(ArrayList<Tower> towers) throws Exception{
		printTowers(towers);
		return new Console().read("Scegli la torre: ");
	}
	
	public void printTowers(ArrayList<Tower> towers){
		for(Tower tower: towers){
			new Console().print(tower.toString());
		}
	}
	
	public void printTower(Tower tower){
		System.out.println("Tower: " + tower.getClass());
		for(Floor floor : tower.getFloors()){
			printFloor(floor);
		}
	}
	
	public void printFloor(Floor floor){
		new Console().print(floor.toString());
	}
	
	public String scegliPiano(Tower tower) throws Exception{
		printTower(tower);
		return new Console().read("Scegli quale carta prendere [Inserisci un numero da 1 a 4]:");
	}
	
	public boolean prendiCarta(DevelopmentCard card) throws QuitGameException{
		new Console().print(card.toString());
		
		String string = new Console().read("Vuoi prendere la carta? [y/n]: ");
		if(string.equals("y")){
			return true;
		}
		return false;
	}	
	
	@Override
	public void print() {
		updateTowerEvent.invoke(new TextualViewEvent<>(this));
	}
	
	public EventHandler<TextualViewEvent<TowerView>> getTowerSelectedEvent() {
		return towerSelectedEvent;
	}
	
	public void update(Tower tower){
		this.tower = tower;
	}

	public Tower getTower() {
		return tower;
	}
	
	@Override
	public void select() throws Exception {
		Console console = new Console();
		console.print("Hai selezionato " + this.getClass().getName() + ". Scegli cosa fare");
		console.print(menuAzione);
		String input = console.read();
		towerSelectedEvent.invoke(new TextualViewEvent(this,input));
	}
	
}
