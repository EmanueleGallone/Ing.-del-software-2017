package it.polimi.ingsw.ps11.model.cards;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.bonus.Bonus;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/**
 * <h3>Development Card</h3>
 * <p> Classe astratta che rappresenta le carte sviluppo. Estensione della classe Card. </p> 
 *
 */
public abstract class DevelopmentCard extends Card {
	
	protected final int DEFAULT_VALUE = 1;
	protected int period;
	
	protected ArrayList<ResourceList> costs = new ArrayList<>();

	protected ArrayList<Bonus> instantBonus = new ArrayList<>(); 
	protected ArrayList<Bonus> permanentBonus = new ArrayList<>();
	
	public DevelopmentCard() {
	
	}
	
	public DevelopmentCard(String name) {
		super(name);
	}
	
	public DevelopmentCard(ResourceList cost){
		this.costs.add(cost);
	}
	
	public DevelopmentCard(ArrayList<ResourceList> costs){
		this.costs = costs;
	}
	
// Start Logics
	
	public boolean checkCost(ResourceList playerResourceList, ResourceList cost){
		if (playerResourceList.greaterEquals(cost)) 
			return true;
		
		return false;
	}
	
	public boolean take(Player player, ResourceList cost){
		if (checkCost(player.getResourceList(), cost)){
			player.getResourceList().subtract(cost); //sottraggo le risorse spese per prendere la carta
			if (player.getCardManager().addCard(this)){
				//setOwner(player); come faccio a settare il giocatore del bonus?
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
	
	public void enableInstantBonus(){
		for(Bonus bonus : instantBonus){
			bonus.behavior();
		}
	}
	
//End Logics
	
// Start setters
	
	public void addInstantBonus(Bonus bonus){
		this.instantBonus.add(bonus);
	}
	
	public void addPermanentBonus(Bonus bonus){
		this.permanentBonus.add(bonus);

	}
	
	/*private void setOwner(Player player){
		for(Bonus bonus : permanentBonus){
			
			bonus.(player);
		}
		for(Bonus bonus : instantBonus){
			bonus.setOwner(player);
		}
	}*/
	
	public void setInstantBonus(ArrayList<Bonus> istantBonus) {
		this.instantBonus = istantBonus;
	}
	
	public void setPermanentBonus(ArrayList<Bonus> permanentBonus) {
		this.permanentBonus = permanentBonus;
	}
	
	public void setPeriod(int period) {
		this.period = period;
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
		return instantBonus;
	}
	public ArrayList<Bonus> getPermanentBonus() {
		return permanentBonus;
	}
	
	
// End setters
	
	public int getPeriod() {
		return period;
	}
	
	
	
	@Override
	public abstract DevelopmentCard clone();
	
	@Override
	public abstract boolean equals(Object obj);
}
