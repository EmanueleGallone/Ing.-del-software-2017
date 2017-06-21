package it.polimi.ingsw.ps11.view.textualView.components;

import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.DevelopmentCardView;

public class TextualDevelopmentCardView extends DevelopmentCardView {

	@Override
	public void print() {
		TextualConsole console = new TextualConsole();
		TextualResourceView resourceView = new TextualResourceView();
		console.print(card.getName() + " ");
		
		for(ResourceList resourceList : card.getCosts()) {
			console.print("Costi: ");
			resourceView.update(resourceList);
			resourceView.print();
		}
		
		//mancano i bonus
		
	}
}
