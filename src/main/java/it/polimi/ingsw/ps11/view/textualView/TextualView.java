package it.polimi.ingsw.ps11.view.textualView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import it.polimi.ingsw.ps11.model.events.Event;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMemberManager;
import it.polimi.ingsw.ps11.model.familyMember.list.BlackFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.NeutralFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.OrangeFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.WhiteFamilyMember;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.zones.Board;
import it.polimi.ingsw.ps11.model.zones.towers.BlueTower;
import it.polimi.ingsw.ps11.model.zones.towers.GreenTower;
import it.polimi.ingsw.ps11.model.zones.towers.PurpleTower;
import it.polimi.ingsw.ps11.model.zones.towers.YellowTower;
import it.polimi.ingsw.ps11.view.textualView.components.TextualBoardView;
import it.polimi.ingsw.ps11.view.textualView.components.TextualChooseFamilyView;
import it.polimi.ingsw.ps11.view.textualView.components.TextualChooseResourceView;
import it.polimi.ingsw.ps11.view.textualView.components.TextualPlayerView;
import it.polimi.ingsw.ps11.view.viewEvents.FamilySelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.FloorSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.MarketSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.ProductionSelectedEvent;
import it.polimi.ingsw.ps11.view.viewGenerica.View;
/**
 * <h3>TextualView</h3>
 * <p> 
<<<<<<< HEAD
 * Classe rappresentante la CLI. Da qui l'utente si interfaccia con il gioco. Il suo funzionamento e' semplice:
 * dal server arriva un oggetto del gioco e viene stampato a video; la console e' sempre in ascolto di eventuali input; se il giocatore
 * inserisce un comando contenuto nella Map allora viene invocato l'evento ed inviato al server
=======
 * Classe rappresentante la CLI. Da qui l'utente si interfaccia con il gioco.
>>>>>>> GabLog
 * </p>
 */
public class TextualView extends View {
	
	Map<String, ViewEvent> events = new HashMap<String, ViewEvent>();
	
	public static String input; //necessario per rendere il read da tastiera non bloccante
	
	//le istruzioni vanno aggiornate allora
	private String instructions = "\n\ninstruction:"
			+ "\nif you want to select the floor of a tower type \" yellow tower 1 \""
			+ "\nif you want to select a family member (e.g. orange) -> orange family "
			+ "\n"; 
	
	public TextualView() {
		you = new TextualPlayerView();
		boardView = new TextualBoardView();
		console = new TextualConsole();
		
		initializeEventMap();
	}
	
	
	@Override
	public void print() {
		//questo metodo potrebbe essere eliminato
		//boardView.print();
		//you.print();
		console.println(instructions); 

	}

	//@Override
	public void run() {
		//metto in nuovo thread in modo che l'input non sia bloccante. ho notato che se fai una update dopo view.run() non viene stampata.
		//non ho provato usando il client. magari usando il client (che dovrebbe essere in un Thread separato) il problema non sussiste		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				print();
				//String input;
				while (!(input = console.read()).equals("q")){

					if(events.get(input) != null){
						viewEvent.invoke(events.get(input));
						System.out.println("debug: hai selezionato l'evento : " + events.get(input).getClass().getSimpleName());
					}
					else 
						System.out.println("Unknown command. Retry\n");
				}
				
			}
		}).start();
		
	}
	
	@Override
	public void update(Board board){
		new TextualBoardView(board).print();
	}

	@Override
	public void update(Player player){
		new TextualPlayerView(player).print();
	}
	
	public void update(FamilyMemberManager familyMemberManager){
		//manca l'override e va aggiunto nella view
		new TextualChooseFamilyView(familyMemberManager).print();
	}
	
	public void update(ArrayList<ResourceList> costs){ 
		//per scegliere il costo e creare l'evento. va aggiunta nella view
		new TextualChooseResourceView(costs).print();
	}
	
	private void initializeEventMap(){
		
		events.put("yellow tower 1", new FloorSelectedEvent(YellowTower.class, 1));
		events.put("yellow tower 2", new FloorSelectedEvent(YellowTower.class, 2));
		events.put("yellow tower 3", new FloorSelectedEvent(YellowTower.class, 3));
		events.put("yellow tower 4", new FloorSelectedEvent(YellowTower.class, 4));
		events.put("green tower 1", new FloorSelectedEvent(GreenTower.class, 1));
		events.put("green tower 2", new FloorSelectedEvent(GreenTower.class, 2));
		events.put("green tower 3", new FloorSelectedEvent(GreenTower.class, 3));
		events.put("green tower 4", new FloorSelectedEvent(GreenTower.class, 4));
		events.put("blue tower 1", new FloorSelectedEvent(BlueTower.class, 1));
		events.put("blue tower 2", new FloorSelectedEvent(BlueTower.class, 2));
		events.put("blue tower 3", new FloorSelectedEvent(BlueTower.class, 3));
		events.put("blue tower 4", new FloorSelectedEvent(BlueTower.class, 4));
		events.put("purple tower 1", new FloorSelectedEvent(PurpleTower.class, 1));
		events.put("purple tower 2", new FloorSelectedEvent(PurpleTower.class, 2));
		events.put("purple tower 3", new FloorSelectedEvent(PurpleTower.class, 3));
		events.put("purple tower 4", new FloorSelectedEvent(PurpleTower.class, 4));
		
		events.put("market 1", new MarketSelectedEvent(1));
		events.put("market 2", new MarketSelectedEvent(2));
		events.put("market 3", new MarketSelectedEvent(3));
		events.put("market 4", new MarketSelectedEvent(4));
		
		events.put("orange family", new FamilySelectedEvent(OrangeFamilyMember.class));
		events.put("black family", new FamilySelectedEvent(BlackFamilyMember.class));
		events.put("white family", new FamilySelectedEvent(WhiteFamilyMember.class));
		events.put("neutral family", new FamilySelectedEvent(NeutralFamilyMember.class));
		
		events.put("production" , new ProductionSelectedEvent()); //manca l'harvest
	}
	
}
