package it.polimi.ingsw.ps11.view.viewEvents;

import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class ResourceSelectedEvent extends ViewEvent {

	private ResourceList resourceList;
	
	public ResourceSelectedEvent(ResourceList resourceList) {
		this.resourceList = resourceList;
	}
	
	public ResourceList getResourceList() {
		return resourceList;
	}
	
	@Override
	public void accept(ViewListener listener) {
		listener.handle(this);
	}

}
