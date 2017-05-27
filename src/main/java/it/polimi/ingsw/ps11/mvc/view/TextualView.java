package it.polimi.ingsw.ps11.mvc.view;

import java.util.HashMap;

import it.polimi.ingsw.ps11.cranio.events.EventHandler;
import it.polimi.ingsw.ps11.mvc.components.Console;

public class TextualView {

	Console console = new Console();
	
	
	
	EventHandler<String> inputChangeEvent = new EventHandler<>();
	
	public void start(){
		String input;
		
		while (!(input = console.read()).equals("quit")) {
			inputChangeEvent.invoke(input);
		}
		console.print("Quit game");
	}
	
	
	/*
	public void add(TextualComponent component){
		components.put(component.getClass().getName().toString(), component);
	}
	*/
	
}
