package it.polimi.ingsw.ps11.view.viewGenerica.components;

import it.polimi.ingsw.ps11.model.zones.Church;
import it.polimi.ingsw.ps11.view.viewGenerica.ViewComponent;

public abstract class ChurchView extends ViewComponent {

	protected Church church;
	
	public void update(Church church){
		this.church = church;
	}
	
}
