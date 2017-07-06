package it.polimi.ingsw.ps11.model.zones;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.excommunications.Excommunication;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

/**
 * <h3> Church </h3>
 * <p> Classe che rappresenta la zona della Chiesa del gioco con le carte scomunica associate</p>
 */
public class Church {
	
	private ArrayList<Excommunication> excomunications;
	private ArrayList<ResourceList> rewards;
	
	public Church(ArrayList<Excommunication> excomunications) {
		this.excomunications = excomunications;
	}
	
	public Church(ArrayList<Excommunication> excomunications, ArrayList<ResourceList> rewards) {
		this.excomunications = excomunications;
		this.rewards = rewards;
	}
	
	public void setRewards(ArrayList<ResourceList> rewards) {
		this.rewards = rewards;
	}
	
	public ResourceList getReward(int i) {
		if(i<rewards.size())
			return rewards.get(i);
		return new ResourceList();
	}
	
	public Excommunication getExcomunications(int period) throws IllegalArgumentException {
		for(Excommunication e : excomunications){
			if(e.getPeriod() == period)
				return e;
		}
		throw new IllegalArgumentException();
	}

}
