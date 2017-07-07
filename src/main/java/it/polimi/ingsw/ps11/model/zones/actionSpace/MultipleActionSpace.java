package it.polimi.ingsw.ps11.model.zones.actionSpace;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.player.Player;
/**
 *<h3>MultipleActionSpace</h3>
 *<p> Classe che rappresenta lo spazio azione del gioco dove e' possibile posizionare più di familiare, a patto che siano di giocatori diversi
 *o siano del tipo NeutralFamilyMember. </p>
 */
public class MultipleActionSpace implements Iterable<ActionSpace>, Serializable {

	protected final int COST = 1;
	private int cost;
	protected ArrayList<ActionSpace> multipleActionSpace = new ArrayList<>();
	
	public MultipleActionSpace() {
		cost = COST;
	}
	
	public MultipleActionSpace(int cost) {
		this.cost = cost;
	}
	
	/**<h3> ActionSpace getFreeSpace </h3>
	 * <p> Restituisce il primo actionSpace vuoto, se non sono presenti, ne crea uno nuovo.</p>
	 */
	public ActionSpace getFreeSpace(){
		for(ActionSpace space : multipleActionSpace){
			if(space.isFree())
				return space;
		}
		ActionSpace space = new ActionSpace(cost);
		multipleActionSpace.add(space);
		return space;
	}
	
	/**<h3>public boolean contains(Player player) </h3>
	 * <p>
	 * Metodo che fa uso di equals per stabilire se il MultipleActionSpace contiene il player passato come paramentro.
	 * </p>
	 * @param player e' il giocatore da comparare.
	 * @return <code>True</code> se il MultipleActionSpace contiene il giocatore, <code>False</code> altrimenti.
	 */
	public boolean contains(Player player){
		for(ActionSpace a: multipleActionSpace){
			if(a.getOwner() != null && a.getOwner().equals(player) ){
				return true;
			}
		}
		return false;
	}

	/**
	 * <h3>public void addActionSpace(ActionSpace actionSpace)</h3>
	 * <p> Metodo che permette l'aggiunta di un ActionSpace.
	 * @param actionSpace e' l'ActionSpace da aggiungere
	 */
	public void addActionSpace(ActionSpace actionSpace){
		multipleActionSpace.add(actionSpace);
	}
	
	
	public void clean(){
		for(ActionSpace space : this){
			space.clean();
		}
	}
	
	public ActionSpace getActionSpace(int index){
		if (index < multipleActionSpace.size()){
			return multipleActionSpace.get(index);
		}
		return null;
	}
	
	public ArrayList<ActionSpace> getAllSpace() {
		return multipleActionSpace;
	}
	
	@Override
	public Iterator<ActionSpace> iterator() {
		return multipleActionSpace.iterator();
	}
	
	@Override
	public MultipleActionSpace clone(){
		MultipleActionSpace clone = new MultipleActionSpace();
		
		for(ActionSpace a : this.multipleActionSpace){
			if(a != null)
				clone.addActionSpace(a.clone());
		}
		
		return clone;
	}

}
