package it.polimi.ingsw.ps11.cranio.resources.list;

import it.polimi.ingsw.ps11.cranio.resources.Resource;

public class CouncilPrivilege extends Resource {
	//come la facciamo?
	
	public CouncilPrivilege(int value) {
		super(value);
	}
	
	public CouncilPrivilege() {
		super(DEFAULT);
	}
	
	private CouncilPrivilege(CouncilPrivilege toCopy){
		super(toCopy.value);
	}

	@Override
	public CouncilPrivilege clone() {
		return new CouncilPrivilege(this);
	}
	

}
