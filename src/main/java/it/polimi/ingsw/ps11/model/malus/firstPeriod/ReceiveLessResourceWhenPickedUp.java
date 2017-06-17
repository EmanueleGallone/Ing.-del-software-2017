package it.polimi.ingsw.ps11.model.malus.firstPeriod;

import it.polimi.ingsw.ps11.model.malus.Excommunication;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.Resource;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class ReceiveLessResourceWhenPickedUp extends Excommunication {
	//vedi prime scomuniche del primo periodo
	
	private ResourceList resource = new ResourceList();
	private int counter; //serve?
	
	public ReceiveLessResourceWhenPickedUp(Player player, ResourceList resourceList) {
		this.owner = player;
		
		for(Resource list : resourceList){
			this.resource.setResource(list);
		}
		
	}

	@Override
	public void behaviour() {
		//for each risorsa presa da qualcosa (es. da ogni carta, o da uno spazio azione) incrementa il counter;
		//quando ha finito, sub le risorse dal player del valore del counter;
		
	}

}
