package it.polimi.ingsw.ps11.cranio.zones.HarvestAndProduction;

import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.resources.list.Coin;
import it.polimi.ingsw.ps11.cranio.resources.list.FaithPoint;
import it.polimi.ingsw.ps11.cranio.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.cranio.resources.list.Servant;
import it.polimi.ingsw.ps11.cranio.resources.list.Stone;
import it.polimi.ingsw.ps11.cranio.resources.list.VictoryPoint;
import it.polimi.ingsw.ps11.cranio.resources.list.Wood;
import it.polimi.ingsw.ps11.cranio.zones.actionSpace.ActionSpace;

public class Harvest extends CardAttivator {
	
	private ResourceList resourceList = new ResourceList();
	private ActionSpace actionSpace;

	public Harvest() {
		
		resourceList.setResource(new Stone(0));
		resourceList.setResource(new Wood(0));
		resourceList.setResource(new Coin(0));
		resourceList.setResource(new Servant(0));
		resourceList.setResource(new MilitaryPoint(0));
		resourceList.setResource(new FaithPoint(0));
		resourceList.setResource(new VictoryPoint(0));
		
	}
	
	public void activeHarvest(Player player){
		
		//per ogni carta verde, aggiungi i valori di incremento nella resource list;
		//poi fai un check di quali bonus possano essere attivati
		
	}

	@Override
	public String toString() {
		return "Harvest [resourceList=" + resourceList + "]";
	}

	/*
	@Override
	protected void activeCard(FamilyMember familyMember) {
		CardManager cardManager = familyMember.getOwner().getCardManager();
		for(GreenCard card : cardManager.getCard(GreenCard.class)){
			if (card.getActiveValue() > familyMember.getValue()){
				card.enablePermanentBonus();
			}
		}
	}
	*/
	
	
}
