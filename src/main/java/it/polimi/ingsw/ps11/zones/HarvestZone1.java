package it.polimi.ingsw.ps11.zones;

import it.polimi.ingsw.player.gadgets.PersonalBoard;
import it.polimi.ingsw.resources.Resource;
import it.polimi.ingsw.resources.Stone;
import it.polimi.ingsw.resources.Wood;

public class HarvestZone1 extends Zone {
	private Resource resource1;
	private Resource resource2;
	
	public HarvestZone1(){
		resource1 = new Wood();
		resource2 = new Stone();
		setDefaultProduction();
	}
	
	//set the quantity of resources that by default Production Zone has.
	private void setDefaultProduction(){
		resource1.setValue(1);
		resource2.setValue(5);
	}
	
	 
	//(attenzione, AGGIUNGE o RIMUOVE risorse. non è un setter. guarda bene il metodo "changeResource" in PersonalBoard!
	//eventualmente è da implementare l'interfaccia Activable; devo però capire bene la sua logica. ema
	public void activate(PersonalBoard personalBoard){
		personalBoard.changeResource(resource1, resource1.getValue());
		personalBoard.changeResource(resource2, resource2.getValue());

	}

}
