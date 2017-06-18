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
		if (player == null)
			player.setName("nobody");
		console.print("Single space: " + player.getName()+ " " + "Multiple space: ");
		for(ActionSpace space : harvest.getMultipleActionSpace().getAllSpace()){
			console.print(space.getOwner().getName() + " ");
		}
	}

}
