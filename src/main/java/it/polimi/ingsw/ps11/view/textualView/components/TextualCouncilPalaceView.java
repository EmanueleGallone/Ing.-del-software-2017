package it.polimi.ingsw.ps11.view.textualView.components;

import it.polimi.ingsw.ps11.model.zones.CouncilPalace;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.CouncilPalaceView;
/**
 * <h3> TextualCouncilPalaceView</h3>
 * <p> Classe per la visualizzazione testuale del palazzo del consiglio del gioco e i familiari in esso posizionati.</p>
 * @see CouncilPalaceView
 */
public class TextualCouncilPalaceView extends CouncilPalaceView{
	
	public TextualCouncilPalaceView(CouncilPalace councilPalace) {
		update(councilPalace);
	}
	
	public TextualCouncilPalaceView() {
	
	}

	@Override
	public void print() {
		TextualConsole console = new TextualConsole();
		
		console.println("Council Palace");
		console.print( "Player: ");
		for(ActionSpace space : councilPalace.getAllSpace()){
			console.print( space.getOwner().getName() + "   ");
		}
		
		if(councilPalace.getAllSpace().isEmpty())
			console.println("Nobody");
		
		console.print("\n");
	}

}
