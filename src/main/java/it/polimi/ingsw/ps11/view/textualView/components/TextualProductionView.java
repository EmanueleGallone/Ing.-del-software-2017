package it.polimi.ingsw.ps11.view.textualView.components;

import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.ProductionView;

public class TextualProductionView extends ProductionView {

	@Override
	public void print() {
		TextualConsole console = new TextualConsole();
		
		console.println("Production");
		Player player = production.getSingleActionSpace().getOwner();
		String pString = "Nobody";
		if (player != null){
			pString = player.getName();
		}
		console.println("Single space: " + pString + " " + "\tMultiple space: ");
		for(ActionSpace space : production.getMultipleActionSpace().getAllSpace()){
			console.print(space.getOwner().getName() + " ");
		}
	}
}