package it.polimi.ingsw.ps11.model.zones.towers;

import java.io.Serializable;
import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.zones.Floor;
/**
 * <h3>Tower</h3>
 * <p> Classe che rappresenta le torri del gioco. Per ogni torre è stata implementata una classe apposita, identificata dal tipo di carta
 * che può contenere. Ogni torre ha esattamente 4 piani.</p>
 * @see YellowTower
 * @see BlueTower
 * @see GreenTower
 * @see PurpleTower
 *
 */
public class Tower implements Serializable{
	
	private static final int MAX_FLOORS = 4;
	private ArrayList<Floor> floors = new ArrayList<>();
	private String name;
	
// Start constructors
	
	public Tower() {

	}
	
	public Tower(String cardId) {
		this.name = cardId;
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
	
	public void resetFloors(){
		for(Floor floor: floors){
			floor.clean();
		}
	}
	
	
	public void setCardType(Class<? extends DevelopmentCard> cardType) {
		this.name = cardType.toString();
	}
	
	public Floor getFloor(int index){
		if(index < floors.size()){
			return floors.get(index);	
		}
		throw new IllegalArgumentException("Non hai selezionato un piano corretto");		
	}
	
	public ArrayList<DevelopmentCard> setCard(ArrayList<DevelopmentCard> cards){
		ArrayList<DevelopmentCard> cardUsed = new ArrayList<>();
		for(int i = 0; i < floors.size() && i < cards.size(); i++){
			DevelopmentCard card = cards.get(i);
			floors.get(i).setCard(card);
			cardUsed.add(card);
		}
		return cardUsed;
	}
	
	/** <p> Indica se la torre ha tutti gli actionspace vuoti. </p>
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
	
	public String getName() {
		return name;
	}
	
// End getters
	
	/**<h3> String toString() </h3>
	 * <p> TIPOTORRE [floors= ]</p>
	 */
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "[floors=" + floors + "]";
	}
	
	@Override
	public Tower clone(){
		Tower clone = new Tower();
		clone.getFloors().clear();
		
		for(Floor f : this.floors){
			if(f != null)
				clone.addFloor(f.clone());
		}
		
		return clone;
	}
	

}
