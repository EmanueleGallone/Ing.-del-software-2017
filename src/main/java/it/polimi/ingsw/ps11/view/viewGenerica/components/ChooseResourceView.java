package it.polimi.ingsw.ps11.view.viewGenerica.components;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.view.viewGenerica.ViewComponent;

public abstract class ChooseResourceView extends ViewComponent {

	protected ArrayList<ResourceList> costs = new ArrayList<>();
	
	public void update(ArrayList<ResourceList> costs){
		this.costs = costs;
	}
	
}
