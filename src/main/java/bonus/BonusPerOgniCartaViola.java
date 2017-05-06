package bonus;

import gioco.da.console.Player;

public class BonusPerOgniCartaViola<RESOURCE_TYPE> extends Bonus<Player>{

	private static final int DEFAULT_VALUE = 1;
	private int value;
	
	public BonusPerOgniCartaViola(Player target) {
		super(target);
		this.value = DEFAULT_VALUE;
	}
	
	public BonusPerOgniCartaViola(Player target,int value) {
		super(target);
		this.value = value;
	}

	@Override
	public void behavior(){
		int tot = 0;
		//tot = target.numeroCarteViola;
		for(int i = 0; i < tot; i++){
			
		}
	}
	
}
