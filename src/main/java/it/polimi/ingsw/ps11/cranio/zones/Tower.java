package it.polimi.ingsw.ps11.cranio.zones;

import java.util.ArrayList;

import gioco.da.console.resources.MilitaryPoint;

public class Tower<FLOOR_TYPE> {
	
	private final int MAX_FLOORS = 4;
	private ArrayList<Floor> floors = new ArrayList<>();
	
	public Tower(ArrayList<Floor> floors) {
		this.floors = floors;
	}
	
	private void addFloor(Floor floor){
		floors.add(floor);
	}
}
