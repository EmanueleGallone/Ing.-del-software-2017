package pos.cards;

import java.util.ArrayList;

import pos.games.Player;
import pos.interfaceList.Activable;
import pos.resources.ResourceList;

public class Card implements Activable {
	
	private String name; //Va visto come un identificatore unico
	private Cards type;
	private ArrayList<ResourceList> costs = new ArrayList<>();
	
	public Card(Cards type) {
		this.type = type;
		//E i vari parametri, periodo,colore, ecc..
	}
	
	public Card(Cards type,ResourceList cost){
		this(type);
		this.costs.add(cost);
	}
	
	public Card(Cards type,ArrayList<ResourceList> costs){
		this(type);
		this.costs = costs;
	}
	
// Start Logics
	
	public void addCost(ResourceList cost){
		this.costs.add(cost);
	}
	
	public void take(Player subject) {
		
		if(checkRequirements(subject)){
			subject.getCartsManager().addCard(this);
		}
	}
	
	public boolean checkRequirements(Player subject){
		for(ResourceList cost: costs){
			if (subject.getResourceList().greaterThen(cost)){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void active() {
		// TODO Auto-generated method stub
	}
	
//End Logics

//Start setters
	
	public void setCosts(ArrayList<ResourceList> costs) {
		this.costs = costs;
	}
	public void setName(String name) {
		this.name = name;
	}
	
//End setters
//Start getters
	public ArrayList<ResourceList> getCosts() {
		return costs;
	}
	public Cards getType() {
		return type;
	}
	public String getName() {
		return name;
	}
//End getters
	
}
