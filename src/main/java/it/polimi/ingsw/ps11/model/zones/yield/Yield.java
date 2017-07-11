package it.polimi.ingsw.ps11.model.zones.yield;

import java.io.Serializable;
import java.util.Iterator;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.actionSpace.MultipleActionSpace;
/**
 * <h3> Yield </h3>
 * <p> Classe che raggruppa le zone Raccolta e Produzione del gioco, possiede un un single e un multiple action space. il valore del familiare
 * posizionato sul single actionspace non riceve penalità all'attivazione della zona, mentre i familiari sul multiple actionspace ricevono
 * un malus di -3 sul valore del familiare all'attivazione della zona. Sono identificati da una string che rappresenta l'Id del tipo di
 * carta presente nel cardManager di un giocatore che il cui bonus viene attivato all'attivazione della zona.</p>
 */
public class Yield implements Serializable, Iterable<ActionSpace> {
	
	private final int PENALITY = 3;
	private ActionSpace singleActionSpace = new ActionSpace();
	private MultipleActionSpace multipleActionSpace = new MultipleActionSpace(PENALITY);
	private String cardType;
	
	public Yield(String cardType) {
		this.cardType = cardType;
	}
	
	/**<h3> ActionSpace getFreeSpace() </h3>
	 * <p> Restituisce il single actionspace se questo è vuoto, altrimenti prende un actionspace libero del multiple actionspace</p>
	 */
	public ActionSpace getFreeSpace(){
		if(singleActionSpace.isFree())
			return singleActionSpace;
		return multipleActionSpace.getFreeSpace();
	}
	
	
	public void resetFamilyMember(){
		for(ActionSpace aSpace: this){
			aSpace.clean();
		}
	}
	
	public String getActiveCard(){
		return cardType;
	}
	
	public ActionSpace getSingleActionSpace() {
		return singleActionSpace;
	}
	public MultipleActionSpace getMultipleActionSpace() {
		return multipleActionSpace;
	}
	
	public boolean search(Player player){
		for(ActionSpace aSpace : this){
			FamilyMember familyMember = aSpace.getFamilyMember();
			Player owner = aSpace.getOwner();
			if(familyMember!=null && !familyMember.isNeutral()){
				if(owner!= null && owner.equals(player))
					return true;
				}
		}
		return false;
	}
	
	@Override
	public Yield clone(){
		//NB: i singleActionSpace e i Multiple non sono mai null; inutile un controllo
		Yield clone = new Yield(this.cardType);
	
		clone.singleActionSpace = this.singleActionSpace.clone();
		clone.multipleActionSpace = this.multipleActionSpace.clone();
		
		return clone;
	}

	@Override
	public Iterator<ActionSpace> iterator() {

		Iterator<ActionSpace> iter = new Iterator<ActionSpace>() {
			
			private int index = 0;
			private Iterator<ActionSpace> multipleIterator = multipleActionSpace.iterator();
			
			@Override
			public boolean hasNext() {
				if(index == 0 && singleActionSpace != null)
					return true;
				return multipleIterator.hasNext();
			}

			@Override
			public ActionSpace next() {
				if(index == 0 && singleActionSpace != null){
					index++;
					return singleActionSpace;
				}
				return multipleIterator.next();
			}
		};
		return iter;
	}
}
