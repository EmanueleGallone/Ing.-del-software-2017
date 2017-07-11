package it.polimi.ingsw.ps11.model.cards;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.cards.effects.Effect;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/**
 * <h3>Development Card</h3>
 * <p> Classe astratta che rappresenta le carte sviluppo. Estensione della classe Card. Possono essere di quattro tipi: 
 * "Territorio", "Personaggio", "Edificio", "Impresa". Contengono un ArrayList di ResourceList che rappresentano i costi tra cui i
 * giocatori possono scegliere. La carta può avere un effetto immediato e/o un effetto permanente.</p> 
 * <p>Il costruttore accetta: string (Id della carta), string (nome della carta).</p>
 * @version 1.0
 * @see Card
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

	protected ArrayList<Effect> instantEffect = new ArrayList<>();
	protected ArrayList<Effect> permanentEffect = new ArrayList<>();
	
	public DevelopmentCard(String id,String name) {
		super(id,name);
	}
	public DevelopmentCard(String id) {
		super(id);
	}
	
	
	/**
	 * <h3> ResourceList getFirstCost() </h3>
	 * <p> Ritorna la prima resourceList rappresentatnte il costo</p>
	 * @return ResourceList: la prima dell'array, se già presente, ne creauna nuova altrimenti. 
	 */
	public ResourceList getFirstCost(){
		if(costs.size()>0){
			return costs.get(0);
		}
		return new ResourceList();
	}
	
// Start Logics
	
//	/**<h3> boolean checkCost(ResourceList, ResourceList) </h3>
//	 * <p> Compara due resourceList, la prima del giocatore e la seconda della carta,  
//	 * @return true se il giocatore ha abbastanza risorse, false altrimenti </p>
//	 */
//	public boolean checkCost(ResourceList playerResourceList, ResourceList cost){
//		if (costs.contains(cost) && playerResourceList.canSubtract(cost)) 
//			return true;
//		return false;
//	}
	
	/**<h3>  isMonoCost() </h3>
	 * <p> Controlla che la carta abbia una sola resource List per il costo. </p>
	 * @return true se è solo una resource List, false altrimenti.
	 */
	public boolean isMonoCost(){
		return this.costs.size() <= 1;
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
	

	public ArrayList<Effect> getInstantEffect() {
		return instantEffect;
	}
	public ArrayList<Effect> getPermanentEffect() {
		return permanentEffect;
	}

	/**<h3> addInstantEffect(Effect) </h3>
	 * <p> Aggiunge un effetto istantaneo ad una carta </p>
	 * @see Effect
	 */
	public void addInstantEffect(Effect istantEffect) {
		this.instantEffect.add(istantEffect);
	}
	
	/**<h3> addPermanentEffect(Effect) </h3>
	 * <p> Aggiunge un'effetto permanente ad una carta </p>
	 * @see Effect
	 */
	public void addPermanentEffect(Effect permanentEffect) {
		this.permanentEffect.add(permanentEffect);
	}

// Start setters
	
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
	
	/**<h3> String toString() </h3>
	 * <p> TIPOCARTA [DEFAULT_VALUE= , activeValue= ] </p>
	 */
	public String toString(){
		return this.getClass().getSimpleName() + "[DEFAULT_VALUE=" + DEFAULT_VALUE + ", activeValue=" + activeValue + "]";
	}
	
	
	public int getPeriod() {
		return period;
	}
	
	@Override
	public abstract DevelopmentCard clone();
	/**<h3> boolean euqals(Object) </h3>
	 * <p> Compara due carte</p>
	 * @return true se sono dello stesso tipo e hanno lo stesso nome, false altrimenti
	 */
	@Override
	public abstract boolean equals(Object obj);
}
