package it.polimi.ingsw.ps11.model.zones.actionSpace;

import java.io.Serializable;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/**
 * <h3>ActionSpace</h3>
 * <p> Classe che rappresenta lo spazio azione del gioco dove e' possibile posizionare il familiare. Puo' avere delle risorse o meno. </p>
 * @see it.polimi.ingsw.ps11.model.familyMember.FamilyMember FamilyMember
 * @see it.polimi.ingsw.ps11.model.player.Player Player
 * @see it.polimi.ingsw.ps11.model.resources.ResourceList ResourceList
 *
 */
public class ActionSpace implements FamilyMemberSpace, Serializable{
	
	protected static final int DEFAULT_COST = 1;
	protected FamilyMember familyMember;
	protected Player owner;
	private int cost;
	private ResourceList resources; 
	
	/**
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
	 * <p> Permette di stabilire se è possibile piazzare un familiare o meno.</p>
	 * @return true se lo spazio azione è vuoto, false altrimenti.
	 */
	public boolean isFree(){
		if (familyMember == null)
			return true;
		return false;
	}
	
	@Override
	public boolean placeFamilyMember(FamilyMember familyMember, Player player) {
		if(isFree()){ //non viene fatto il controllo sul valore del familiare ed il cost dello spazio azione
			this.familyMember = familyMember;
			this.owner = player;
			return true; //manca poi l'assegnamento delle risorse al giocatore che ha piazzato
		}
		return false;
	}

//Start setters
	
	public void setResources(ResourceList resourceList){
		this.resources = resourceList;
	}

// Getters
	
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
	public ActionSpace clone(){
		ActionSpace clone = new ActionSpace();
		
		if(this.familyMember == null) //necessario, altrimenti se l'actionspace non ha il familiare, la clone lancia eccezione
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
