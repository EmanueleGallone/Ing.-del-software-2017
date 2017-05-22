package it.polimi.ingsw.ps11.cranio.cards.productionCard.carteGialle;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.bonus.IncrementResourceBonus;
import it.polimi.ingsw.ps11.cranio.cards.productionCard.ProductionCard;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.resources.list.Coin;
import it.polimi.ingsw.ps11.cranio.resources.list.Stone;
import it.polimi.ingsw.ps11.cranio.resources.list.VictoryPoint;

public class Residenze extends ProductionCard {
	
	private ArrayList<ResourceList> costi = new ArrayList<ResourceList>();
	private IncrementResourceBonus bonus;
	private ResourceList instantBonus = new ResourceList();
	
	public Residenze() {
		ResourceList temp = new ResourceList();
		temp.setResource(new Stone(2));
		
		costi.add(temp.clone()); // aggiungo la Resource list all'array di costi
		
		
		
		instantBonus.setResource(new VictoryPoint(1));
		
		ResourceList bonusResourceList = new ResourceList();
		bonusResourceList.setResource(new Coin(1)); //ERRATO! dovrebbe dare il favore del consiglio; lo mettiamo tra le risorse?
		
		bonus = new IncrementResourceBonus(bonusResourceList);
		
		this.activeValue = 1;
		this.period = 1;
	}

}
