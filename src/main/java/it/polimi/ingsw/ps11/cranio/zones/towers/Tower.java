package it.polimi.ingsw.ps11.cranio.zones.towers;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.zones.Floor;

public class Tower {
	
	private static final int MAX_FLOORS = 4;
	private ArrayList<Floor> floors = new ArrayList<>();
	
	
// Start constructors
	
	public Tower() {

	}
	
	public Tower(ArrayList<Floor> floors) {
		this.floors = floors;
	}
	
	private Tower(Tower toCopy){
		//copy Constructor
		for(Floor f : toCopy.floors)
			this.addFloor(f.clone());
	}
	
// End constructors
// Start logic
	
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
		return new Tower(this);
	}
	

}
