package it.polimi.ingsw.ps11.view.viewGenerica.components;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.zones.CouncilPalace;
import it.polimi.ingsw.ps11.view.viewGenerica.ViewComponent;

public abstract class CouncilPalaceView  extends ViewComponent{

	protected CouncilPalace councilPalace;
	protected ArrayList<Player> currentOrder = new ArrayList<>();
	
	public void update(CouncilPalace councilPalace) {
		this.councilPalace = councilPalace;
	}

	public void setCurrentOrder(ArrayList<Player> currentOrder) {
		this.currentOrder = currentOrder;
	}
	
	//public abstract void selected(); //lancera' l'evento che e' stato selezionato o un ChooseFamilyView?
	
}
