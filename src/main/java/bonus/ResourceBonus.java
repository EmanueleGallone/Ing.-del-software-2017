package bonus;

import it.polimi.ingsw.resources.Resource;

public class ResourceBonus extends Bonus<Resource>{

	private static final int DEFAULT_VALUE = 1;
	private int value;
	
	public ResourceBonus(Resource target) {
		super(target);
		this.value = DEFAULT_VALUE;
	}
	
	public ResourceBonus(Resource target,int value) {
		super(target);
		this.value = value;
	}

	@Override
	public void behavior(){
		this.target.increment(value);
	}

}
