package it.polimi.ingsw.ps11.view.textualView.components;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEventInterface;
import it.polimi.ingsw.ps11.view.viewGenerica.components.ChooseResourceView;
import it.polimi.ingsw.ps11.view.viewGenerica.components.Console;
import it.polimi.ingsw.ps11.view.viewGenerica.components.ResourceView;

public class TextualChooseResourceView extends ChooseResourceView implements EventListener<String>{
	
	private Console console = new TextualConsole();
	private ResourceView resourceView = new TextualResourceView();
	//gli passo la viewEvent in modo da invocare l'evento qui dentro?
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
		console.print("Choose a cost: \n"); 
		int counter = costs.size();
		int choice = 1;
		
		for(ResourceList r : costs){
			resourceView.update(r);
			console.print(choice + ")" );
			choice++;
			resourceView.print();
			if(counter > costs.size()-1){
				console.println("\nOR");
				counter--;
			}
		}
		console.println("");
	}

	@Override
	public void handle(String e) {
		int parsed;
		
		try {
			parsed = Integer.parseInt(e);
			if((parsed +1) <= costs.size() && parsed > 0){
				//events.invoke(SelectedCost(costs.get(parsed)));
				console.print("hai scelto " + costs.get(parsed));
			}
				
		} catch (NumberFormatException e1) {
			console.println("Choice not valid!");
		}finally{
			input.detach(this);
		}
		
		
	}
		
}

