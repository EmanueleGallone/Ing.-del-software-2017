package it.polimi.ingsw.ps11.model.player;

import java.io.Serializable;
import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.cards.CardManager;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMemberManager;
import it.polimi.ingsw.ps11.model.game.Colors;
import it.polimi.ingsw.ps11.model.resources.Resource;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

/**<h3>Player</h3>
 * <p>Classe che rappresenta il giocatore. Esso è composito da piu' oggetti in modo da suddividere la complessita':<ul>
 * <code><b>CardManager</b></code>: permette di raccogliere in un'unica classe tutte le carte che il giocatore possiede.
 * <br><code><b>ResourceList</b></code>: container di tutte le risorse del giocatore.
 * <br><code><b>FamilyMemberManager</b></code>: container dei familiare che possono essere usati dal giocatore.</ul> 
 * </p>
 * @version 1.0
 * @see it.polimi.ingsw.ps11.model.familyMember.FamilyMemberManager FamilyMemberManager
 * @see it.polimi.ingsw.ps11.model.resources.ResourceList ResourceList
 * @see it.polimi.ingsw.ps11.model.cards.CardManager CardManager
 */
public class Player implements Serializable{
	
	private static final String DEFAULT_NAME = "Predefinito";
	
	private String name;
	private Colors color;
	
	private ResourceList resourceList;
	private FamilyMemberManager familyManager;
	private CardManager cardManager;
	
	
// Start constructors
	
	public Player(){
		name = DEFAULT_NAME;
		this.resourceList = new ResourceList();
		this.cardManager = new CardManager();
		this.familyManager = new FamilyMemberManager();
	}
	
	public Player( ArrayList<Resource> resources ) {
		
		name = DEFAULT_NAME;
		
		this.resourceList = new ResourceList(resources);
		this.cardManager = new CardManager();
		this.familyManager = new FamilyMemberManager();
	}

	
// Start getters
	
	public ResourceList getResourceList() {
		return resourceList;
	}
	
	public CardManager getCardManager() {
		return cardManager;
	}
	
	public FamilyMemberManager getFamilyManager() {
		return familyManager;
	}
	
	public String getName() {
		return name;
	}
	
	public Colors getColor() {
		return color;
	}
	
// End getters
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setColor(Colors color) {
		this.color = color;
	}
	
	@Override
	public Player clone(){
		Player clone = new Player();
		
		clone.resourceList = this.resourceList.clone();
		clone.familyManager = this.familyManager.clone();
		clone.cardManager = this.cardManager.clone();
		
		return clone;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		
		if(this.getClass() == obj.getClass()){
			return((Player)obj).getName() == this.getName();
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Player [name=" + name 
				+"\n resourceList=" + resourceList +"\n"
				+"\n familyManager=" + familyManager +"\n"
				+ "\n cardManager=" + cardManager + "\n" 
				+ "]";
	}
}