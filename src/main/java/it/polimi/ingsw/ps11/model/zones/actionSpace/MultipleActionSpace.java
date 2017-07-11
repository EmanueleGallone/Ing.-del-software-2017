package it.polimi.ingsw.ps11.model.zones.actionSpace;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import it.polimi.ingsw.ps11.model.player.Player;
/**
 *<h3>MultipleActionSpace</h3>
 *<p> Classe che rappresenta lo spazio azione del gioco dove e' possibile posizionare più di familiare, a patto che siano di giocatori diversi
 *o siano del tipo NeutralFamilyMember. </p>
 */
public class MultipleActionSpace implements Iterable<ActionSpace>, Serializable {

	protected final static int COST = 1;
	private int penality;
	protected ArrayList<ActionSpace> multipleActionSpace = new ArrayList<>();
	
	public MultipleActionSpace() {
		this(COST);
	}
	
	public MultipleActionSpace(int penality) {
		this.penality = penality;
	}
	
	/**<h3> ActionSpace getFreeSpace </h3>
	 * <p> Restituisce il primo actionSpace vuoto, se non sono presenti, ne crea uno nuovo.</p>
	 */
	public ActionSpace getFreeSpace(){
		for(ActionSpace space : multipleActionSpace){
			if(space.isFree())
				return space;
		}
		ActionSpace space = new ActionSpace(penality);
		space.setPenality(penality);
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
	
	public ActionSpace getActionSpace(int index) throws IllegalArgumentException{
		if (index < multipleActionSpace.size()){
			return multipleActionSpace.get(index);
		}
		throw new IllegalArgumentException();
	}
	
	public ArrayList<ActionSpace> getAllSpace() {
		return multipleActionSpace;
	}
	
	@Override
	public Iterator<ActionSpace> iterator() {
		return multipleActionSpace.iterator();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		boolean result = false;
		if(obj.getClass().equals(this.getClass())){
			MultipleActionSpace aSpace = (MultipleActionSpace) obj;
			result = this.penality == aSpace.penality;
			if(this.multipleActionSpace.size() != aSpace.multipleActionSpace.size() || !result)
				return false;
			
			for(int i=0; i < multipleActionSpace.size(); i++){
				if(!multipleActionSpace.get(i).equals(aSpace.multipleActionSpace.get(i)))
					return false;
			}
		}
		return result;
	}
	
	@Override
	public MultipleActionSpace clone(){
		MultipleActionSpace clone = new MultipleActionSpace(penality);
		
		for(ActionSpace a : this.multipleActionSpace){
			if(a != null)
				clone.addActionSpace(a.clone());
		}
		
		return clone;
	}

}
