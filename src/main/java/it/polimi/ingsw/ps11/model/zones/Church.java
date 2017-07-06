package it.polimi.ingsw.ps11.model.zones;

import java.util.ArrayList;
import java.util.HashMap;

import it.polimi.ingsw.ps11.model.excommunications.Excommunication;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.FaithPoint;
import it.polimi.ingsw.ps11.model.resources.list.VictoryPoint;

/**
 * <h3> Church </h3>
 * <p> Classe che rappresenta la zona della Chiesa del gioco con le carte scomunica associate</p>
 */
public class Church {
	
	private ArrayList<Excommunication> excomunications;
	private HashMap<Integer, ResourceList> requirements = new HashMap<>();
	private HashMap<Integer, ResourceList> rewards = new HashMap<>();
	
	public Church(ArrayList<Excommunication> excomunications) {
		this.excomunications = excomunications;
	}
	
	public void addRewards(int cell, ResourceList reward) {
		this.rewards.put(cell, reward);
	}
	
	public void addRequirement(int period, ResourceList reward) {
		this.rewards.put(period, reward);
	}
	
	public ResourceList getReward(int i) {
		return rewards.get(i);
	}
	
	public ResourceList getRequirements(int period) {
		return requirements.get(period);
	}
	
	public Excommunication getExcomunications(int period) throws IllegalArgumentException {
		for(Excommunication e : excomunications){
			if(e.getPeriod() == period)
				return e;
		}
		throw new IllegalArgumentException();
	}
	
	
	
	//Salvataggio su file
	
//	
//	public static void main(String[] args) {
//		Church church = new Church(new ArrayList<>());
//		
//		church.addRequirement(1,new ResourceList(new FaithPoint(3)));
//		church.addRequirement(2,new ResourceList(new FaithPoint(4)));
//		church.addRequirement(3,new ResourceList(new FaithPoint(5)));
//		
//		
//		for(int i = 0; i < 5; i++){
//			church.addRequirement(i, new ResourceList(new VictoryPoint(i)));
//		}
//		
//		int c = 1;
//		for(int i = 6; i < 15; i++){
//			church.addRequirement(i, new ResourceList(new VictoryPoint(i+c)));
//			c++;
//		}
//		
//	}
	
}
