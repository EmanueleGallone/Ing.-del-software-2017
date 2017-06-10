package it.polimi.ingsw.ps11.cranio.zones;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.zones.actionSpace.ActionSpace;

public class Market {
	
	private ArrayList<ActionSpace> market = new ArrayList<>();
	
	public Market() {
		
	}
	
	public Market(ArrayList<ActionSpace> market) {
		this.market = market;
	}
	
}
