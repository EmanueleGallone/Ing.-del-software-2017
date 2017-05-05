package pos.cards;

import java.util.ArrayList;

import pos.players.Player;
import pos.players.ResourceManager;

public class Card {
	
	private String name;
	
	private ArrayList<ResourceManager> costs = new ArrayList<>();
	
	public Card(String name) {
		this.name = name;
		//E i vari parametri, periodo,colore, ecc..
	}
	
	public Card(ArrayList<ResourceManager> costs){
		this.costs = costs;
	}
	
// Start Logics
	
	public void addCost(ResourceManager cost){
		this.costs.add(cost);
	}
	
	public  void take(Player subject) {
		if(checkRequirements(subject)){
			//subject.getCartsManager().addCard();
			//Serve il nome specifico del metodo
		}
	}
	
	public boolean checkRequirements(Player subject){
		
		for(ResourceManager cost: costs){
			if (subject.getResourceManager().greater(cost)){
				return true;
			}
		}
		return false;
	}
	
//End Logics
	
	public void setCosts(ArrayList<ResourceManager> costs) {
		this.costs = costs;
	}
	
}
