package it.polimi.ingsw.ps11.cranio.zones;

public class Board {
	
	private Tower greenTower;
	private Tower blueTower;
	private Tower yellowTower;
	private Tower purpleTower;
	
	private Harvest harvest = new Harvest();
	private Production production = new Production();
		
	private Market market = new Market();
	
// Start constructors
	public Board() {
		
	}
// End constructors
// Start setters
	
	public void setGreenTower(Tower greenTower) {
		this.greenTower = greenTower;
	}
	
	public void setBlueTower(Tower blueTower) {
		this.blueTower = blueTower;
	}
	
	public void setYellowTower(Tower yellowTower) {
		this.yellowTower = yellowTower;
	}
	
	public void setPurpleTower(Tower purpleTower) {
		this.purpleTower = purpleTower;
	}
	
// End setters
// Start getters
	
	public Tower getGreenTower() {
		return greenTower;
	}
	
	public Tower getBlueTower() {
		return blueTower;
	}
	
	public Tower getYellowTower() {
		return yellowTower;
	}
	
	public Tower getPurpleTower() {
		return purpleTower;
	}
	
// End getters



}
