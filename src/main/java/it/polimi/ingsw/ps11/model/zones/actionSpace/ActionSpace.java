package it.polimi.ingsw.ps11.model.zones.actionSpace;

import java.io.Serializable;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/** <h3>ActionSpace</h3>
 * <p> Classe che rappresenta lo spazio azione del gioco dove e' possibile posizionare un solo familiare. Puo' avere una ResourceList
 * come bonus ricevuto o penalità da pagare al posizionamento di un familiare, e ha un costo in termini di valore del familiare.</p>
 * @see it.polimi.ingsw.ps11.model.familyMember.FamilyMember FamilyMember
 * @see it.polimi.ingsw.ps11.model.player.Player Player
 * @see it.polimi.ingsw.ps11.model.resources.ResourceList ResourceList
 *
 */
public class ActionSpace implements FamilyMemberSpace, Serializable{
	
	protected static final int DEFAULT_COST = 1;
	protected FamilyMember familyMember;
	protected Player owner;
	private int cost,penality = 0;
	private ResourceList resources = new ResourceList(); 
	
	/**<h3> ActionSpace() </h3>
	 * Costruttore per costruire un ActionSpace senza risorse e con costo = DEFAULT (1).
	 */
	public ActionSpace() {
		this(DEFAULT_COST);
	}
	
	public ActionSpace(int cost){
		this(cost,new ResourceList());
	}
	
	public ActionSpace(ResourceList resourceList){
		this.cost = DEFAULT_COST;
		this.resources = resourceList;
	}
	
	public ActionSpace(int cost, ResourceList resourceList){
		this.cost = cost;
		this.resources = resourceList;
	}
	
	/**
	 * <h3>public boolean isFree()</h3>
	 * <p> Indica è possibile piazzare un familiare o meno.</p>
	 * @return true se lo spazio azione è vuoto, false altrimenti.
	 */
	public boolean isFree(){
		if (familyMember == null && owner == null)
			return true;
		return false;
	}
	
	/**<h3> void placeFamilyMember(FamilyMember, Player) </h3>
	/** <p> Setta il valore delle variabili familymember e player con i valori che vengono passati al metodo</p>
	 */
	@Override
	public void placeFamilyMember(FamilyMember familyMember, Player player) {
		this.familyMember = familyMember;
		this.owner = player;
		this.familyMember.setUsed(true);
	}

	@Override
	public void clean() {
		if(familyMember!=null)
			familyMember.setUsed(false);
		familyMember = null;
		owner = null;
	}
	
	public int getPenality() {
		return penality;
	}
//Start setters
	
	public void setResources(ResourceList resourceList){
		this.resources = resourceList;
	}

// Getters
	
	public void setPenality(int penality) {
		this.penality = penality;
	}
	
	public int getActionCost() {
		return cost;
	}
	
	public Player getOwner() {
		return owner;
	}
	public ResourceList getResources() {
		return resources;
	}
	
	public FamilyMember getFamilyMember() {
		return familyMember;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(obj.getClass().equals(this.getClass())){
			ActionSpace aSpace = (ActionSpace) obj;
			boolean result = aSpace.getActionCost() == this.getActionCost();
			if(aSpace.familyMember != null)
				result = result && aSpace.familyMember.equals(this.familyMember);
			if(aSpace.owner != null)
				result = result && aSpace.owner.equals(this.owner);
			return result && aSpace.resources.equals(this.resources);
	
		}
		return false;
	}

	
	@Override
	public ActionSpace clone(){
		ActionSpace clone = new ActionSpace();
		
		if(this.familyMember == null) 
			clone.familyMember = null;
		else 
			clone.familyMember = this.familyMember.clone();
		
		if(this.owner == null)
			clone.owner = null;
		else
			clone.owner = this.owner.clone();
		
		clone.cost = this.cost;
		clone.resources = this.resources.clone();
		
		return clone;
	}


}
