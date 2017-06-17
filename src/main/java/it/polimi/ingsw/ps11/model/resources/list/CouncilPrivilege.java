package it.polimi.ingsw.ps11.model.resources.list;

import it.polimi.ingsw.ps11.model.resources.Resource;

public class CouncilPrivilege extends Resource {
	//come la facciamo?
	
	public CouncilPrivilege(int value) {
		super(value);
	}
	
	public CouncilPrivilege() {
		super(DEFAULT);
	}

	@Override
	public CouncilPrivilege clone() {
		return new CouncilPrivilege(this.value);
	}
	

}
