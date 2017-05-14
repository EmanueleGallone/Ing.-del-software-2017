package provaGab.cranio.cards;

import java.util.ArrayList;

import provaGab.cranio.player.Player;
import provaGab.cranio.resources.ResourceList;


public abstract class DevelopmentCard extends Card {

	private String name; 
	private ArrayList<ResourceList> costs = new ArrayList<>();
	protected static int id;
	
	public DevelopmentCard() {
		this.id = 0;
		//E i vari parametri, periodo,colore, ecc..
	}
	
	public DevelopmentCard(ResourceList cost){
		this.costs.add(cost);
	}
	
	public DevelopmentCard(ArrayList<ResourceList> costs){
		this.costs = costs;
	}
	
// Start Logics
	
	public void addCost(ResourceList cost){
		this.costs.add(cost);
	}
	
	public boolean take(Player player){
		for(ResourceList r: costs){
			if(r.greater(player.getResources())){
				this.insertCard(player);
				return true;
			}
		}
		
		return false;
	}
	
	protected abstract void insertCard(Player player);
	
	
//End Logics
	
	public static int getId() {
		return id;
	}
}
