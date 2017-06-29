package it.polimi.ingsw.ps11.view.textualView.components;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.ChooseResourceView;
import it.polimi.ingsw.ps11.view.viewGenerica.components.Console;
import it.polimi.ingsw.ps11.view.viewGenerica.components.ResourceView;

public class TextualChooseResourceView extends ChooseResourceView {
	
	private Console console = new TextualConsole();
	private ResourceView resourceView = new TextualResourceView();
	//gli passo la viewEvent in modo da invocare l'evento qui dentro?
	
	public TextualChooseResourceView(ArrayList<ResourceList> costs) {
		update(costs);
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

}
