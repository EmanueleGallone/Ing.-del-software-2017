package it.polimi.ingsw.ps11.model.zones.towers;

import java.io.Serializable;
import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.zones.Floor;
/**
 * <h3>Tower</h3>
 * <p> contiene al suo interno una List di Floor. Ogni torre avrà esattamente 4 Floor all'interno. </p>
 * @see Floor
 *
 */
public class Tower implements Serializable{
	
	private static final int MAX_FLOORS = 4;
	private ArrayList<Floor> floors = new ArrayList<>();
	
	
// Start constructors
	
	public Tower() {

	}
	
	public Tower(ArrayList<Floor> floors) {
		this.floors = floors;
	}
	
// End constructors
// Start logic
	/**<h3>addFloor</h3>
	 * <p>
	 * Metodo che permette l'aggiunta di un Floor. Nel caso la torre avesse già 4 Floor, la chiamata di questa funziona non apporta cambiamenti.
	 * </p>
	 * @param floor è l'oggetto Floor da inserire nella Tower
	 */
	public void addFloor(Floor floor){
		if (floors.size() < MAX_FLOORS ){
			floors.add(floor);
		}
	}
	
	public Floor getFloor(int index){
		if(index < floors.size()){
			return floors.get(index);	
		}
		throw new IllegalArgumentException("Non hai selezionato un piano corretto");
	}
	
	/*
	public boolean contains(Player player){
		// Ritorna true se c'e' un familyMember di un giocatore che non sia il familiare neutro
		for(Floor floor : floors){
			ActionSpace aSpace = floor.getActionSpace();
			if (aSpace.getOwner().equals(player) && aSpace.getFamilyMember().getClass() != NeutralFamilyMember.class){
				return true;
			}
		}
		return false;
	}
	*/
	
	public boolean isFree(){
		for(Floor floor : floors){
			if (!floor.getActionSpace().isFree()){
				return false;
			}
		}
		return true;
	}
	
// End logic
	

// Start getters
	public ArrayList<Floor> getFloors() {
		return floors;
	}
	
	public static int getMaxFloors() {
		return MAX_FLOORS;
	}
	
// End getters

	@Override
	public String toString() {
		return "Tower [floors=" + floors + "]";
	}
	
	@Override
	public Tower clone(){
		Tower clone = new Tower();
		
		for(Floor f : this.floors){
			System.out.println("ho clonato");
			clone.addFloor(f.clone());
		}
		
		return clone;
	}
	

}
