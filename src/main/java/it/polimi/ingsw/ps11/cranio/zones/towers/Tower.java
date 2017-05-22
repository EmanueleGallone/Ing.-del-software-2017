package it.polimi.ingsw.ps11.cranio.zones.towers;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.cards.productionCard.ProductionCard;
import it.polimi.ingsw.ps11.cranio.zones.Floor;

public class Tower {
	
	private final int MAX_FLOORS = 4;
	private ArrayList<Floor> floors = new ArrayList<>();
	
	
// Start constructors
	
	public Tower() {

	}
	
	public Tower(ArrayList<Floor> floors) {
		this.floors = floors;
	}
	
// End constructors
// Start logic
	
	public void addFloor(Floor floor){
		if (floors.size() < MAX_FLOORS ){
			floors.add(floor);
		}
	}
	
	public Floor selectFloor(int index){
		return floors.get(index);
	}
	
// End logic
	
// Start setters
	
	
	
// End setters
// Start getters
	public ArrayList<Floor> getFloors() {
		return floors;
	}
	
	public int getMaxFloors() {
		return MAX_FLOORS;
	}
	
	
// End getters

	@Override
	public String toString() {
		return "Tower [floors=" + floors + "]";
	}
	

	

}