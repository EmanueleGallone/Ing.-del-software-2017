package it.polimi.ingsw.ps11.model.cards;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.effects.Effect;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/**
 * <h3>Development Card</h3>
 * <p> Classe astratta che rappresenta le carte sviluppo. Estensione della classe Card. </p> 
 * @version 1.0
 * @see it.polimi.ingsw.ps11.model.cards.list.YellowCard YellowCard
 * @see it.polimi.ingsw.ps11.model.cards.list.GreenCard GreenCard
 * @see it.polimi.ingsw.ps11.model.cards.list.BlueCard BlueCard
 * @see it.polimi.ingsw.ps11.model.cards.list.PurpleCard PurpleCard
 */
public abstract class DevelopmentCard extends Card {
	
	protected final int DEFAULT_VALUE = 1;
	protected int period;
	protected int activeValue = 0;
	
	protected ArrayList<ResourceList> costs = new ArrayList<>();

	protected ArrayList<Effect> istantEffect = new ArrayList<>();
	protected ArrayList<Effect> permanentEffect = new ArrayList<>();
	 
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
		if (costs.contains(cost) && playerResourceList.canSubtract(cost)) 
			return true;
		return false;
	}
	
	public boolean isMonoCost(){
		return (this.costs.size() > 1);
	}
	
	public int getActiveValue() {
		return activeValue;
	}
	
//	public boolean take(Player player, ResourceList cost){
//		if (checkCost(player.getResourceList(), cost)){
//			player.getResourceList().subtract(cost); //sottraggo le risorse spese per prendere la carta
//			if (player.getCardManager().addCard(this)){
//				//setOwner(player); come faccio a settare il giocatore del bonus?
//				return true;
//			}
//		}
//		
//		return false;
//	}
//	
	
// Action
	

	public ArrayList<Effect> getIstantEffect() {
		return istantEffect;
	}
	public ArrayList<Effect> getPermanentEffect() {
		return permanentEffect;
	}

	public void addIstantEffect(Effect istantEffect) {
		this.istantEffect.add(istantEffect);
	}
	
	public void addPermanentEffect(Effect permanentEffect) {
		this.permanentEffect.add(permanentEffect);
	}

// Start setters
	
	
	
	/*private void setOwner(Player player){
		for(Bonus bonus : permanentBonus){
			
			bonus.(player);
		}
		for(Bonus bonus : instantBonus){
			bonus.setOwner(player);
		}
	}*/
	
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
	
	
// End setters
	
	public int getPeriod() {
		return period;
	}
	
	@Override
	public abstract DevelopmentCard clone();
	
	@Override
	public abstract boolean equals(Object obj);
}
