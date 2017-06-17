package it.polimi.ingsw.ps11.view.viewGenerica.components;

import it.polimi.ingsw.ps11.model.zones.CouncilPalace;
import it.polimi.ingsw.ps11.view.viewGenerica.ViewComponent;

public abstract class CouncilPalaceView  extends ViewComponent{

	private CouncilPalace councilPalace;
	
	public void update(CouncilPalace councilPalace) {
		this.councilPalace = councilPalace;
	}
	
}
