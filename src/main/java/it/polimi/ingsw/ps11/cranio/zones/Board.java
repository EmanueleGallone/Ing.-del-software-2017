package it.polimi.ingsw.ps11.cranio.zones;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.zones.towers.Tower;

public class Board {
	
	
	//Vorrei usare una map che ha come chiave un enum di colori...
	private ArrayList<Tower> towers = new ArrayList<>();
	
	private Harvest harvest = new Harvest();
	private Production production = new Production();
		
	private Market market = new Market();
	
// Start constructors
	
	public Board() {
		
	}
	
// End constructors
// Start setters
	
	public void addTower(Tower tower){
		towers.add(tower);
	}
	
// End setters
// Start getters

	
// End getters



}
