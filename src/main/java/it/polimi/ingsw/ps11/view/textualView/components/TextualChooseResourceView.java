package it.polimi.ingsw.ps11.view.textualView.components;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.view.textualView.Input;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewEvents.ResourceSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEventInterface;
import it.polimi.ingsw.ps11.view.viewGenerica.components.ChooseResourceView;
import it.polimi.ingsw.ps11.view.viewGenerica.components.Console;
/**
 * <h3> TextualChooseResourceView</h3>
 * <p> Classe per la visualizzazione testuale di varie ResourceLists tra cui scegliere quale pagare/ottenere.</p>
 * @see ChooseResourceView
 */
public class TextualChooseResourceView extends ChooseResourceView implements EventListener<String>{
	
	private EventHandler<ViewEventInterface> events;
	private Input input;
	
	public TextualChooseResourceView(ArrayList<ResourceList> costs) {
		update(costs);
	}
	
	public TextualChooseResourceView(Input input,ArrayList<ResourceList> costs, EventHandler<ViewEventInterface> viewEvent) {
		update(costs);
		this.events = viewEvent;
		this.input = input;
	}
	
	@Override
	public void print(){
		Console console = new TextualConsole();
		console.print("\nChoose a resource: \n"); 
		
		int cont = 1;
		
		for(ResourceList choice: costs){
			console.print("\n  "+cont+") ");
			new TextualResourceView(choice).print();
			cont++;
		}
		
//		int counter = costs.size();
//		for(ResourceList r : costs){
//			resourceView.update(r);
//			console.print(choice + ")" );
//			choice++;
//			resourceView.print();
//			if(counter > costs.size()-1){
//				console.println("\nOR");
//				counter--;
//			}
//		}
		console.println("\n");
	}

	@Override
	public void handle(String e) {
		int parsed;
		try {
			parsed = Integer.parseInt(e);
			parsed--;
			if(parsed < costs.size() && parsed >= 0){
				events.invoke(new ResourceSelectedEvent(costs.get(parsed)));
			}
				
		} catch (NumberFormatException e1) {
			new TextualConsole().println("Choice not valid!");
		}finally{
			input.detach(this);
		}
	}
		
}

