package it.polimi.ingsw.ps11.mvc.posView;

import java.util.HashMap;

import it.polimi.ingsw.ps11.cranio.events.EventHandler;
import it.polimi.ingsw.ps11.mvc.posView.component.BoardView;
import it.polimi.ingsw.ps11.mvc.posView.component.Console;
import it.polimi.ingsw.ps11.mvc.posView.component.GameView;
import it.polimi.ingsw.ps11.mvc.posView.component.TowerView;
import it.polimi.ingsw.ps11.mvc.posView.events.TextualViewEvent;

public class TextualView {
	
	Console console = new Console();
	private HashMap<String, TextualComponent> components = new HashMap<>();
	
	public TextualView() {
		addComponent(new BoardView());
		addComponent(new TowerView(this));
		addComponent(new GameView());
	}
	
	// ____________ START _______________
	
		public void start(){
		
			try {
				do {
					showMessage("Ogni componente ha un nome, digitalo e premi invio per selezionare quel componente ed accedere al suo menu azione. In ogni momento digita 'quit' per uscire: \n");
				} while(execute(console.read()));
			} catch (Exception e) {
				//e.printStackTrace();
			 	 console.print(e.getMessage());
			}
		}
	
// Start Event 
	
	EventHandler<TextualViewEvent> printStatus = new EventHandler<>();
	EventHandler<TextualViewEvent> posizionaFamiliareTorre = new EventHandler<>();
	
	public EventHandler<TextualViewEvent> getPrintStatus() {
		return printStatus;
	}
	public EventHandler<TextualViewEvent> getPosizionaFamiliareTorre() {
		return posizionaFamiliareTorre;
	}
	
// End Event
	
// Start logics

	protected boolean execute(String selection) throws Exception{
		
		if(selection.equals("quit"))
			return false;
		
		TextualComponent component = components.get(selection);
		if (component != null){
			component.select();
		}
		return true;
	}
	
	
	public String scegliFamilyMember() throws QuitGameException{
		return console.read("Digita il colore del family member");
	}
	
// End logics
	
	public void addComponent(TextualComponent component){
		components.put(component.getClass().getName().toString(), component);
	}
	
	public void showMessage(String message) {
		console.print(message);
	}
	public void showErrorMessage(String message) {
		console.printError(message);
	}
	
// Start getters
	
	public <T extends TextualComponent> T getComponent(Class<T> component){
		return (T) components.get(component.getName().toString());
	}
// End getters
}
