package gioco.da.console;

import it.polimi.cards.YellowCard;
import it.polimi.ingsw.resources.Resource;
import it.polimi.ingsw.resources.Stone;

public class DecoratedYellowCard extends YellowCard {
	//private YellowCard yellowCard;
	private String name = "decorated!";
	private Resource type;
	
	//testing decorator per una yellowCard. aumento la stone di 5
	
	public DecoratedYellowCard(YellowCard card){
		//this.yellowCard = card;
		this.type = new Stone();
		this.type.setValue(5);
	}

	@Override
	public String toString() {
		return "DecoratedYellowCard [" + ", name=" + name + ", +  type="
				+ type + "]\n";
	}
	
	

}
