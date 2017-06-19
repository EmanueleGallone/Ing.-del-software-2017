package it.polimi.ingsw.ps11.model.zones.actionSpace;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.player.Player;
/**
 *<h3>MultipleActionSpace</h3>
 *<p> Oggetto che permette il posizionamento di più FamilyMember all'interno. Esso contiene una List di ActionSpace. </p>
 */
public class MultipleActionSpace implements FamilyMemberSpace,Iterable<ActionSpace>, Serializable {

	protected ArrayList<ActionSpace> multipleActionSpace = new ArrayList<>();
	
	public MultipleActionSpace() {
		
	}
	
	@Override
	public boolean placeFamilyMember(FamilyMember familyMember, Player player) {
		ActionSpace actionSpace = new ActionSpace(3);
		if(actionSpace.placeFamilyMember(familyMember, player)){
			multipleActionSpace.add(actionSpace);
			return true;
		}
		return false;
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
