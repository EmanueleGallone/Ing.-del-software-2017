package it.polimi.ingsw.ps11.view.textualView.components;

import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.HarvestView;

public class TextualHarvestView extends HarvestView {

	@Override
	public void print() {
		TextualConsole console = new TextualConsole();
		
		console.println("Harvest");
		Player player = harvest.getSingleActionSpace().getOwner();
		String pString = "Nobody";
		
		if (player != null)
			pString = player.getName();
		
		console.print("Single space: " + pString + " " + "\tMultiple space: ");
		
		for(ActionSpace space : harvest.getMultipleActionSpace().getAllSpace()){
			console.print(space.getOwner().getName() + " ");
		}
		
		if(harvest.getMultipleActionSpace().getAllSpace().isEmpty())
			console.println("Nobody" + "  ");
	}

}
