package it.polimi.ingsw.ps11.cranio.cards;

import java.util.ArrayList;

import pos.bonus.Bonus;
import pos.games.Player;
import pos.interfaceList.Activable;
import pos.resources.ResourceList;

public abstract class Card implements Activable {
	
	private String name; //Va visto come un identificatore unico
	private ArrayList<ResourceList> costs = new ArrayList<>();
	private ArrayList<Bonus> instantBonus = new ArrayList<Bonus>();
	private ArrayList<Bonus> permanentBonus = new ArrayList<Bonus>();
	
	
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
	public void setInstantBonus(ArrayList<Bonus> instantBonus) {
		this.instantBonus = instantBonus;
	}

	public void setPermanentBonus(ArrayList<Bonus> permanentBonus) {
		this.permanentBonus = permanentBonus;
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

	public ArrayList<Bonus> getInstantBonus() {
		return instantBonus;
	}

	public ArrayList<Bonus> getPermanentBonus() {
		return permanentBonus;
	}
	
//End getters
	
}