package gioco.da.console;

import gioco.da.console.cards.YellowCard;
import gioco.da.console.resources.Resource;
import gioco.da.console.resources.Stone;

public class DecoratedYellowCard extends YellowCard {
	private YellowCard yellowCard;
	private Resource type;
	
	//testing decorator per una yellowCard. aumento la stone di 5
	
	public DecoratedYellowCard(YellowCard card){
		this.yellowCard = card;
		this.name = "decorated!";
		this.type = new Stone();
		this.type.setValue(5);
	}

	@Override
	public String toString() {
		return "DecoratedYellowCard [" + ", name=" + name + ", type="
				+ type + "]\n";
	}
	
	

}
