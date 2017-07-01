package it.polimi.ingsw.ps11.view.textualView.components;

import it.polimi.ingsw.ps11.controller.Registration;
import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.view.textualView.Input;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEventInterface;

public class TextualRegistationView implements EventListener<String> {
	
	private Input input;
	private TextualConsole console = new TextualConsole();
	private EventHandler<ViewEventInterface> events;
	
	public TextualRegistationView(Registration registration, EventHandler<ViewEventInterface> viewEvent, Input input) {
		this.events = viewEvent;
		this.input = input;
	}
	
	public void print(){
		console.print("Insert you nickname followed by your password: ");

	}

	@Override
	public void handle(String e) {
		String[] splitted = e.split("\\s+");
		
		if (splitted.length == 2) {
			console.print("DEBUG : nick : " + splitted[0] + " pwd: " + splitted[1]);
			//events.invoke(choosednickanem(splitted[0]));
			//events.invoke(choosedpassword(splitted[1]));
			input.detach(this);
		}
		
		if (splitted.length != 2) {
			console.print("Type [nickname] *press Spacebar* [password] :");
		}
				
		
	}
		
	

}
