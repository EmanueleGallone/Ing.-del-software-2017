package gioco.da.console.zones;

import gioco.da.console.Player;
import gioco.da.console.resources.Servant;

public class ServantGenerator extends Zone {
	//a posto! non necessita di modifiche
	private ActionSpace actionSpace;
	
	public ServantGenerator(){
		actionSpace = new ActionSpace(new Servant(), 5,1);
		
	}
	
	public void activate(Player player){
		actionSpace.setSlot(player.familiarChoice());//faccio scegliere il familiare e lo salvo nell'Action Space
		
		player.changeResourceValue(actionSpace.getResource1(), actionSpace.getResource1().getValue()); //aggiungo le risorse al giocatore
		actionSpace.setOccupied(true); //occupo lo spazio azione
	}
	
	public boolean isOccupied(){
		return actionSpace.isOccupied();
	}
	
	public void setOccupied(boolean value){
		actionSpace.setOccupied(value);
	}

}