package it.polimi.ingsw.ps11.cranio.malus.firstPeriod;

import it.polimi.ingsw.ps11.cranio.malus.Excommunication;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.resources.Resource;

public class EveryResourceGainMinus1 extends Excommunication {
	
	private String resourceType;
	
	public EveryResourceGainMinus1(Player player, Class<? extends Resource> resourceType) {
		this.owner = player;
		this.resourceType = resourceType.toString();
		setPeriod(1);
	}

	@Override
	public void behaviour() {
		
		//se metto un attributo Class automaticamente non posso più serializzare il giocatore;
		//ho provato anche con transient ma il metodo setResource non accetta un attributo Class
		//se facessi che setResource accetta una stringa, dovrei comunque fare una batteria di if lì dentro per specificare ogni volta quale risorsa ho passato
		
	}
	
	public String getResourceType() {
		return resourceType;
	}

}
