package it.polimi.ingsw.ps11.view.textualView.components;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;

public class Input {
	
	private TextualConsole console;
	private ArrayList<EventListener<String>> listenersToRemove = new ArrayList<>();
	
	private EventHandler<String> handler = new EventHandler<>();
	
	public Input(TextualConsole console) {
		this.console = console;
	}
	
	public void attach(EventListener<String> listener){
		handler.attach(listener);
	}
	
	public void detach(EventListener<String> listener){
		listenersToRemove.add(listener);
	}
	
	public void clear() {
		for(EventListener<String> listener : listenersToRemove)
			handler.detach(listener);
		
		listenersToRemove.clear();
	}
	
	public String read(){
		String input;
		input = console.read();
		handler.invoke(input);
		clear();
		return input;
	}
}
