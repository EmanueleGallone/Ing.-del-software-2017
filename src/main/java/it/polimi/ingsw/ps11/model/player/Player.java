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
@SuppressWarnings("serial")
public class Player implements Serializable{
	
	private static final String DEFAULT_NAME = "Predefinito";
	
	private String name;
	private Colors color;
	
	private ResourceList resourceList;
	private FamilyMemberManager familyManager;
	private CardManager cardManager;
	
	
// Start constructors
	
	public Player(){
		this(DEFAULT_NAME);
	}
	
	public Player(String name){
		this.name = name;
		this.resourceList = new ResourceList();
		this.cardManager = new CardManager();
		this.familyManager = new FamilyMemberManager();
	}
	
	public Player( ArrayList<Resource> resources , FamilyMemberManager familyManager) {
		
		name = DEFAULT_NAME;
		
		this.resourceList = new ResourceList(resources);
		this.cardManager = new CardManager();
		this.familyManager = familyManager;
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
		
		clone.name = this.name;
		clone.color = this.color;
		
		clone.resourceList = this.resourceList.clone();
		clone.familyManager = this.familyManager.clone();
		clone.cardManager = this.cardManager.clone();
		
		return clone;
	}
	
	/**<h3> boolean equals(Object) </h3>
	 * <p>Compara due giocatori, ritorna true se entrambi sono giocatori e hanno lo stesso colore</p>
	 * @return true se sono uguali, false altrimenti
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		
		if(this.getClass() == obj.getClass()){
			return((Player)obj).getName() == this.getName();
		}
		return false;
	}
	
	/**<h3> String toString() </h3>
	 * <p>Player [name= </p>
				<p>resourceList=</p>
				<p>familyManager=</p>
				<p>cardManager=</p>
				<p>]</p>
	 */
	@Override
	public String toString() {
		return "Player [name=" + name 
				+"\n resourceList=" + resourceList +"\n"
				+"\n familyManager=" + familyManager +"\n"
				+ "\n cardManager=" + cardManager + "\n" 
				+ "]";
	}
}