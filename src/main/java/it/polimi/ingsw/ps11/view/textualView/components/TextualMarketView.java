package it.polimi.ingsw.ps11.view.textualView.components;

import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.MarketView;

public class TextualMarketView extends MarketView{

	@Override
	public void print() {
		TextualConsole console = new TextualConsole();
		TextualResourceView resourceView = new TextualResourceView();
		String owner= "Nobody";
		console.print("Market\n");
		
		for(ActionSpace space : market.getAllSpace()){
			if(space.getOwner() != null)
				owner = space.getOwner().getName();
			
			console.print("Player: " + owner + "   ");
			
			if(space.getResources() != null){
				resourceView.update(space.getResources());
				resourceView.print();
				console.println("");
			}
			
			
		}
		console.print("\n");
	}

}
