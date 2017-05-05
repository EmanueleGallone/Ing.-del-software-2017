package pos.cards;

import java.util.ArrayList;

import pos.players.Player;
import pos.players.ResourceList;

public class Card {
	
	private String name;
	
	private ArrayList<ResourceList> costs = new ArrayList<>();
	
	public Card(String name) {
		this.name = name;
		//E i vari parametri, periodo,colore, ecc..
	}
	
	public Card(ArrayList<ResourceList> costs){
		this.costs = costs;
	}
	
// Start Logics
	
	public void addCost(ResourceList cost){
		this.costs.add(cost);
	}
	
	public  void take(Player subject) {
		if(checkRequirements(subject)){
			//subject.getCartsManager().addCard();
			//Serve il nome specifico del metodo
		}
	}
	
	public boolean checkRequirements(Player subject){
		
		for(ResourceList cost: costs){
			if (subject.getResourceList().greater(cost)){
				return true;
			}
		}
		return false;
	}
	
//End Logics
	
	public void setCosts(ArrayList<ResourceList> costs) {
		this.costs = costs;
	}
	
}
