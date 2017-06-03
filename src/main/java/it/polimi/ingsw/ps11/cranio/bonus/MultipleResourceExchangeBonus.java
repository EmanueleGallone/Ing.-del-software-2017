package it.polimi.ingsw.ps11.cranio.bonus;

import java.util.ArrayList;
import java.util.HashMap;

import it.polimi.ingsw.ps11.cranio.resources.ResourceList;

public class MultipleResourceExchangeBonus extends Bonus {
	
	private ArrayList<ResourceList> exchanger = new ArrayList<>();
	//private ArrayList<ResourceList> exchangeable = new ArrayList<>();
	
	private HashMap<ResourceList, ResourceList> association = new HashMap<>();
	
	public MultipleResourceExchangeBonus(ResourceList exchanger, ResourceList exchangeable) {
		this.exchanger.add(exchanger);
		//this.exchangeable.add(exchangeable);
		
		association.put(exchanger, exchangeable);
	}
	
	public void addAnotherPossibility(ResourceList exchanger, ResourceList exchangeable){
		this.exchanger.add(exchanger);
		
		association.put(exchanger, exchangeable);
	}

	@Override
	public void behavior() {
		//giocatore sceglie quale risorsa scambiare e salva in sceltaGiocatore
		//getOwner().getResourceList().subtract(exchanger.get(sceltaGiocatore));
		//getOwner().getResourceList().sum(association.get(exchanger.get(sceltaGiocatore)));
		//pensavo una cosa del genere, ovviamente da raffinare
		
	}

}
