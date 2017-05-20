package it.polimi.ingsw.ps11.cranio.zones.towers;

import java.util.ArrayList;
import java.util.Iterator;

import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.zones.Floor;
public class Tower implements Iterable<Floor> {
	
	private final int MAX_FLOORS = 4;
	private ArrayList<Floor> floors = new ArrayList<>();
	private Class<? extends DevelopmentCard> type;
	
// Start constructors
	
	public Tower() {

	}
	
	public Tower(ArrayList<Floor> floors) {
		this.floors = floors;
	}
	
// End constructors
// Start logic
	
	public void addFloor(Floor floor){
		if (floors.size() < MAX_FLOORS && floor.getType() == type){
			floors.add(floor);
		}
	}
	
	public Floor selectFloor(int index){
		return floors.get(index);
	}
	
// End logic
	
// Start setters
	
	public void setType(Class<? extends DevelopmentCard> type) {
		this.type = type;
	}
	
// End setters
// Start getters
	public ArrayList<Floor> getFloors() {
		return floors;
	}
	
	public int getMaxFloors() {
		return MAX_FLOORS;
	}
	
	public Class<? extends DevelopmentCard> getType() {
		return type;
	}
// End getters
	
// __________________________

	@Override
	public Iterator<Floor> iterator() {
		Iterator<Floor> iterator = new Iterator<Floor>() {
			
			private int nextFloor = MAX_FLOORS;
			
			@Override
			public boolean hasNext() {
				if (floors.get(nextFloor) == null)
					return false;
				return true;
			}

			@Override
			public Floor next() {
				Floor floor =  floors.get(nextFloor);
				nextFloor--;
				return floor;
			}
		};
		
		return iterator ;
		
	}

}
