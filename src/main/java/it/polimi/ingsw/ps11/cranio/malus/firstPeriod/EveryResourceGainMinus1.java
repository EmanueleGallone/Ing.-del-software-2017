package it.polimi.ingsw.ps11.cranio.malus.firstPeriod;

import it.polimi.ingsw.ps11.cranio.malus.Excommunication;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.resources.Resource;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.resources.list.Coin;
import it.polimi.ingsw.ps11.cranio.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.cranio.resources.list.Servant;
import it.polimi.ingsw.ps11.cranio.resources.list.Stone;
import it.polimi.ingsw.ps11.cranio.resources.list.Wood;

public class EveryResourceGainMinus1 extends Excommunication {
	
	private String resourceType;
	
	public EveryResourceGainMinus1(Player player, Class<? extends Resource> resourceType) {
		this.owner = player;
		this.resourceType = resourceType.toString();
		setPeriod(1);
	}

	@Override
	public void behaviour() {
		ResourceList resourceList = new ResourceList();
		//se metto un attributo Class automaticamente non posso più serializzare il giocatore;
		//ho provato anche con transient ma il metodo setResource non accetta un attributo Class
		//se facessi che setResource accetta una stringa, dovrei comunque fare una batteria di if lì dentro per specificare ogni volta quale risorsa ho passato
		
		if(this.resourceType.equalsIgnoreCase("class it.polimi.ingsw.ps11.cranio.resources.list.Coin.class")){
			resourceList.setResource(new Coin(1));
		}
		
		if(this.resourceType.equalsIgnoreCase("class it.polimi.ingsw.ps11.cranio.resources.list.Wood.class")){
			resourceList.setResource(new Wood(1));
		}
		
		if(this.resourceType.equalsIgnoreCase("class it.polimi.ingsw.ps11.cranio.resources.list.Stone")){
			System.out.println("sono nella if");
			resourceList.setResource(new Stone(1));
		}
		
		if(this.resourceType.equalsIgnoreCase("class it.polimi.ingsw.ps11.cranio.resources.list.Servant.class")){
			resourceList.setResource(new Servant(1));
		}
		
		if(this.resourceType.equalsIgnoreCase("class it.polimi.ingsw.ps11.cranio.resources.list.MilitaryPoint.class")){
			resourceList.setResource(new MilitaryPoint(1));
		}
		
		this.owner.getResourceList().subtract(resourceList);
		
	}
	
	public String getResourceType() {
		return resourceType;
	}

}
