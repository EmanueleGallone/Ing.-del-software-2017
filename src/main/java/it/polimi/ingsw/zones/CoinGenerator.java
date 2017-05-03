package it.polimi.ingsw.zones;

import gioco.da.console.Player;
import it.polimi.ingsw.resources.Coin;

public class CoinGenerator extends Zone {
	//a posto non necessita di modifiche
	private ActionSpace actionSpace;
	
	public CoinGenerator(){
		actionSpace = new ActionSpace(new Coin(), 5);
	}
	
	public void activate(Player player){
		actionSpace.setSlot(player.familiarChoice()); //occupo lo spazio azione con un familiare scelto dal giocatore!
		
		player.changeResourceValue(actionSpace.getResource1(), actionSpace.getResource1().getValue());
		actionSpace.setOccupied(true);
	}
	
	public boolean isOccupied(){
		return actionSpace.isOccupied();
	}
	
	public void setOccupied(boolean value){
		actionSpace.setOccupied(value);
	}

}
