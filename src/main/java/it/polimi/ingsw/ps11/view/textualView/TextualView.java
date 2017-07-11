package it.polimi.ingsw.ps11.view.textualView;


import java.io.FileNotFoundException;
import java.util.ArrayList;

import it.polimi.ingsw.ps11.controller.network.message.LogInMessage;
import it.polimi.ingsw.ps11.controller.network.message.Message;
import it.polimi.ingsw.ps11.model.FileRegistry;
import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMemberManager;
import it.polimi.ingsw.ps11.model.game.Board;
import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.loaders.Loader;
import it.polimi.ingsw.ps11.model.modelEvents.ConfirmEvent;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.view.textualView.components.TextualBoardView;
import it.polimi.ingsw.ps11.view.textualView.components.TextualChooseFamilyView;
import it.polimi.ingsw.ps11.view.textualView.components.TextualChooseResourceView;
import it.polimi.ingsw.ps11.view.textualView.components.TextualDevelopmentCardView;
import it.polimi.ingsw.ps11.view.textualView.components.TextualPlayerView;
import it.polimi.ingsw.ps11.view.viewEvents.ActiveLeaderCardEvent;
import it.polimi.ingsw.ps11.view.viewEvents.ConfirmViewEvent;
import it.polimi.ingsw.ps11.view.viewGenerica.View;
/**
 * <h3>TextualView</h3>
 * <p>
 * Classe rappresentante la CLI. Da qui l'utente si interfaccia con il gioco. Il suo funzionamento e' semplice:
 * dal server arriva un oggetto del gioco e viene stampato a video; la console e' sempre in ascolto di eventuali input; se il giocatore
 * inserisce un comando contenuto nella Map allora viene invocato l'evento ed inviato al server. La view ha una struttura modulare.
 * </p>
 */
public class TextualView extends View {
	
	private TextualCommands commands;
	private transient Input input;
	private boolean block = false;
	
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
	/**
	 * <p>
	 * Classe che permette il caricamento dei comandi utilizzabili dalla CLI.
	 * </p>
	 * @throws FileNotFoundException
	 */
	private TextualCommands loadCommands() throws FileNotFoundException{
		return new Loader(FileRegistry.view_commands).load(TextualCommands.class);
	}
	
	
	@Override
	public void print() {
		if (!block) {
			boardView.print();
			you.print();
			console.println(commands.getInstructions()); 
			block = true;
		}
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
				if (command.equals("update")){
					block = false;
				}				
			}
			else if (command.contains("leader")) {
				command = command.replace("leader", "");
				command = command.trim();
				viewEvent.invoke(new ActiveLeaderCardEvent(command));
			}
		}
	}
	
	@Override
	public void update(Board board){
		this.boardView.update(board);
	}

	@Override
	public void update(Player player){
		this.you.update(player);
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
		if(confirm.getFloor() != null && confirm.getFloor().getCard() != null){
			TextualDevelopmentCardView developmentCardView = new TextualDevelopmentCardView();
			developmentCardView.update(confirm.getFloor().getCard());
			developmentCardView.print();
			
			console.println(confirm.getMessage());
			console.println("Select servant number");
		}

		console.println("type zero for confirm, type a number greater than zero to confirm and use the typed number of servant, otherwise type -1");
		console.println(confirm.getMessage());
		
		
		input.attach(new EventListener<String>() {
			
			@Override
			public void handle(String e) {
				int parsed;
				try {
					parsed = Integer.parseInt(e);
					if(parsed >= 0){
						viewEvent.invoke(new ConfirmViewEvent(true,parsed));
						return;
					}
					viewEvent.invoke(new ConfirmViewEvent(false));
				} catch (NumberFormatException e1) {
					new TextualConsole().println("Choice not valid!");
				}finally{
					input.detach(this);
				}
			}
		});
	}
	
}
