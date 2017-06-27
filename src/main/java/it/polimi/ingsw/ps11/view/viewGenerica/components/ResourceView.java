package it.polimi.ingsw.ps11.view.viewGenerica.components;

import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.view.viewGenerica.ViewComponent;

public abstract class ResourceView extends ViewComponent{
	
	protected ResourceList resourceList = new ResourceList();
	
	public void update(ResourceList resourceList){
		this.resourceList = resourceList;
	}

}
