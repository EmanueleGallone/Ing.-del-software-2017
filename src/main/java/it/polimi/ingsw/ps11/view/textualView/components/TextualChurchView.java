package it.polimi.ingsw.ps11.view.textualView.components;

import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.ChurchView;

public class TextualChurchView extends ChurchView{

	@Override
	public void print() {
		TextualConsole console = new TextualConsole();
		console.println("Church");
		
		for(int i = 0; i < this.church.getMaxExcomunication(); i++){
			if (church.getExcomunications(i+1) != null) 
				console.println((i+1) + " Period: " + church.getExcomunications(i+1).getId());
		}
		
	}

}
