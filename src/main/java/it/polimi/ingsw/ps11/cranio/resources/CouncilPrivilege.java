package it.polimi.ingsw.ps11.cranio.resources;

public class CouncilPrivilege extends ResourceList {

	@Override
	public void sum(ResourceList otherResources) {
		//Deve togliere dalla propria map tutte le risorse tranne quella scelta
		super.sum(otherResources);
	}
	
}
