package it.polimi.ingsw.ps11.view.textualView;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import it.polimi.ingsw.ps11.controller.network.message.LogInMessage;
import it.polimi.ingsw.ps11.controller.network.message.Message;
import it.polimi.ingsw.ps11.model.JsonAdapter;
import it.polimi.ingsw.ps11.model.cards.CardManager;
import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMemberManager;
import it.polimi.ingsw.ps11.model.game.Board;
import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.modelEvents.ConfirmEvent;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.towers.BlueTower;
import it.polimi.ingsw.ps11.model.zones.towers.GreenTower;
import it.polimi.ingsw.ps11.model.zones.towers.PurpleTower;
import it.polimi.ingsw.ps11.model.zones.towers.YellowTower;
import it.polimi.ingsw.ps11.view.textualView.components.TextualBoardView;
import it.polimi.ingsw.ps11.view.textualView.components.TextualChooseFamilyView;
import it.polimi.ingsw.ps11.view.textualView.components.TextualChooseResourceView;
import it.polimi.ingsw.ps11.view.textualView.components.TextualFloorView;
import it.polimi.ingsw.ps11.view.textualView.components.TextualPlayerView;
import it.polimi.ingsw.ps11.view.viewEvents.ConfirmViewEvent;
import it.polimi.ingsw.ps11.view.viewEvents.AskUpdateEvent;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.FloorSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.HarvestSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.MarketSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.ProductionSelectedEvent;
import it.polimi.ingsw.ps11.view.viewGenerica.View;
/**
 * <h3>TextualView</h3>
 * <p>
 * Classe rappresentante la CLI. Da qui l'utente si interfaccia con il gioco. Il suo funzionamento e' semplice:
 * dal server arriva un oggetto del gioco e viene stampato a video; la console e' sempre in ascolto di eventuali input; se il giocatore
 * inserisce un comando contenuto nella Map allora viene invocato l'evento ed inviato al server
 * Classe rappresentante la CLI. Da qui l'utente si interfaccia con il gioco.

 * </p>
 */
public class TextualView extends View {
	
	private TextualCommands commands;
	private transient Input input;
	
	private EventHandler<Message> messageHandler = new EventHandler<>();
	
	
	public TextualView() {
		you = new TextualPlayerView();
		boardView = new TextualBoardView();
		TextualConsole c = new TextualConsole();
		console = c;
		input = new Input(c);
	
		try {
			commands = loadCommands();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private TextualCommands loadCommands() throws FileNotFoundException{
		FileReader reader = new FileReader("settings\\textualCommands");
		TextualCommands commands = new JsonAdapter().fromJson(reader, TextualCommands.class);
		return commands;
	}
	
	
	@Override
	public void print() {
//		boardView.print();
//		you.print();
		console.println(commands.getInstructions()); 

	}

	@Override
	public void run() {
		//waitInput();
		logIn();
		waitInput();
	}
	
	
	private void logIn(){
		String nickName = console.read("\nInserisci il nome con cui vorresti loggare: ");
		String pw = console.read("\nInserisci la password: ");
		messageHandler.invoke(new LogInMessage(nickName,pw));
	}
	
	@Override
	public void attachMessageListener(EventListener<Message> listener) {
		this.messageHandler.attach(listener);
	}
	
	private void waitInput(){
		String command;
		while (!(command = input.read()).equals("q")){
			if(commands.get(command) != null){
				viewEvent.invoke(commands.get(command));
				//console.println("debug: hai selezionato l'evento : " + commands.get(command).getClass().getSimpleName());
			}
		}
	}
	
	@Override
	public void update(Board board){
		this.boardView.update(board);
		new TextualBoardView(board).print();
	}

	@Override
	public void update(Player player){
		this.you.update(player);
		new TextualPlayerView(player).print();
	}
	
	@Override
	public void update(FamilyMemberManager familyMemberManager){
		TextualChooseFamilyView chooser = new TextualChooseFamilyView(input, familyMemberManager, this.viewEvent);
		chooser.print();
		console.println("\n Press 1..4 to select the family member ");
		input.attach(chooser);
	}
	
	@Override
	public void update(Game game) {
		this.update(game.getBoard());
	}
	
//	public void registrate(Registration registration){
//		TextualRegistationView registrate = new TextualRegistationView(registration,viewEvent,input);
//		registrate.print();
//		input.attach(registrate);
//	}
	
	@Override
	public void chooseResource(ArrayList<ResourceList> costs){ 
		if(costs != null){
			TextualChooseResourceView chooser = new TextualChooseResourceView(input, costs, this.viewEvent);
			chooser.print();
			input.attach(chooser);
		}
	}
	
	@Override
	public void confirm(ConfirmEvent confirm) {
		Floor floor = confirm.getFloor();
		String tower = "";
		if(confirm.getTower()!=null)
			tower = confirm.getTower();
		TextualFloorView floorView = new TextualFloorView(tower,0);
		floorView.update(floor);
		floorView.print();
		console.println(confirm.getMessage());
		console.println("Select servant number or press -1 to abort");
		
		input.attach(new EventListener<String>() {
			
			@Override
			public void handle(String e) {
				int parsed;
				try {
					parsed = Integer.parseInt(e);
					if(parsed >= 0){
						viewEvent.invoke(new ConfirmViewEvent(true,parsed));
					}
						
				} catch (NumberFormatException e1) {
					new TextualConsole().println("Choice not valid!");
				}finally{
					input.detach(this);
				}
			}
		});
	}
	
}
