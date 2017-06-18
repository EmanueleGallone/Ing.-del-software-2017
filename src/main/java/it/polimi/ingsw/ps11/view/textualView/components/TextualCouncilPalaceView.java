package it.polimi.ingsw.ps11.view.textualView.components;

import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.CouncilPalaceView;

public class TextualCouncilPalaceView extends CouncilPalaceView{

	@Override
	public void print() {
		TextualConsole console = new TextualConsole();
		
		console.println("Council Palace");
		for(ActionSpace space : councilPalace.getAllSpace()){
			console.print( space.getOwner().getName() + "   ");
		}
	}

}
