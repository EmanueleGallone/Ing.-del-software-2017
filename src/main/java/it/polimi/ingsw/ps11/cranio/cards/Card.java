package it.polimi.ingsw.ps11.cranio.cards;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.resources.ResourceList;

public abstract class Card{
	
	private String name; //Va visto come un identificatore unico
	private ArrayList<ResourceList> costs = new ArrayList<>();
	
	public Card() {
		//E i vari parametri, periodo,colore, ecc..
	}
	
	public Card(ResourceList cost){
		this.costs.add(cost);
	}
	
	public Card(ArrayList<ResourceList> costs){
		this.costs = costs;
	}
	
// Start Logics
	
	public void addCost(ResourceList cost){
		this.costs.add(cost);
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
	
	public String getName() {
		return name;
	}
	
	
//End getters
	
}