package it.polimi.ingsw.ps11.cranio.cards;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.bonus.Bonus;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;

public abstract class DevelopmentCard extends Card {
	
	private ArrayList<ResourceList> costs = new ArrayList<>();

	protected ArrayList<Bonus> istantBonus = new ArrayList<>();
	protected ArrayList<Bonus> permanentBonus = new ArrayList<>();

	public DevelopmentCard() {
		//E i vari parametri, periodo,colore, ecc..
	}
	
	public DevelopmentCard(ResourceList cost){
		this.costs.add(cost);
	}
	
	public DevelopmentCard(ArrayList<ResourceList> costs){
		this.costs = costs;
	}
	
// Start Logics
	
	public boolean checkCost(ResourceList playerResourceList, ResourceList cost){
		if (costs.contains(cost) && playerResourceList.greaterEquals(cost))
			return true;
		return false;
	}
	
	public boolean take(Player player, ResourceList cost){
		if (checkCost(player.getResourceList(), cost)){
			if (player.getCardManager().addCard(this)){
				setOwner(player);
				return true;
			}
		}
		return false;
	}
	
	public void enablePermanentBonus(){
		for(Bonus bonus: permanentBonus){
			bonus.behavior();
		}
	}
	
//End Logics
	
// Start setters
	
	public void addIstantBonus(Bonus bonus){
		this.istantBonus.add(bonus);
	}
	
	public void addPermanentBonus(Bonus bonus){
		//this.istantBonus.add(bonus);
	}
	
	private void setOwner(Player player){
		for(Bonus bonus : permanentBonus){
			bonus.setOwner(player);
		}
	}
	
	public void setIstantBonus(ArrayList<Bonus> istantBonus) {
		this.istantBonus = istantBonus;
	}
	
	public void setPermanentBonus(ArrayList<Bonus> permanentBonus) {
		this.permanentBonus = permanentBonus;
	}
	
	public void addCost(ResourceList cost){
		this.costs.add(cost);
	}
	public void setCosts(ArrayList<ResourceList> costs) {
		this.costs = costs;
	}
	public ArrayList<ResourceList> getCosts() {
		return costs;
	}
	public ArrayList<Bonus> getIstantBonus() {
		return istantBonus;
	}
	public ArrayList<Bonus> getPermanentBonus() {
		return permanentBonus;
	}
// End setters
	
	@Override
	public abstract DevelopmentCard clone();
}
