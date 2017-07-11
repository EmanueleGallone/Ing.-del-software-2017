package it.polimi.ingsw.ps11.model.zones;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import it.polimi.ingsw.ps11.model.excommunications.Excommunication;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

/**
 * <h3> Church </h3>
 * <p> Classe che rappresenta la zona della Chiesa del gioco con le carte scomunica associate. La church richiede un quantitativo minimo di 
 * Faith Point per non assegnare la scomunica del round al giocatore. Associa ad ogni numero di FaithPoint una resourceList che rappresenta
 * i punti Vittoria acquisiti. </p>
 */
public class Church implements Serializable {
	
	private final int MAX_EXCOMUNICATION = 3;
	
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
		this.requirements.put(period, reward);
	}
	
	public ResourceList getReward(int i) {
		return rewards.get(i);
	}
	
	public ResourceList getRequirements(int period) {
		return requirements.get(period);
	}
	
	public boolean addExcomunication(Excommunication e) {
		Excommunication temp = this.getExcomunications(e.getPeriod());
		if(temp == null && excomunications.size() <= MAX_EXCOMUNICATION){
			this.excomunications.add(e);
			return true;
		}
		return false;
	}
	
	public Excommunication getExcomunications(int period){
		for(Excommunication e : excomunications){
			if(e.getPeriod() == period)
				return e;
		}
		return null;
	}
	
	public int getMaxExcomunication() {
		return MAX_EXCOMUNICATION;
	}
	
	//Salvataggio su file
	
	
//	public static void main(String[] args) {
//		Church church = new Church(new ArrayList<>());
//		
//		church.addRequirement(1,new ResourceList(new FaithPoint(3)));
//		church.addRequirement(2,new ResourceList(new FaithPoint(4)));
//		church.addRequirement(3,new ResourceList(new FaithPoint(5)));
//		
//		
//		for(int i = 0; i <= 5; i++){
//			church.addRewards(i, new ResourceList(new VictoryPoint(i)));
//		}
//		
//		int c = 1;
//		for(int i = 6; i <= 12; i++){
//			church.addRewards(i, new ResourceList(new VictoryPoint(i+c)));
//			c++;
//		}
//		
//		church.addRewards(13, new ResourceList(new VictoryPoint(22)));
//		church.addRewards(14, new ResourceList(new VictoryPoint(25)));
//		church.addRewards(15, new ResourceList(new VictoryPoint(30)));
//		
//		new Loader(FileRegistry.church).write(church);
//	}
//	
}
