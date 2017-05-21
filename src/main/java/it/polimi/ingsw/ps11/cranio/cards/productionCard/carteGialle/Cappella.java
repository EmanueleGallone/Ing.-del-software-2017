package it.polimi.ingsw.ps11.cranio.cards.productionCard.carteGialle;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.bonus.IncrementResourceBonus;
import it.polimi.ingsw.ps11.cranio.cards.productionCard.ProductionCard;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.resources.list.FaithPoint;
import it.polimi.ingsw.ps11.cranio.resources.list.Wood;

public class Cappella extends ProductionCard {
	
	private ArrayList<ResourceList> costi = new ArrayList<ResourceList>();
	
	private ResourceList instantBonus;
	
	private IncrementResourceBonus bonus;
	
	public Cappella() {
		
		ResourceList temp = new ResourceList();
		temp.setAllToZeroValue();
		
		temp.setResource(new Wood(2));
		
		costi.add(temp.clone());
		
		ResourceList bonus = new ResourceList();
		bonus.setAllToZeroValue();
		bonus.setResource(new FaithPoint(1));
		
		this.bonus = new IncrementResourceBonus(bonus.clone()); //setto il bonus. SCORRETTO ANCORA
		//perchè deve implementare il fatto che per ogni moneta si ha +1 faithpoint
		
		this.activeValue = 2; //valore necessario al familiare
		
		this.instantBonus = new ResourceList();
		this.instantBonus.setAllToZeroValue();
		this.instantBonus.setResource(new FaithPoint(1));
		
		this.period = 1;
		
	}
	
	public IncrementResourceBonus getBonus() {
		return bonus;
	}
	
	@Override
	public ArrayList<ResourceList> getCosts() {
		
		return super.getCosts();
	}

}
