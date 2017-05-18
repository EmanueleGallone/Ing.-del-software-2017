package it.polimi.ingsw.ps11.cranio.cards;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.bonus.Bonus;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;

public abstract class DevelopmentCard extends Card {

	private String name; 
	private ArrayList<ResourceList> costs = new ArrayList<>();
	
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
	
	public void addCost(ResourceList cost){
		this.costs.add(cost);
	}
	
	private void setOwner(Player player){
		for(Bonus bonus : permanentBonus){
			bonus.setOwner(player);
		}
	}
	
	public boolean checkCost(ResourceList playerResourceList, ResourceList cost){
		if (costs.contains(cost) && playerResourceList.greater(cost))
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
}
