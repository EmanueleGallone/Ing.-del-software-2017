package it.polimi.ingsw.ps11.view.textualView.components;

import it.polimi.ingsw.ps11.model.zones.Market;

import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.MarketView;

public class TextualMarketView extends MarketView{
	
	public TextualMarketView() {
	
	}
	
	public TextualMarketView(Market market){
		update(market);
	}


	@Override
	public void print() {
		TextualConsole console = new TextualConsole();
		String owner;
		console.print("Market\n");
		
		
		for(ActionSpace space : market){

			if(space.getOwner()!= null)
				owner = space.getOwner().getName();
			else
				owner = "Nobody";
			
			console.print("Player: " + owner + "   ");
			
			if(space.getResources()!= null)
				new TextualResourceView(space.getResources()).print();
			console.print("\n");
		}
	}

}
